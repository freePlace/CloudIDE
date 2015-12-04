package org.freeplace.cloudide.dao;

import org.freeplace.cloudide.model.User;

import java.util.List;

/**
 * Created by Ruslan on 02.12.2015.
 */
public interface UserDAO  extends GenericDAO<User,Integer>  {
    User findUserByLogin(String login);
}