package com.twedittor.service;

import com.twedittor.domain.Quote;
import com.twedittor.jms.Like;
import com.twedittor.repository.QuoteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.jms.JMSException;

/**
 * Created by sumanthdommaraju on 2/9/17.
 */

@Component
public class LikeDislikeListnerService {

    private final QuoteDao quoteDao;

    @Autowired
    public LikeDislikeListnerService(QuoteDao quoteDao) {
        this.quoteDao = quoteDao;
    }



    @JmsListener(containerFactory = "myFactory", destination = "likes.queue")
    @Transactional
    public void likeDisLike(Like like) throws JMSException {
        Quote quote = quoteDao.findById(like.getQuoteId());
        if(like.getLike()) {
            quote.setLikes(quote.getLikes() + 1);
            //quote.getLiker().add(like.getUserId);
        } else {
            quote.setLikes(quote.getLikes() - 1);
            //quote.getLiker().remove(like.getUserId);

        }
        quoteDao.save(quote);
    }
}
