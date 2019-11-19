<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Infinity Login</title>
<!-- <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">  -->
<link rel="stylesheet" type="text/css" href="../css/login.css">

</head>

<body class="frontdesign">

<h1 class="center">Welcome to Infinity</h1>
<div class="center" >
<form action="${pageContext.request.contextPath}/Login" method="post" >

<label for="Mname"><b>User Name</b></label>
<input type="text" id="user_name" value="" name="user_name" required><br><br>

<label for="Sname"><b>Password</b></label>
<input type="password" id="user_password" value="" name="user_password" required><br><br>
<input type="submit" value="Login">

</form>

<a href="${pageContext.request.contextPath}/JSPFrontPages/Customer/RegisterCustomerBySelf.jsp">Are you a new Customer?</a>

<br>
</div>


</body>
</html>