package org.freeplace.cloudide.dao;

import org.apache.commons.lang3.ObjectUtils;
import org.freeplace.cloudide.applicationinfo.ApplicationData;
import org.freeplace.cloudide.model.Project;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.lang.reflect.ParameterizedType;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Ruslan on 02.12.2015.
 */
public class AbstractDAO<T, PK extends Serializable> {

    private final Class<T> persistentClass;

    @SuppressWarnings("unchecked")
    protected AbstractDAO() {
        this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    public T findById(PK key) {
        return (T) getSession().get(persistentClass, key);
    }

    public void create(T entity) {
        getSession().persist(entity);
    }

    public void update(T entity) { getSession().update(entity); }

    public void delete(T entity) {
        getSession().delete(entity);
    }

    public List<T> findAll() {
        return (List<T>) createEntityCriteria().list();
    }

    public List<T> findByColumnValue(Object value, String columnName) {
        return (List<T>) createEntityCriteria().add(Restrictions.eq(columnName, value)).list();
    }

    public T findByUniqueColumnValue(Object value, String columnName) {
        return (T) createEntityCriteria().add(Restrictions.eq(columnName, value)).uniqueResult();
    }

    protected Criteria createEntityCriteria() {
        return getSession().createCriteria(persistentClass);
    }
}