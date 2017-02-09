package com.twedittor.service;

import com.twedittor.jms.Like;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by sumanthdommaraju on 2/9/17.
 */
@Service
public class LikeService {

    @Value("${likes.destination}")
    private String likesQueue;

    private final JmsTemplate jmsTemplate;

    @Autowired
    public LikeService(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void incrementLike(Long quoteId, String userId) {
        Like like = new Like(quoteId, userId, true);
        jmsTemplate.convertAndSend(likesQueue, like);
    }

    public void decrementLike(Long quoteId, String userId) {
        Like like = new Like(quoteId, userId, false);
        jmsTemplate.convertAndSend(likesQueue, like);
    }


}
