package org.freeplace.cloudide.controller;

import org.freeplace.cloudide.applicationinfo.Path;
import org.freeplace.cloudide.service.navigation.NavigationPanelService;
import org.freeplace.cloudide.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Ruslan on 02.12.2015.
 */
@Controller
@RequestMapping
public class AppController {

    @Autowired
    private UserService userService;

    @Autowired
    private NavigationPanelService navigationPanelService;

    @RequestMapping(value = Path.SLASH, method = RequestMethod.GET)
    public String getWelcomePage() {
        return Path.REDIRECT + Page.MAIN;
    }

    @RequestMapping(value = Path.SLASH + Page.LOGIN, method = RequestMethod.GET)
    public String getLoginPage() {
        return Page.LOGIN;
    }

    @RequestMapping(value = Path.SLASH + Page.MAIN, method = RequestMethod.GET)
    public String getMainPage(Model m) {
        m.addAttribute("navigationPanel", navigationPanelService.loadMainNavigationPanel());
        return Page.MAIN;
    }

    @RequestMapping(value = Path.SLASH + Page.DO_LOGIN, method = RequestMethod.POST)
    public String doLogin(HttpServletRequest request) {
        userService.authorize(request.getParameter("login"), request.getParameter("password"));
        return Path.REDIRECT + Page.MAIN;
}

    @RequestMapping(value = Path.SLASH + Page.DO_LOGIN, method = RequestMethod.GET)
    public String doLoginGet() {
        return Page.MAIN;
    }

    @RequestMapping(value= Path.SLASH + Page.LOGOUT, method = RequestMethod.GET)
    public String doLogout(HttpServletRequest request, HttpServletResponse response) {
        userService.logout(request, response);
        return Page.LOGIN;
    }
}