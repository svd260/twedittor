package com.twedittor.service;

import com.google.common.base.Strings;
import com.twedittor.domain.Quote;
import com.twedittor.domain.User;
import com.twedittor.repository.QuoteDao;
import com.twedittor.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by sumanthdommaraju on 1/29/17.
 */
@Service
public class QuoteServiceImpl implements QuoteService {

    private final QuoteDao quoteDao;
    private final UserDao userDao;

    @Autowired
    public QuoteServiceImpl(QuoteDao quoteDao, UserDao userDao) {
        this.quoteDao = quoteDao;
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public Boolean post(Quote quote, String uid) {
        User user = userDao.findUserByUserId(uid);
        if(!Strings.isNullOrEmpty(quote.getMessage())) {
            quote.setUser(user);
            quote.setLikes(0);
            quote.setReQoute(0);
            quote.setTimeStamp(new Date(System.currentTimeMillis()));
            quoteDao.save(quote);
            return true;
        } else {
            return false;
        }
    }
}
