package com.twedittor.service;

import com.twedittor.domain.User;
import com.twedittor.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sumanthdommaraju on 1/27/17.
 */
@Service
public class FollowingServiceImpl implements FollowingService {

    private final UserDao userDao;

    @Autowired
    public FollowingServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getFollowing(String uid) {
        return userDao.findUserByUserId("svd260").getFollowing().stream()
                .map(relationship -> relationship.getFollowed()).collect(Collectors.toList()); //TODO
    }
}
