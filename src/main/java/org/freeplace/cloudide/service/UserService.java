package org.freeplace.cloudide.service;

import org.freeplace.cloudide.dao.UserDAOImpl;
import org.freeplace.cloudide.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Ruslan on 02.12.2015.
 */
@Service
@Transactional
public class UserService {

    @Autowired
    private UserDAOImpl userDAO;

    public List<User> findAllUsers() {
        return userDAO.findAllUsers();
    }

    public User findByLogin(String login) {
        return new UserDAOImpl().findUserByLogin(login);
    }
}
