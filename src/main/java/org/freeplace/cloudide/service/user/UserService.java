package org.freeplace.cloudide.service.user;

import org.freeplace.cloudide.configuration.security.Roles;
import org.freeplace.cloudide.dao.user.RoleDAO;
import org.freeplace.cloudide.dao.user.UserDAO;
import org.freeplace.cloudide.model.user.User;
import org.freeplace.cloudide.service.authorization.ApplicationAuthenticationManager;
import org.freeplace.cloudide.service.logging.Loggable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

/**
 * Created by Ruslan on 02.12.2015.
 */
@Service
@Transactional
public class UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    private ApplicationAuthenticationManager applicationAuthenticationManager;

    @Loggable
    public void authorize(String login, String password) {
        Authentication request = new UsernamePasswordAuthenticationToken(login, password);
        Authentication result = applicationAuthenticationManager.authenticate(request);
        if(result.isAuthenticated())
            SecurityContextHolder.getContext().setAuthentication(result);
    }

    @Loggable
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
    }

    @Loggable
    public void createUser(User user) {
        user.setRole(roleDAO.findOneByColumnValue("name", Roles.ROLE_USER.name()));
        userDAO.create(user);
    }
}
