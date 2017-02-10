package com.twedittor.service;

/**
 * Created by sumanthdommaraju on 2/10/17.
 */
public interface LikeService {

    void incrementLike(Long quoteId, String userId);

    void decrementLike(Long quoteId, String userId);
}
