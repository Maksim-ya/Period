package com.maksim.controller;



import com.maksim.domain.User;
import com.maksim.model.dao.UserDAO;
import com.maksim.model.impl.UserDaoImpl;
import com.maksim.util.Page;

import javax.servlet.http.HttpServletRequest;


public class SessionManager {
    private static final String SESSION_USER = "user";
    private static final String SESSION_PERIODICALS = "subscriptions";


    public static String loadUserDataToSession(HttpServletRequest request, String userName) {
        UserDAO userDao = new UserDaoImpl();
        User user = userDao.findByUserName(userName);
        request.getSession().setAttribute(SESSION_USER, user);

        loadSubscriptionData(request, user);
        return Page.get(Page.USER);
    }

    /**
     * Uploads user subscriptions data by invoking subscription DAO and finding
     * all user's subscriptions by his username and binding it to session parameter.
     * @param request http request from servlet
     * @param user warped user object
     */
    public static void loadSubscriptionData(HttpServletRequest request, User user) {
        SubscriptionDao subscriptionDao = MysqlDaoFactory.getInstance().getSubscriptionDao();
        List<Subscription> subscriptions = subscriptionDao.findByUsername(user.getUsername());
        request.getSession().setAttribute(SESSION_PERIODICALS, subscriptions);
    }
}
