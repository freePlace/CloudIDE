package org.freeplace.cloudide.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Ruslan on 04.12.2015.
 */
public interface GenericDAO<T, PK extends Serializable> {
    T findById(PK key);
    void create(T entity);
    void update(T entity);
    void delete(T entity);
    List<T> findAll();
    List<T> findByColumnValue(Object value, String columnName);
    T findByUniqueColumnValue(Object value, String columnName);
}
