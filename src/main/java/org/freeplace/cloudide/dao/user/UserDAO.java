package org.freeplace.cloudide.dao.user;

import org.freeplace.cloudide.dao.AbstractDAO;
import org.freeplace.cloudide.model.user.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO extends AbstractDAO<User, Integer> {}