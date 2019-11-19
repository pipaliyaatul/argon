<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Customer</title>
<script>
function myFunction() {
document.getElementById('demo').value= Date();
}
</script>

<script type="text/javascript" src="../../Javascript/customervalidation.js"></script>

</head>
<body onload="myFunction()">
<jsp:include page="../../Partials/AdminMenu.jsp" />


<form onsubmit="return adminregcust()" action="${pageContext.request.contextPath}/registerCustomerServlet" method="post">
  <div class="container">
 
    <h1 style="text-align:center">Register a Customer</h1>
   
    <hr>

    <label for="fname"><b>First Name</b></label><br>
    <input type="text" placeholder="Enter FirstName" name="first_name" required><br><br>

    <label for="lname"><b>Last Name</b></label><br>
    <input type="text" placeholder="Enter Last Name" name="last_name" required><br><br>

	<label for="emailId"><b>Email ID</b></label><br>
    <input type="text" placeholder="Enter Email Id" name="email_id" id="a_r_c_email" onchange="adminregcustomeremail()"><br><br>

	<label for="phoneNumber"><b>Phone Number</b></label><br>
    <input type="text" placeholder="Enter Phone Number" name="phone" id="a_r_c_phone" onchange="ad_reg_cust_phone()" required><br><br>

	<label for="address"><b>Address</b></label><br>
	<div>
			<label for="address1"><b>Address1</b></label>
			<input type="text" placeholder="Address1" name="address1" required><br>
		    <label for="address2"><b>Address2</b></label>
		    <input type="text" placeholder="Address2" name="address2" required><br>
		    <label for="Zipcode"><b>Zipcode</b></label>
		    <input type="text" placeholder="Zipcode" name="zipcode" id="a_r_c_zipcode" onchange="ad_reg_cust_zipcode()" required><br>
		    <label for="city"><b>City</b></label>
		    <input type="text" placeholder="City" name="city" ><br>
		    <label for="state"><b>State/Province</b></label>
		    <input type="text"  placeholder="State" name="state" >
		    <label for="state"><b>Assign Retailer</b></label>
		    
		    <select name="retailer_id"  id="retailer_id" required>
					<c:forEach var="retailer" items="${retailerList}">
					<option value="${retailer.retailer_id}">  <c:out value = "${retailer.company_name}"/>  </option>
					</c:forEach>
			</select>
		
	</div><br>



    <label for="customerCreateDate"><b>Customer Creation Date</b></label><br>
    <input type="text" id="demo" name="created_on" disabled ><br><br>
   	<input type = "hidden" value="create" name="action">
    
   <!--  <label for="OpName"><b>Operator Name</b></label><br>
    <select name="">
	<option value="c1">customer1</option>
	<option value="c2">customer2</option>
	<option value="c3">customer3</option>
	<option value="c4">customer4</option>
	</select>
    <br><br>
   <label for="RetailerName"><b>Retailer Name</b></label><br>
    <select name="">
	<option value="r1">retailer1</option>
	<option value="r2">retailer2</option>
	<option value="r3">retailer3</option>
	<option value="r4">retailer4</option>
	</select>
   <br><br>
 -->
    <input type="submit" class="registerbtn" onclick="return confirm('Are you sure you want to continue?')"></button><br>
  </div>
  
  
  
</form>


</body>
</html>