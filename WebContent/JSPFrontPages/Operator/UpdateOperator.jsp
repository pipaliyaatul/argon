<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Operator</title>
<link rel="stylesheet" type="text/css" href="../../css/login.css">
<script>
function setEndTime()
{
	var a = parseInt(document.getElementById('shift_start_time').value);
	var b=':00:00';
	document.getElementById('shift_end_time').value = a + 8 + b;
	
}

function myFunction() {
	document.getElementById('demo').value= Date();
	}
	
window.onload = function() {
	document.getElementById('shift_start_time').value ="${operator.shift_start_time}";
};

</script>
<script type="text/javascript" src="../../Javascript/customervalidation.js"></script>
</head>

<body>
<jsp:include page="../../Partials/AdminMenu.jsp" />


<form onsubmit="return admin_update_operator()" action="${pageContext.request.contextPath}/EditOperator" method="post">
  <div class="container">
    <h1 style="text-align:center">Update Operator</h1>

    <label for="fname"><b>First Name</b></label>
    <input type="text" value="${operator.first_name}" name="first_name" required>

    <label for="lname"><b>Last Name</b></label>
    <input type="text"  value="${operator.last_name}" name="last_name" required>

    <label for="email"><b>Email Id</b></label>
    <input type="text" value="${operator.email_id}" name="email_id" id="update_cust_email" required>
    
    <label for="phone"><b>Phone Number</b></label>
    <input type="text"  value="${operator.phone}" name="phone" id="update_cust_phone" required>
    
    <label for="stime"><b>Shift Start Time</b></label>
    <select name="shift_start_time" id="shift_start_time" onchange="setEndTime()">
    		<option>08:00:00</option>
    		<option>09:00:00</option>
    		<option>10:00:00</option>
    		<option>11:00:00</option>
  	</select>
  	
  	<label for="etime"><b>Shift End Time</b></label>
    <input type="text" value="${operator.shift_end_time}" name="shift_end_time" id="shift_end_time" required readonly="readonly">
    
    <label for="mcust"><b>Total active customers to be managed</b></label>
    <input type="text" value="${operator.total_active_customer}" name="total_active_customer" readonly="readonly">
    
    <label for="cdate"><b>Creation Date</b></label>
    <input type="text" value="${operator.created_on}" name="created_on" required readonly="readonly">
    
    <input type="hidden" value="${operator.operator_id}" name="operator_id">
    <hr>

    <button type="submit" class="registerbtn" onclick="return confirm('Are you sure you want to continue?')">Update Operator</button>
  </div>
  
  
</form>
</body>
</html>