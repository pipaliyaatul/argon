<%@page import="javax.websocket.Session"%>
<%@page import="model.LoginBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
body{
  background-color: #91abba;
}
h1{
  text-align: center;
  font-size: 400%;
}
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}

li {
  float: left;
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover {
  background-color: #111;
}

.footer {
  
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #91abba;
   position: fixed;
   left: 0;
   bottom: 0;
   width: 100%;
   color: white;
   text-align: center;
}



</style>
</head>
<body>

<ul>
  <li><a class="active" href="${pageContext.request.contextPath}/JSPFrontPages/Admin/AdminDashBoard.jsp">Home</a></li>
  <li><a href="${pageContext.request.contextPath}/Login">Logout</a></li>
 
</ul>
<div class="footer">
  <p>Argon Infinity Project ILP Batch</p>
</div>

</body>
</html>
