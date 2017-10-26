package com.product.project.services;

import com.product.project.dao.ProductDAO;
import com.product.project.entities.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by nonal on 17.10.2017.
 */
@Service
public class ProductService {

    private ProductDAO productDao;

    @Autowired
    public ProductService(ProductDAO productDao) {
        this.productDao = productDao;
    }

    @Transactional(readOnly = true)
    public ProductEntity getById(Integer id) {
        return productDao.getById(ProductEntity.class, id);
    }

    @Transactional(readOnly = true)
    public List<ProductEntity> getAll() {
        return productDao.getAll(ProductEntity.class);
    }

    @Transactional
    public void save(ProductEntity entity) {
        productDao.save(entity);
    }

    @Transactional
    public void update(ProductEntity entity) {
        productDao.update(entity);
    }

    @Transactional
    public void remove(ProductEntity entity) {
        productDao.remove(entity);
    }
}
