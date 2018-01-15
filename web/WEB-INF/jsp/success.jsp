<%@page import="com.maksim.domain.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dash Board | My Application</title>
</head>
<body>

	<%! 
		User user = null;
		
		String name = null;
	
	%>

	<%
	
		if(session.getAttribute("user") != null) {
			
			user = (User)session.getAttribute("user");
			
			name = user.getName();
		}
	
	%>

	<h1>Hello <%=name %>, Welcome to Application</h1>

	<br/>
	
	
</body>
</html>