package com.maksim.controller;

import com.maksim.domain.User;
import com.maksim.service.user.LoginService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;



public class LoginServlet extends HttpServlet {

	private String userName = null;
	private String password = null;
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// getting the input from user
		userName = request.getParameter("userName");
		password = request.getParameter("password");
		
		// simple validation
		if((userName != null ) && (password != null )) {
			
			// defining the object for AuthenticationService
			LoginService loginService = new LoginService();
			
			// validating the user input
			User user = loginService.validateUser(userName, password);
			
			// dispatching the result based on the outcome 
			if(user != null && user.isValidUser()) {
				
				HttpSession session = request.getSession();
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/success.jsp");
				
				// setting user details object in session based on the valid outcome
				session.setAttribute("user", user);
				
				dispatcher.forward(request, response);
				
				
			} else {
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
				
				// setting error message
				request.setAttribute("errorMessage", "you have given invalid username or password :( ");
				
				dispatcher.forward(request, response);
				
			}
			
		} else {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			
			// setting error message
			request.setAttribute("errorMessage", "please make sure username or password is not empty :( ");
			
			dispatcher.forward(request, response);
			
		}
	}
}
