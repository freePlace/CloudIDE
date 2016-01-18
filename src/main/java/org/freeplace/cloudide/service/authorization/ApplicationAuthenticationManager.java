package org.freeplace.cloudide.service.authorization;

import org.freeplace.cloudide.dao.user.UserDAO;
import org.freeplace.cloudide.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ruslan on 16.01.2016.
 */
@Service
public class ApplicationAuthenticationManager implements AuthenticationManager {

    @Autowired
    private UserDAO userDAO;

    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        String login = auth.getName();
        User user = userDAO.findOneByColumnValue("login", login);
        if(user != null && user.getPassword().equals(auth.getCredentials())) {
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(user.getRole().getName()));
            return new UsernamePasswordAuthenticationToken(auth.getName(), auth.getCredentials(), authorities);
        }
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(auth.getName(), auth.getCredentials(), null);
        authentication.setAuthenticated(false);
        return authentication;
    }
}
