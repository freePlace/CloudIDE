package org.freeplace.cloudide.controller;

import org.freeplace.cloudide.applicationinfo.Path;
import org.freeplace.cloudide.model.user.User;
import org.freeplace.cloudide.model.user.UserAccount;
import org.freeplace.cloudide.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.management.relation.Role;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Ruslan on 02.12.2015.
 */
@Controller
@RequestMapping
public class AppController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = Path.SLASH, method = RequestMethod.GET)
    public String getWelcomePage(ModelMap model) {
        //example how we can lazy init objects
        //List<User> users = userService.findAll(Role.class, UserAccount.class);
        //model.addAttribute(Attribute.USERS, users);
        return Path.REDIRECT + Page.MAIN;
    }

    @RequestMapping(value = Path.SLASH + Page.MAIN, method = RequestMethod.GET)
    public String getMainPage(ModelMap model) {
        return Page.MAIN;
    }

    @RequestMapping(value= Path.SLASH + Page.LOGOUT, method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return Path.REDIRECT + Page.MAIN;
    }
}