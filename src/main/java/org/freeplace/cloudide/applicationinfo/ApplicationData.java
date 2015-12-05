package org.freeplace.cloudide.applicationinfo;

/**
 * Created by Ruslan on 02.12.2015.
 */
public class ApplicationData {
    public static final String DOT = ".";
    public static final String ORG = "org";
    public static final String ORGANISATION_NAME = "freeplace";
    public static final String APPLICATION_NAME = "cloudide";
    public static final String GROUP_NAME = ORG + DOT + ORGANISATION_NAME;
    public static final String APPLICATION_FULL_NAME = GROUP_NAME + DOT + APPLICATION_NAME;

    public static final String PACKAGE_CONFIGURATION = APPLICATION_FULL_NAME + DOT + "configuration";
    public static final String PACKAGE_CONTROLLER = APPLICATION_FULL_NAME + DOT + "controller";
    public static final String PACKAGE_DAO = APPLICATION_FULL_NAME + DOT + "dao";
    public static final String PACKAGE_MODEL = APPLICATION_FULL_NAME + DOT + "model";
    public static final String PACKAGE_SERVICE = APPLICATION_FULL_NAME + DOT + "service";

    public static final String EXEC_COMMAND = System.getProperty("java.home").toString()+"/bin/java -classpath";
}
