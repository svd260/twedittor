package com.twedittor.service;

import com.twedittor.domain.User;

import java.util.List;

/**
 * Created by sumanthdommaraju on 1/29/17.
 */
public interface FollowerService {
    List<User> findFollowers(String uid);
}
