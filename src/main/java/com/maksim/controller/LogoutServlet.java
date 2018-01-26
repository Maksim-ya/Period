package com.maksim.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Максим on 26/Jan/18.
 */
public class LogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        RequestDispatcher dispatcher =request.getRequestDispatcher("login.jsp");
        request.setAttribute("errorMessage", "You are successfully logged out!");
        dispatcher.forward(request, response);

//        response.setContentType("text/html");
//        PrintWriter out=response.getWriter();
//
//        request.getRequestDispatcher("link.html").include(request, response);
//
//        HttpSession session=request.getSession();
//        session.invalidate();
//
//        out.print("You are successfully logged out!");


    }
}