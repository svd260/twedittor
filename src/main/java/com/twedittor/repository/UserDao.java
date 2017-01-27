package com.twedittor.repository;


import com.twedittor.domain.User;

import java.util.List;

/**
 * Created by sumanthdommaraju on 1/25/17.
 */
public interface UserDao  {
    User findUserByUserId(String userId);
    List<User> findFollowers(Long uid);
}
