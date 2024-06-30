<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link href="css/loginpage.css" rel="stylesheet">
</head>
<body>
    <div class="login-container">
        <h1>LogIn Page</h1>
        <form action="submit" method="post">
            <label for="role">Choose a Role:</label>
            <select id="role" name="role" required>
                <option value="select">Select</option>
                <option value="Employee">Employee</option>
                <option value="Manager">Manager</option>
                <option value="Director">Director</option>
                <option value="Travel Agent">Travel Agent</option>
            </select>
            <label for="loginid">Login Id:</label>
            <input type="text" id="loginid" name="employeeId" required>
            <label for="pwd">Password:</label>
            <input type="password" id="pwd" name="password" required>
            <input type="submit" value="Login">
           <div>
            <f:if test="${invalidLogin}">
            	<span class="invaliedLogin">Invalid Credentials</span>
            </f:if>
            </div>
        </form>
    </div>
    
    <script type="text/javascript">
    function myFunctio(){
    	document.getElementById("demo")
    }
    </script>
</body>
</html>