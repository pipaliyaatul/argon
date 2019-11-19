<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Operator</title>
<link rel="stylesheet" type="text/css" href="../../css/login.css">
<script type="text/javascript" src="../../Javascript/validation.js"></script>
<style>
.container-name div 
{
    display: inline-block;
	width: 500px;
	min-height: 50px;
	background-color: #eee;
	height: auto;
  }
#q1 
{
	 
	  width: 45%;
	  padding: 12px 20px;
	  margin: 8px 0;
	  display: inline-block;
	  border: 1px solid #ccc;
	  border-radius: 4px;
	  box-sizing: border-box;
}
#q2 
{	
	margin-left:300px;
	margin-right:0px;
	
	 width: 45%;
	  padding: 12px 20px;
	  margin: 8px 0;
	  display: inline-block;
	  border: 1px solid #ccc;
	  border-radius: 4px;
	  box-sizing: border-box;
}
.floatex
{
	float: left;
}
.floatex1
{
	float: right;
}
.autoclass
{
min-height: 100px;

}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

</head>
<body onload="myFunction()">
<jsp:include page="../../Partials/AdminMenu.jsp" />
<form onsubmit="return MailandPhoneValidate()" action="${pageContext.request.contextPath}/OperatorServlet" method="post">
  <div class="container">
    <h1 style="text-align:center">Register an operator</h1>
    <p>Please fill in this form to create an account.</p>
    <hr>
	
	<label for="first_name"><b>First Name</b></label>
    <input type="text" placeholder="Enter First Name" name="first_name" required>
    
    <label for="last_name"><b>Last Name</b></label>
    <input type="text" placeholder="Enter Last Name" name="last_name" required>
    
    <label for="email_id"><b>Email Id</b></label>
    <input type="text" placeholder="Enter Email Id" name="email_id" id="email_id" required onchange="validateEmail()">
    
    <label for="phone"><b>Phone Number</b></label>
    <input type="text" placeholder="Enter phone number" name="phone" id="phone" required>
    
    <label for="shift_start_time"><b>Shift Start Time</b></label>
    <select name="shift_start_time" id="shift_start_time" onchange="setEndTime()">
    		<option>08:00:00</option>
    		<option>09:00:00</option>
    		<option>10:00:00</option>
    		<option>11:00:00</option>
  	</select>
  	
  	<label for="shift_end_time"><b>Shift End Time</b></label>
    <input type="text"  id="shift_end_time" name="shift_end_time" value="16:00:00" required readonly="readonly">
    
    <label for="customer_limit"><b>Max number of customers to be managed</b></label>
    <input type="text" placeholder="Enter max customers" name="customer_limit" required >
    
    <label for="created_on"><b>Creation Date</b></label>
    <input type="text" id="demo" placeholder="date" name="created_on" disabled="disabled">
    
    <label for="total_active_customers"><b>Total Customer active</b></label>
    <input type="text"  placeholder="Active customer" name="total_active_customer" required>
   
    <hr>

    <button type="submit" class="registerbtn" onclick="return confirm('Are you sure you want to continue?')">Register</button>
  </div>
  
  
</form>
<h2 id='result'></h2>
</body>
</html>