package com.twedittor.service;

import com.twedittor.domain.User;

import java.util.List;

/**
 * Created by sumanthdommaraju on 1/27/17.
 */
public interface FollowingService {
     List<User> getFollowing(String uid);
}
