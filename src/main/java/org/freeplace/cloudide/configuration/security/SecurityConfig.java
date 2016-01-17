package org.freeplace.cloudide.configuration.security;

/**
 * Created by Ruslan on 02.12.2015.
 */
import org.freeplace.cloudide.applicationinfo.ApplicationData;
import org.freeplace.cloudide.applicationinfo.Path;
import org.freeplace.cloudide.controller.Page;
import org.freeplace.cloudide.controller.webservice.AbstractWebService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@Configuration
@EnableWebMvcSecurity
@ComponentScan(basePackages = ApplicationData.APPLICATION_FULL_NAME)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    public static final String SECURITY_ALL_NESTED_PAGES = "**";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(Path.SLASH + AbstractWebService.BASE_PATH + Path.SLASH + SECURITY_ALL_NESTED_PAGES).permitAll()
                .antMatchers(Path.SLASH + Page.MAIN + Path.SLASH + SECURITY_ALL_NESTED_PAGES).authenticated()
                .and().formLogin().loginPage(Path.SLASH + Page.LOGIN)
                .and().csrf().disable();
    }
}