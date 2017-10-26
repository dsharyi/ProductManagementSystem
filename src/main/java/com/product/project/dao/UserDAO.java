package com.product.project.dao;

import com.product.project.entities.UserEntity;

/**
 * Created by nonal on 17.10.2017.
 */
public interface UserDAO extends GeneralDAO<Integer,UserEntity> {

    UserEntity getByEmail(String email);
}
