<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Customer</title>
<link rel="stylesheet" type="text/css" href="../../css/login.css">
<script type="text/javascript" src="../../Javascript/customervalidation.js"></script>
</head>
<body>
<jsp:include page="../../Partials/OperatorMenu.jsp" />
<form onsubmit="return adminregcust()" action="${pageContext.request.contextPath}/UpdateCustByOperator" method = "post">
<fieldset>


  <div class="container">
  
  <h1 style="text-align:center"><legend>Update Customer</legend></h1>
     <label for="fname"><b>First Name</b></label><br>
    <input type="text" placeholder="Enter FirstName" name="first_name"  value="${customer.first_name}" required><br><br>

    <label for="lname"><b>Last Name</b></label><br>
    <input type="text" placeholder="Enter Last Name" name="last_name" value="${customer.last_name}" required><br><br>

	<label for="emailId"><b>Email ID</b></label><br>
    <input type="text" placeholder="Enter Email Id" name="email_id" value="${customer.email_id}" id="a_r_c_email" onchange="adminregcustomeremail()" required><br><br>

	<label for="phoneNumber"><b>Phone Number</b></label><br>
    <input type="text" placeholder="Enter Phone Number" name="phone" value="${customer.phone}" id="a_r_c_phone" onchange="ad_reg_cust_phone()" required><br><br>

	<label for="address"><b>Address</b></label><br>
	<div>
			<label for="address1"><b>Address1</b></label>
			<input type="text" placeholder="Address1" name="address1" value="${customer.address1}" required><br>
		    <label for="address2"><b>Address2</b></label>
		    <input type="text" placeholder="Address2" name="address2" value="${customer.address2}" required><br>
		    <label for="zipcode"><b>Zipcode</b></label>
		    <input type="text" placeholder="Zipcode" name="zipcode" value="${customer.zipcode}" id="a_r_c_zipcode" onchange="ad_reg_cust_zipcode()" required><br>
		    <label for="city"><b>City</b></label>
		    <input type="text" placeholder="City" name="city" value="${customer.city}" required><br>
		    <label for="state"><b>State/Province</b></label>
		    <input type="text"  placeholder="state" name="state" value="${customer.state}" required>
		
	</div><br>

    <label for="customerCreateDate"><b>Customer Creation Date</b></label><br>
    <input type="text" name="customerCreationDate" value ="${customer.created_on}"  disabled><br><br>
    
   <input type="hidden" value="${customer.customer_id}" name="custId">
	
    <button type="submit" class="registerbtn" onclick="return confirm('Are you sure you want to continue?')">Update</button><br>
  </div>
  
  </fieldset>
  <input type = "hidden" value="update" name="action">
</form>

</body>
</html>