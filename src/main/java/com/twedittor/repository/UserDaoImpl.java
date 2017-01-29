package com.twedittor.repository;

import com.twedittor.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sumanthdommaraju on 1/25/17.
 */
@Repository
public class UserDaoImpl extends AbstractDao<User> implements UserDao {


    @Override
    public User findUserByUserId(String userName) {
        User user = null;
        try {   //TODO
            user = getResultForQuery("SELECT u FROM User u WHERE u.userName = :userName", new String[]{"userName"}, new Object[]{userName});
        } catch (Exception e) {
            //TODO log
        }

        return user;
    }

    @Override
    public List<User> findFollowers(User user) {
        return getResultListForNamedQuery("User.findFollowers", new String[]{"uid"}, new Object[]{user});
    }

}
