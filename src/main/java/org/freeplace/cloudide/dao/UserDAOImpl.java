package org.freeplace.cloudide.dao;

import org.freeplace.cloudide.model.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Ruslan on 02.12.2015.
 */
@Repository
public class UserDAOImpl extends AbstractDAO<Integer, User> implements UserDAO {

    @Override
    public User findById(int id) {
        return getByKey(id);
    }

    @Override
    public void saveUser(User user) {
        persist(user);
    }

    @Override
    public void deleteUserByLogin(String login) {
        Query query = getSession().createSQLQuery("delete from user where login = :login");
        query.setString(User.COLUMN_LOGIN, login);
        query.executeUpdate();

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> findAllUsers() {
        Criteria criteria = createEntityCriteria();
        return criteria.list();
    }

    @Override
    public User findUserByLogin(String login) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq(User.COLUMN_LOGIN, login));
        return (User) criteria.uniqueResult();
    }

}