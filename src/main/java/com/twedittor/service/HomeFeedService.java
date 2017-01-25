package com.twedittor.service;

import com.twedittor.domain.Quote;

import java.util.List;

/**
 * Created by sumanthdommaraju on 1/25/17.
 */
public interface HomeFeedService {

    List<Quote> getFeed(String userId);
}
