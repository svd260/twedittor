package com.twedittor.repository;


import com.twedittor.domain.User;

/**
 * Created by sumanthdommaraju on 1/25/17.
 */
public interface UserDao  {
    User findUserByUserId(String userId);
}
