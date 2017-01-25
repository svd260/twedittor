package com.twedittor.service;

import com.twedittor.domain.Quote;
import com.twedittor.repository.HomeFeedRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sumanthdommaraju on 1/24/17.
 */
@Service
public class HomeFeedService {

    private HomeFeedRepo homeFeedRepo;

    @Autowired
    public HomeFeedService(HomeFeedRepo homeFeedRepo) {
        this.homeFeedRepo = homeFeedRepo;
    }

    public List<Quote> getFeed(String userId) {
        return homeFeedRepo.getFeed(userId);
    }
}
