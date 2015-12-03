package org.freeplace.cloudide.configuration.security;

import org.freeplace.cloudide.applicationinfo.ApplicationData;
import org.freeplace.cloudide.model.User;
import org.freeplace.cloudide.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Ruslan on 02.12.2015.
 */
@Service
public class AuthorizationService implements UserDetailsService {

    public static final String QUERY_GET_CREDENTIALS = "SELECT password, role_id FROM user WHERE login = ?";

    @Autowired
    private UserService userService;

    @Autowired
    private DataSource dataSource;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(QUERY_GET_CREDENTIALS);
            statement.setString(1,login);
            ResultSet result = statement.executeQuery();

            if (result.next() == false) {
                throw new UsernameNotFoundException("User not found");
            }

            String password = result.getString(User.COLUMN_PASSWORD);
            int roleId = result.getInt(User.COLUMN_ROLE_ID);

            Collection<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(Role.INSTANCE.getRoleNameById(roleId)));
            return new org.springframework.security.core.userdetails.User(
                    login, password, true, true, true, true, authorities);
        } catch (UsernameNotFoundException e) {
            throw new EntityNotFoundException(e.getCause().getMessage());
        } catch (SQLException e) {
            throw new EntityNotFoundException(e.getCause().getMessage());
        }
        /*
        UserAccount userAccount = user.getUserAccount();
        boolean enabled = userAccount.getIsEnabled();
        boolean accountNonExpired = !userAccount.getIsExpired();
        boolean credentialsNonExpired = !userAccount.getIsExpiredCredentials();
        boolean accountNonLocked = !userAccount.getIsLocked();
        */
    }
}
