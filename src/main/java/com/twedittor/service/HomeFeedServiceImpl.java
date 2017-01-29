package com.twedittor.service;

import com.twedittor.domain.Home;
import com.twedittor.domain.Quote;
import com.twedittor.domain.Relationship;
import com.twedittor.domain.User;
import com.twedittor.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
    public Home getFeed(String userName) {
        Home home = new Home();
        User user =  userDao.findUserByUserId(userName);
        List<Quote> feedQuotes = new ArrayList<>();
        List<Relationship> follwing = user.getFollowing();
        for(Relationship f : follwing) {
            feedQuotes.addAll(f.getFollowed().getQuotes());
        }
        Collections.sort(feedQuotes, Comparator.comparing(quote -> quote.getTimeStamp()));
//                user.getFollowing().stream().map(u -> u.getQuotes()).
//                            flatMap(quotesList -> quotesList.stream()).
//                            sorted(Comparator.comparing(quote -> quote.getTimeStamp())).collect(Collectors.toList());
        home.setFirstName(user.getFirstName());
        home.setLastName(user.getLastName());
        home.setQuotesFromFeed(feedQuotes);
        home.setFollowing(new Long(user.getFollowing().size()));  //TODO
        home.setFollowers(new Long(userDao.findFollowers(user).size())); //TODO
        return home;
    }
}
