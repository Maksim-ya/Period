package com.maksim.util;

import java.util.ResourceBundle;

public class Page {

    public static final String REGISTRATION = "REGISTRATION_PAGE";
    public static final String USER = "USER_PAGE";
    public static final String LOGIN = "LOGIN_PAGE";
    public static final String AADMIN = "ADMIN_PAGE";

    private static final ResourceBundle resource = ResourceBundle.getBundle("pages");
    public static String get(String key) {
        return (String) resource.getObject(key);
    }
}
