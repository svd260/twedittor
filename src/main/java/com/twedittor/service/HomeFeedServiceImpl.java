package com.twedittor.service;

import com.twedittor.domain.Quote;
import com.twedittor.repository.HomeFeedRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sumanthdommaraju on 1/24/17.
 */
@Service
@Transactional
public class HomeFeedServiceImpl implements IHomeFeedService{

    private HomeFeedRepo homeFeedRepo;

    @Autowired
    public HomeFeedServiceImpl(HomeFeedRepo homeFeedRepo) {
        this.homeFeedRepo = homeFeedRepo;
    }

    @Override
    public List<Quote> getFeed(String userId) {
        return homeFeedRepo.getFeed(userId);
    }
}
