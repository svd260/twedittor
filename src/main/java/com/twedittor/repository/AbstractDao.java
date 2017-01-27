package com.twedittor.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * Created by sumanthdommaraju on 1/25/17.
 */
public class AbstractDao<T> {

    @PersistenceContext
    private EntityManager entityManager;

    protected void save(T t) {
        entityManager.persist(t);
    }

    protected T getResultForQuery(String s, String[] parameterNames, Object[] parameterValues) {
        Query query = entityManager.createQuery(s);
        if(parameterNames.length != parameterValues.length) {
            throw new IllegalArgumentException("query's parameterNames list should match with parameterValues");
        }
        for(int i = 0; i < parameterNames.length; i++) {
            query.setParameter(parameterNames[i], parameterValues[i]);
        }
        return  (T) query.getSingleResult();
    }

    protected List<T> getResultListForNamedQuery(String queryName, String[] parameterNames, Object[] parameterValues) {
        Query query = entityManager.createNamedQuery(queryName);
        if(parameterNames.length != parameterValues.length) {
            throw new IllegalArgumentException("query's parameterNames list should match with parameterValues");
        }
        for(int i = 0; i < parameterNames.length; i++) {
            query.setParameter(parameterNames[i], parameterValues[i]);
        }
        return (List<T>) query.getResultList();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public CriteriaBuilder getCriteriaBuilder() {
        return entityManager.getCriteriaBuilder();
    }
}
