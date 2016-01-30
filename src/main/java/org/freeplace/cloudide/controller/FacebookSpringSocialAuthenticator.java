package org.freeplace.cloudide.controller;

import org.freeplace.cloudide.applicationinfo.Path;
import org.freeplace.cloudide.controller.constants.Page;
import org.freeplace.cloudide.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Properties;
import java.util.UUID;

/**
 * Created by Ruslan on 26.01.2016.
 */
@Controller
public class FacebookSpringSocialAuthenticator {

    static Properties properties = new Properties();
    static {
        try {
            properties.load(FacebookSpringSocialAuthenticator.class.getClassLoader().getResourceAsStream("application.properties"));
        } catch (IOException e) {
            throw new RuntimeException("Couldn't find properties");
        }
    }
    public static final String CODE = "code";
    public static final String STATE = "state";

    private FacebookConnectionFactory facebookConnectionFactory = new FacebookConnectionFactory(
            properties.getProperty("facebook.app.id"),
            properties.getProperty("facebook.app.secret"));

    private UserService userService;

    @Autowired
    public FacebookSpringSocialAuthenticator(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(Path.AUTH_FACEBOOK)
    public RedirectView startAuthentication(HttpSession session) {
        String state = UUID.randomUUID().toString();
        session.setAttribute(STATE, state);
        OAuth2Parameters params = new OAuth2Parameters();
        params.setRedirectUri(properties.getProperty("application.host") + Path.AUTH_FACEBOOK_CALLBACK);
        params.setState(state);
        String authorizeUrl = facebookConnectionFactory.getOAuthOperations().buildAuthorizeUrl(GrantType.AUTHORIZATION_CODE, params);
        return new RedirectView(authorizeUrl);
    }

    @RequestMapping(Path.AUTH_FACEBOOK_CALLBACK)
    public RedirectView callBack(@RequestParam(CODE) String code,
                                 @RequestParam(STATE) String state,
                                 HttpSession session) {
        String stateFromSession = (String) session.getAttribute(STATE);
        session.removeAttribute(STATE);

        if (!state.equals(stateFromSession)) return new RedirectView(Path.BACK + Path.BACK + Page.LOGIN);
        //Facebook fb = getFacebookApi(code);
        userService.authenticateSocial();
        return new RedirectView(Path.BACK + Path.BACK + Page.MAIN);
    }

    private Facebook getFacebookApi(String authorizationCode) {
        OAuth2Operations oauthOperations =
                facebookConnectionFactory.getOAuthOperations();
        AccessGrant grant = oauthOperations.exchangeForAccess(authorizationCode,
                properties.getProperty("application.host") + Path.AUTH_FACEBOOK_CALLBACK, null);
        Connection<Facebook> connection =
                facebookConnectionFactory.createConnection(grant);
        return connection.getApi();
    }
}
