package com.maksim.controller.comand.user;

import com.maksim.controller.comand.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Максим on 15/Jan/18.
 */
public class UserLoginCommand implements Command{
    private static final String USERNAME = "userName";
    private static final String PASSWORD = "password";

    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter(USERNAME);
        String password = request.getParameter(PASSWORD);

//        if (AuthenticationService.getService()
//                .login(login, password)){
//            return loadUserDataToSession(request, login);
//        } else {
//            return Message.error(request, Message.LOGIN_ERROR, Page.LOGIN);
//        }
    }
}
