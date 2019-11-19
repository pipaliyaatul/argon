<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="../../Javascript/validation.js"></script>
<script>
function myFunction() {
document.getElementById('demo').value= Date();
}
/* Function to convert the number format to a comma separated value
 * 
/* function formatNumber(val){
	g = Number(document.getElementById("cost").value);
	document.getElementById("cost").value = g.toLocaleString();	
} */  
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Retailer Registration</title>
<link rel="stylesheet" type="text/css" href="../../css/login.css">
</head>
<body onload="myFunction()">
<jsp:include page="../../Partials/AdminMenu.jsp" />


<form onsubmit="return RegisterRetailerPageValidation()" action="${pageContext.request.contextPath}/RegisterRetailer" method = "post" name = "registerform">
  <div class="container">
    <h1 style="text-align:center">Register a retailer</h1>

    <label for="companyname"><b>Company Name</b></label>
    <input type="text" placeholder="Enter Company Name" name="company_name" required>

	<label for="contact"><b>Contact</b></label>
	<div>
			<label for="contact1"><b>Contact 1</b></label>
		    <input type="text" placeholder="Enter Contact Details" name="contact1" id="rr_contact1" required>
			
			<label for="contact2"><b>Contact 2</b></label>
		    <input type="text" placeholder="Enter Contact Details" name="contact2" id="rr_contact2">
    </div><br>
    
    <label for="address"><b>Address</b></label><br>
	<div>
			<label for="address1"><b>Address1</b></label>
			<input type="text" placeholder="Address1" name="address1" required><br>
			
		    <label for="address2"><b>Address2</b></label>
		    <input type="text" placeholder="Address2" name="address2" required><br>
		    
		    <label for="zipcode"><b>Zipcode</b></label>
		    <input type="text" placeholder="Zipcode" name="zipcode" id="rr_zipcode" onchange="checkzipcode()"><br>
		    
		    <label for="city"><b>City</b></label>
		    <input type="text"  name="city"><br>
		    
		    <label for="state"><b>State/Province</b></label>
		    <input type="text"  name="state">	    
		
	</div><br>

    <label for="rr_stblimit"><b>Set Top Box Limit</b></label>
    <input type="text" placeholder="Enter Set Top Box Limit" name="stb_limit" id="rr_setbxlimit">
	
	<label for="creditlimit"><b>Credit Limit</b></label>
    <input type="text" placeholder="Enter Credit Limit" name="credit_limit" id="rr_creditlimit" required>
    
    <label for="commpercent"><b>Commission Percentage</b></label>
    <input type="text" placeholder="Enter Commission percentage" name="comm_percentage" id="rr_commperc" required>
	
	<label for="servicecharges"><b>Service Charges</b></label>
    <input type="text" placeholder="Enter Service Charges" name="service_charges" id="rr_servicecharge" required>
    
    <label for="inventorylist"><b>Inventory list</b></label>
    <input type="text" placeholder="" name="inventory_list" >
    
    <label for="creationdate"><b>Created On</b></label>
    <input type="text" id="demo" name="created_on" disabled ><br><br>
    
    <label for="inventorycost"><b>Inventory Cost</b></label>
    <input type="text" placeholder="Inventory Cost" name="inventory_cost" id="cost" onChange = "formatNumber(this)" required>
    
    <label for="assignedtoretailer"><b> Customers Assigned to Retailer</b></label>
    <input type="text" placeholder="Assigned to Retailer" name="assigned_to_retailer" required>
    
     <button type="submit" class="registerbtn">Register</button><br>
</div>
</form>
</body>
</html>