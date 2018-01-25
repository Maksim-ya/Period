<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Login</title>
</head>
<body>

<%! String errorMessage = null; %>

<%

    if(request.getAttribute("errorMessage") != null) {

        errorMessage = (String)request.getAttribute("errorMessage");

        if(errorMessage!=null) {
%>

<div class="alert">
    <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
    <% out.println(errorMessage); %>
</div>

<%

        }
    }
%>

<form action="authenticate" method="post">

    <div class="loginBox">

        <h1>Login</h1>
        <p>
            Please enter Username and Password
        </p>

        <input class="field" type="text" placeholder="Your Username" name="userName" />

        <input class="field" type="password" placeholder="Your Password" name="password" />

        <input class="loginBtn" type="submit" value="Login" />

    </div>

</form>
<%--<form >--%>
<a href="/registration" target="_blank">Go to REGISTRATION </a>
<%--</form>--%>
</body>
</html>
