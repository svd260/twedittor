package com.twedittor.repository;

import com.twedittor.domain.Quote;

import java.util.List;

/**
 * Created by sumanthdommaraju on 1/25/17.
 */
public interface HomeFeedDao {
    List<Quote> getFeed(String userId);
}
