package com.maksim.controller;


import com.maksim.domain.User;
import com.maksim.service.user.RegistrationService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RegistrationServlet extends HttpServlet {

//    private String firstName;
//    private String secondName;
//    private int age;
//    private String emailId;
//    private String contactNumber;
//    private String qualification;
//    private String address;

    private String userName;
    private String password;
    private String fullName;
    private String address;
//    private String role;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/registration.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Defining user Service Object
        RegistrationService service = new RegistrationService();

        // Getting all Parameter value from HTML form
        userName = request.getParameter("userName");
        password = request.getParameter("password");
        fullName = request.getParameter("fullName");
        address = request.getParameter("address");

        // Defining user Object
        User user = new User();

        user.setUserName(userName);
        user.setPassword(password);
        user.setFullName(fullName);
        user.setAddress(address);

        if(service.addUser(user)) {
            HttpSession session = request.getSession();
            // Dispatching Success Page
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/success.jsp");
            session.setAttribute("user", user);
            dispatcher.forward(request, response);

        } else {

            // Dispatching Error Page
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/error.jsp");
            dispatcher.forward(request, response);

        }
    }


}
