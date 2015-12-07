package org.freeplace.cloudide.service.user;

import org.freeplace.cloudide.dao.user.UserDAOImpl;
import org.freeplace.cloudide.model.user.User;
import org.freeplace.cloudide.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by Ruslan on 02.12.2015.
 */
@Service
@Transactional
public class UserService extends AbstractService<User, Integer> {
    @Autowired
    private UserDAOImpl dao;
}
