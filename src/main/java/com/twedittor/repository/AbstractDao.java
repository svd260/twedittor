package com.twedittor.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by sumanthdommaraju on 1/25/17.
 */
public class AbstractDao<T> {

    @PersistenceContext
    private EntityManager entityManager;

    protected void save(T t) {
        entityManager.persist(t);
    }


    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
