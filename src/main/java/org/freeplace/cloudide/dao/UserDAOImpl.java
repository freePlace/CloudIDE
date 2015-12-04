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
public class UserDAOImpl extends AbstractDAO<User, Integer> implements UserDAO {
    @Override
    public User findUserByLogin(String login) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq(User.COLUMN_LOGIN, login));
        return (User) criteria.uniqueResult();
    }
}