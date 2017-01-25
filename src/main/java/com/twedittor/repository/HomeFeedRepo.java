package com.twedittor.repository;

import com.twedittor.domain.Quote;
import com.twedittor.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

/**
 * Created by sumanthdommaraju on 1/24/17.
 */

@Repository
public class HomeFeedRepo {

    public List<Quote> getFeed(String userId) {
        List<Quote> mockList = Arrays.asList(new Quote(){{setQuotedBy(new User(){{setName("pinku");}}); setLikes(10); setReQoute(5);}},
                new Quote(){{setQuotedBy(new User(){{setName("sumu");}}); setLikes(8); setReQoute(6);}});
        return mockList;
    }
}