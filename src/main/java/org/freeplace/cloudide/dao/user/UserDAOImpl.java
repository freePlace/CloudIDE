package org.freeplace.cloudide.dao.user;

import org.freeplace.cloudide.dao.AbstractDAO;
import org.freeplace.cloudide.model.user.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Created by Ruslan on 02.12.2015.
 */
@Repository
public class UserDAOImpl extends AbstractDAO<User, Integer> implements UserDAO {
}