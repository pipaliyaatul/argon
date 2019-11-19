<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Retailer</title>
<link rel="stylesheet" type="text/css" href="../../css/login.css">
<script type="text/javascript" src="../../Javascript/validation.js"></script>
</head>
<body>
<jsp:include page="../../Partials/OperatorMenu.jsp" />


<form onsubmit="return RegisterRetailerPageValidation()" action="${pageContext.request.contextPath}/UpdateRetailer" method="post">
  <div class="container">
    <h1 style="text-align:center">Update Retailer</h1>
    
   
    <label for="companyname"><b>Company Name</b></label>
    <input type="text" name="company_name" value="${retailer.company_name}"required>

	<label for="contact"><b>Contact</b></label>
	<div>
			<label for="contact1"><b>Contact 1</b></label>
		    <input type="text" value="${retailer.contact1}" name="contact1" id="rr_contact1" required>
			
			<label for="contact2"><b>Contact 2</b></label>
		    <input type="text" value="${retailer.contact2}" name="contact2" id="rr_contact2">
    </div><br>
    <br>
    <label for="address"><b>Address</b></label>
	<div>
			<label for="address1"><b>Address1</b></label>
			<input type="text" value="${retailer.address1}" name="address1" required><br>
			
		    <label for="address2"><b>Address2</b></label>
		    <input type="text" value="${retailer.address2}" name="address2" required><br>
		    
		    <label for="zipcode"><b>Zipcode</b></label>
		    <input type="text" value="${retailer.zipcode}" name="zipcode" id="rr_zipcode" onchange="checkzipcode()" required><br>
		    
		    <label for="city"><b>City</b></label>
		    <input type="text"  value="${retailer.city}" name="city"><br>
		    
		    <label for="state"><b>State/Province</b></label>
		    <input type="text" value="${retailer.state}" name="state">	    
		
	</div><br><br>

    <label for="stblimit"><b>Set Top Box Limit</b></label>
    <input type="text" value="${retailer.stb_limit}" name="stb_limit" required>
	
	<label for="creditlimit"><b>Credit Limit</b></label>
    <input type="text" value="${retailer.credit_limit}" name="credit_limit" required>
    
    <label for="commpercent"><b>Commission Percentage</b></label>
    <input type="text" value="${retailer.comm_percent}" name="comm_percent" required>
	
	<label for="servicecharges"><b>Service Charges</b></label>
    <input type="text" value="${retailer.service_charges}" name="service_charges" required>
    
    <!-- <label for="inventorylist"><b>Inventory list</b></label>
    <input type="text" value="${retailer.credit_limit}" name="inventory_list" required>
     -->
    <label for="creationdate"><b>Created On</b></label><br>
    <input type="text" value="${retailer.created_on}" disabled><br><br>
    
    <label for="inventorycost"><b>Inventory Cost</b></label>
    <input type="text" value="${retailer.inventory_cost}" name="inventory_cost" required>
    
    <label for="assignedtoretailer"><b>Assigned to Retailer</b></label>
    <input type="text" value="${retailer.assigned_to_retailer}" name="assigned_to_retailer" required>
    
        <input type="hidden" value="${retailer.retailer_id}" name="retailer_id">
    
    
     <input type="submit" class="registerbtn" onclick="return confirm('Are you sure you want to continue?')" value="Update"><br>
</div></form>
<script src="./scripts.js"></script>
</body>
</html>