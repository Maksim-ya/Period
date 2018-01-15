package com.maksim.service.user;


public class UserService {
    private static final UserService USER_SERVICE = new UserService();

    private UserService() {}

    public static UserService getService() {
        return USER_SERVICE;
    }

}
