package com.twedittor.service;

import com.twedittor.domain.Quote;
import com.twedittor.domain.User;
import com.twedittor.jms.Like;
import com.twedittor.repository.QuoteDao;
import com.twedittor.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.jms.JMSException;

/**
 * Created by sumanthdommaraju on 2/9/17.
 */

@Component
public class LikeDislikeListnerServiceImpl implements LikeDislikeListnerService {

    private final QuoteDao quoteDao;
    private final UserDao userDao;

    @Autowired
    public LikeDislikeListnerServiceImpl(QuoteDao quoteDao, UserDao userDao) {
        this.quoteDao = quoteDao;
        this.userDao = userDao;
    }



    @JmsListener(containerFactory = "myFactory", destination = "likes.queue")
    @Transactional
    @Override
    public void likeDisLike(Like like) throws JMSException {
        Quote quote = quoteDao.findById(like.getQuoteId());
        User user = userDao.findUserByUserId(like.getUserId());
        if(like.getLike()) {
            quote.getLikers().add(user);
            //quote.getLiker().add(like.getUserId);
        } else {
            quote.getLikers().remove(user);
            //quote.getLiker().remove(like.getUserId);

        }
        quoteDao.save(quote);
    }
}
