<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
<title>Operator DashBoard</title>
<style>
		* {
  box-sizing: border-box;
}


.column {
  float: left;
  width: 33.33%;
  padding: 10px;
  height: 300px; 
  text-align:center;
}


.row:after {
  content: "";
  display: table;
  clear: both;
}
.blue-square-container {
  text-align: center;
</style>
</head>

<body>
	<jsp:include page="../../Partials/OperatorMenu.jsp" />
		 <h1 style="font-size:45px">Welcome ${user_name}</h1>
<div class="row">
		
				<div class="column" style="background-color:#e6eeff;">
    
    <h2>Customer Management</h2><br>
    
    	<form action="${pageContext.request.contextPath}/RegCustByOperatorServlet" method="get">
			<input type="submit" value="Register Customer" style="width: 160px; ">
		</form>
    	<br>
    	<!-- 
     	<form action="${pageContext.request.contextPath}/registerCustomerServlet" method="get">
	    	<input type="submit" value="Display Customer" style="width: 160px; ">
		</form>
		 -->
		
		<form action="${pageContext.request.contextPath}/registerCustomerServlet" method="get">
	    	<input type="submit" value="Display Customer" style="width: 160px; ">
	    	
		</form>
		<br>
 </div>
  
  <div class="column" style="background-color:#b3ccff;">
    <h2>Retailer Management</h2><br>
    <form action="${pageContext.request.contextPath}/JSPFrontPages/Operator/RegisterRetailerByOperator.jsp">
		<input type="submit" value="Register Retailer" style="width: 160px; ">
	</form><br>
    <form action="${pageContext.request.contextPath}/RegisterRetailer" method = "GET">
		<input type="submit" value="Display Retailer" style="width: 160px; ">
	</form><br>
  </div>

</div>
		

 </body>
  
</html>