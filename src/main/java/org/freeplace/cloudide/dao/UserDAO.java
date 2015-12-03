package org.freeplace.cloudide.dao;

import org.freeplace.cloudide.model.User;

import java.util.List;

/**
 * Created by Ruslan on 02.12.2015.
 */
public interface UserDAO {
    User findById(int id);
    void saveUser(User user);
    void deleteUserByLogin(String login);
    List<User> findAllUsers();
    User findUserByLogin(String login);
}