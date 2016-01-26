package org.freeplace.cloudide.applicationinfo;

/**
 * Created by Ruslan on 02.12.2015.
 */
public class Path {
    public static final String CLASSPATH = "classpath";
    public static final String REDIRECT = "redirect:";
    public static final String SLASH = "/";
    public static final String WEB_INF = SLASH + "WEB-INF" + SLASH;
    public static final String VIEWS = WEB_INF + "/views" + SLASH;

    public static final String AUTH = SLASH + "auth";
    public static final String AUTH_FACEBOOK = AUTH + SLASH + "facebook";
    public static final String AUTH_FACEBOOK_CALLBACK = AUTH_FACEBOOK + SLASH + "callback";

    public static final String BACK = "../";
}
