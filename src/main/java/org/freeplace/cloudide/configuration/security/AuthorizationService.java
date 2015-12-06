package org.freeplace.cloudide.configuration.security;

import org.freeplace.cloudide.model.Role;
import org.freeplace.cloudide.model.User;
import org.freeplace.cloudide.model.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
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

    public static final String QUERY_GET_CREDENTIALS =
            "SELECT "+ User.COLUMN_PASSWORD + ", "+Role.COLUMN_NAME +
            ", " + UserAccount.COLUMN_ENABLED +
            ", " + UserAccount.COLUMN_ACCOUNT_NON_EXPIRED +
            ", " + UserAccount.COLUMN_CREDENTIALS_NON_EXPIRED +
            ", " + UserAccount.COLUMN_ACCOUNT_NON_LOCKED +
            " FROM user u " +
            "INNER JOIN role r ON u.id_role = r.id_role " +
            "INNER JOIN user_account ua ON u.id_user = ua.id_user " +
            "WHERE login = ?";

    @Autowired
    private DataSource dataSource;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        try(Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(QUERY_GET_CREDENTIALS);
            statement.setString(1,login);
            ResultSet result = statement.executeQuery();

            if (!result.next()) {
                throw new UsernameNotFoundException("User not found");
            }

            String password = result.getString(User.COLUMN_PASSWORD);
            String roleName = result.getString(Role.COLUMN_NAME);
            boolean isAccountEnabled = result.getBoolean(UserAccount.COLUMN_ENABLED);
            boolean isAccountNonExpired = result.getBoolean(UserAccount.COLUMN_ACCOUNT_NON_EXPIRED);
            boolean isCredentialsNonExpired = result.getBoolean(UserAccount.COLUMN_CREDENTIALS_NON_EXPIRED);
            boolean isColumnAccountNonLocked = result.getBoolean(UserAccount.COLUMN_ACCOUNT_NON_LOCKED);

            Collection<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(roleName));
            return new org.springframework.security.core.userdetails.User(
                    login, password, isAccountEnabled, isAccountNonExpired,
                    isCredentialsNonExpired, isColumnAccountNonLocked, authorities);
        } catch (UsernameNotFoundException e) {
            throw new EntityNotFoundException(e.getCause().getMessage());
        } catch (SQLException e) {
            throw new EntityNotFoundException(e.getCause().getMessage());
        }
    }
}
