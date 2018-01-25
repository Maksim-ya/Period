
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Simple Registration Page</title>
</head>
<body>

<h1>Student Registration</h1>

<form action="registration" method="post">

    <table cellpadding="8" cellspacing="8">

        <tr>
            <td><label>User Name</label></td>
            <td><input type="text" name="userName"></td>
        </tr>

        <tr>
            <td><label>Password</label></td>
            <td><input type="text" name="password"></td>
        </tr>

        <tr>
            <td><label>Full Name</label></td>
            <td><input type="text" name="fullName"></td>
        </tr>

        <tr>
            <td><label>Address</label></td>
            <td><input type="text" name="address"></td>
        </tr>

        <tr>
            <td></td>
            <td align="right">
                <input type="submit" value="Register">
                <input type="Reset" value="Cancel">
            </td>
        </tr>

    </table>
</form>

</body>
</html>
