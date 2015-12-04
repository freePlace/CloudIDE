package org.freeplace.cloudide.configuration.security;

/**
 * Created by Ruslan on 02.12.2015.
 */
import org.freeplace.cloudide.applicationinfo.ApplicationData;
import org.freeplace.cloudide.applicationinfo.Path;
import org.freeplace.cloudide.configuration.AppConfig;
import org.freeplace.cloudide.controller.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.stream.Collectors;

@Configuration
@EnableWebMvcSecurity
@ComponentScan(basePackages = ApplicationData.APPLICATION_FULL_NAME)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    public static final String SECURITY_ALL_NESTED_PAGES = "**";

    @Autowired
    private AuthorizationService authorizationService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(authorizationService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        String accessHasRoles = Arrays.stream(Role.values())
                                    .map(role -> "hasRole('" + role.name() + "')").collect(Collectors.joining(" or "));
        http.authorizeRequests()
                .antMatchers(Path.SLASH + Page.MAIN + Path.SLASH + SECURITY_ALL_NESTED_PAGES)
                .access(accessHasRoles)
                .and().formLogin();
    }
}