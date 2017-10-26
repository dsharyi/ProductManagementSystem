package com.product.project.services;

import com.product.project.dao.UserDAO;
import com.product.project.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by nonal on 17.10.2017.
 */
@Service
public class UserService {

    private UserDAO userDao;

    @Autowired
    public UserService(UserDAO userDao) {
        this.userDao = userDao;
    }

    @Transactional(readOnly = true)
    public UserEntity getById(Integer id) {
        return userDao.getById(UserEntity.class, id);
    }

    @Transactional(readOnly = true)
    public UserEntity getByEmail(String email) {
        return userDao.getByEmail(email);
    }

    @Transactional(readOnly = true)
    public List<UserEntity> getAll() {
        return userDao.getAll(UserEntity.class);
    }

    @Transactional
    public void save(UserEntity entity) {
        userDao.save(entity);
    }

    @Transactional
    public void update(UserEntity entity) {
        userDao.update(entity);
    }

    @Transactional
    public void remove(UserEntity entity) {
        userDao.remove(entity);
    }
}