<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
* {
  box-sizing: border-box;
}


.column {
  float: left;
  width: 33.33%;
  padding: 10px;
  height: 425px; 
  text-align:center;
}


.row:after {
  content: "";
  display: table;
  clear: both;
}
</style>
<title>Admin DashBoard</title>
</head>
<body>
<jsp:include page="../../Partials/AdminMenu.jsp" />
<h1 style="font-size:45px">Welcome ${user_name}</h1>

<div class="row">
  <div class="column" style="background-color:#e6eeff;">
    <h2>Operator Management</h2><br>
    <form action="${pageContext.request.contextPath}/JSPFrontPages/Operator/RegisterOperator.jsp">
		<input type="submit" value="Register Operator" style="width: 160px; ">
	</form><br>
	
    <form action="${pageContext.request.contextPath}/ViewOperators">
		<input type="submit" value="Display Operator" style="width: 160px; ">
	</form><br>
	
	
  </div>
  
  <div class="column" style="background-color:#b3ccff;">
    <h2>Retailer Management</h2><br>
    <form action="${pageContext.request.contextPath}/JSPFrontPages/Retailer/RegisterRetailer.jsp">
		<input type="submit" value="Register Retailer" style="width: 160px; ">
	</form><br>
    <form action="${pageContext.request.contextPath}/RegisterRetailer" method = "GET">
		<input type="submit" value="Display Retailer" style="width: 160px; ">
	</form><br>
	<form action="${pageContext.request.contextPath}/StatsPieServlet">
	<input type="submit" value="Retailer Analytics" style="width: 160px; ">
	</form><br>
  </div>
  
  <div class="column" style="background-color:#99bbff;">
    <h2>Customer Management</h2><br>
    <form action="${pageContext.request.contextPath}/RetailerServlet" method = "POST">
		<input type="submit" value="Register Customer" style="width: 160px; ">
	</form>
    <form action="${pageContext.request.contextPath}/registerCustomerServlet" method = "GET">
		<input type="submit" value="Display Customer" style="width: 160px; ">
	</form>
	<form action="${pageContext.request.contextPath}/CustomerAssignServlet" method = "POST">
		<input type="submit" value="Assign Retailers To New Customers" style="width: 250px; ">
		<input type="hidden" value="retailer" name="action"/>
	</form>
	<form action="${pageContext.request.contextPath}/CustomerAssignServlet" method = "POST">
		<input type="submit" value="Assign Operators To New Customers" style="width: 250px; ">
		<input type="hidden" value="operator" name="action"/>
	</form>
		<form action="${pageContext.request.contextPath}/StatsServlet">
		<input type="submit" value="Customer Analytics" style="width: 160px; ">
	</form><br>
  </div>
    
</div>
</body>
</html>