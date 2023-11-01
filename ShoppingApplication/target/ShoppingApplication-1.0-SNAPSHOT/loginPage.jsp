<%-- 
    Document   : loginPage
    Created on : Feb 7, 2023, 12:24:24 PM
    Author     : priyalgudhka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Validate Credentials</title>
    </head>
    <body style="background-color:#D3D3D3;">
        <h2>Login Page</h2>
        <form method="POST" action="Login">
            <p>User name: <input type="text" name="username" size="20"/></p>
            <p>Password: <input type="password" size="20" name="password"/></p>
            <p>  <input type="submit" value="Sign In"/></p>
        </form>
    </body>
</html>
