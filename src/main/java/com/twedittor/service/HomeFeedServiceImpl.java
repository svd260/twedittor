package com.twedittor.service;

import com.twedittor.domain.Quote;
import com.twedittor.domain.User;
import com.twedittor.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sumanthdommaraju on 1/24/17.
 */
@Service
public class HomeFeedServiceImpl implements HomeFeedService {

    private UserDao userDao;

    @Autowired
    public HomeFeedServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public List<Quote> getFeed(String userName) {
        User user =  userDao.findUserByUserId(userName);
        List<Quote> feedQuotes = user.getFollowing().stream().map(u -> u.getQuotes()).
                            flatMap(quotesList -> quotesList.stream()).
                            sorted(Comparator.comparing(quote -> quote.getTimeStamp())).collect(Collectors.toList());
        return feedQuotes;
    }
}
