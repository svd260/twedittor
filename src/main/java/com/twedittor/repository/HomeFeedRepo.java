package com.twedittor.repository;

import com.twedittor.domain.Quote;
import com.twedittor.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sumanthdommaraju on 1/24/17.
 */

@Repository
public class HomeFeedRepo {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Quote> getFeed(String userId) {
        List<Quote> mockList = Arrays.asList(new Quote(){{
                                                 setUser(new User(){{setName("pinku");}}); setLikes(10); setReQoute(5);}},
                new Quote(){{
                    setUser(new User(){{setName("sumu");}}); setLikes(8); setReQoute(6);}});
        User user = new User();
        user.setName("sam");
        user.setUserId("abc");
        entityManager.persist(user);
        entityManager.flush();
        return mockList;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
