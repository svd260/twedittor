package com.twedittor.service;

import com.twedittor.jms.Like;

import javax.jms.JMSException;

/**
 * Created by sumanthdommaraju on 2/10/17.
 */
public interface LikeDislikeListnerService {
    void likeDisLike(Like like) throws JMSException;
}
