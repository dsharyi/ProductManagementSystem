package com.product.project.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by nonal on 17.10.2017.
 */
public interface GeneralDAO<K extends Serializable,V> {

    V getById(Class<? extends V> entityClass, K id);

    List<V> getAll(Class<? extends V> entityClass);

    void save(V entity);

    void update(V entity);

    void remove(V entity);
}