package com.product.project.dao.impl;

import com.product.project.entities.UserRoleEntity;
import com.product.project.dao.UserRoleDAO;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by nonal on 17.10.2017.
 */
@Repository
public class UserRoleDAOImpl extends AbstractGeneralDAOImpl<Integer,UserRoleEntity> implements UserRoleDAO {

    @Autowired
    public UserRoleDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
