package com.product.project.dao.impl;

import com.product.project.entities.ProductEntity;
import com.product.project.dao.ProductDAO;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by nonal on 17.10.2017.
 */
@Repository
public class ProductDAOImpl extends AbstractGeneralDAOImpl<Integer,ProductEntity> implements ProductDAO {

    @Autowired
    public ProductDAOImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
