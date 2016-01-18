package org.freeplace.cloudide.controller.webservice.user;

import org.freeplace.cloudide.applicationinfo.Path;
import org.freeplace.cloudide.controller.webservice.AbstractWebService;
import org.freeplace.cloudide.model.user.User;
import org.freeplace.cloudide.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Ruslan on 18.01.2016.
 */
@RestController
@RequestMapping(UserWebService.SERVICE_PATH)
public class UserWebService extends AbstractWebService{

    public static final String SERVICE_PATH = BASE_PATH + Path.SLASH + "user";

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity createUser(@RequestBody User user) {
        userService.createUser(user);
        // how to pass strings?! =)
        return new ResponseEntity<Integer>(1, HttpStatus.OK);
    }
}
