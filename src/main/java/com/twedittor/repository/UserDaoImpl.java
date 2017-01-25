package com.twedittor.repository;

import com.twedittor.domain.User;
import org.springframework.stereotype.Repository;

/**
 * Created by sumanthdommaraju on 1/25/17.
 */
@Repository
public class UserDaoImpl extends AbstractDao<User> implements UserDao {


    @Override
    public User findUserByUserId(String userId) {
        return getResultForQuery("SELECT u FROM User u WHERE u.userId = :uid", new String[]{"uid"}, new Object[]{userId});
    }

}
