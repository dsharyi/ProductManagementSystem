package com.product.project.dao.impl;


import com.product.project.entities.UserEntity;
import com.product.project.dao.UserDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by nonal on 17.10.2017.
 */
@Repository
public class UserDAOImpl extends AbstractGeneralDAOImpl<Integer, UserEntity> implements UserDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public UserDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
        this.sessionFactory = sessionFactory;
    }

    @Override
    public UserEntity getByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select user from UserEntity user where user.email = :email", UserEntity.class).setParameter("email", email).getSingleResult();
    }
}
