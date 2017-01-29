package com.twedittor.service;

import com.twedittor.domain.User;
import com.twedittor.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sumanthdommaraju on 1/29/17.
 */
@Service
public class FollowerServiceImpl implements FollowerService {

    private final UserDao userDao;

    @Autowired
    public FollowerServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> findFollowers(String uid) {
        return userDao.findFollowers(userDao.findUserByUserId(uid));
    }
}
