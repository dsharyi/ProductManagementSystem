package com.product.project.dao.impl;

import com.product.project.dao.GeneralDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.util.List;

/**
 * Created by nonal on 17.10.2017.
 */
public abstract class AbstractGeneralDAOImpl<K extends Serializable, V> implements GeneralDAO<K, V> {



    private SessionFactory sessionFactory;

    public AbstractGeneralDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public V getById(Class<? extends V> entityClass, K id) {
        return getSession().get(entityClass, id);
    }

    @SuppressWarnings("unchecked")
    public List<V> getAll(Class<? extends V> entityClass) {
        return (List<V>) getSession().createCriteria(entityClass).list();
    }

    public void save(V entity) {
        getSession().save(entity);
    }

    public void update(V entity) {
        getSession().update(entity);
    }

    public void remove(V entity) {
        getSession().delete(entity);
    }
}
