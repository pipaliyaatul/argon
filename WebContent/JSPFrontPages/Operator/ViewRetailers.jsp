<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View all retailers</title>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">
<style>
.alternate {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}

h1 {
  text-align: center;
}

</style>


</head>

<body>
<jsp:include page="../../Partials/OperatorMenu.jsp" />
<div>
	<h1 align="center">View Retailer List</h1>



	<table class="alternate">
	<thead>
	<tr>
	<th>Retailer Name</th>
	<th>Contact Details</th>
	<th>Edit</th>
	<th>Delete</th>
	
	</tr>
	</thead>
	
	<c:forEach var="retailerList" items="${retailerList}">
	    <!-- We will only display books that are available for checkout -->
		
		   <tr>
		      <td>
				<c:out value = "${retailerList.company_name}"/>
			  </td>
			  <td>
				<c:out value = "${retailerList.contact1}"/>
			  </td>
			
			  <td>
			      <a href="${pageContext.request.contextPath}/UpdateRetailer?retailer_id=${retailerList.retailer_id}" onclick="return confirm('Are you sure you want to continue?')">Edit</a>	
			  </td>
			  <td>
			      <a href="${pageContext.request.contextPath}/DeleteUserServlet?user_id=${retailerList.retailer_id}" onclick="return confirm('Are you sure you want to continue?')">Delete</a>	
			  </td>
		   </tr>
		
	</c:forEach>
	</table>
	
	</div>
</body>
</html>