<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css">
<title>Customers List</title>
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
<jsp:include page="../../Partials/AdminMenu.jsp" />
<div>
<h1 align="center">Customer List</h1>
<!--   <a href="${pageContext.request.contextPath}/ViewController">Click Again</a> -->

	<table class="alternate">
	<thead>
	<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Customer ID</th>
			<th>Phone</th>
			<th>Operation</th>
			<th>Delete</th>
			
	
	</tr>
	</thead>
	<c:forEach var="customer" items="${customerList}">
	  	   <tr>
		      <td>
			  <c:out value = "${customer.first_name}"/>
			  </td>
			  <td>
			  	<c:out value = "${customer.last_name}"/>
			  </td>
			  <td>
				<c:out value = "${customer.customer_id}"/>
			  </td>
			  <td>
			  	<c:out value = "${customer.phone}"/>
			  </td>
			  <td>
			    <!--  /Book calls a servlet to fetch book by ID and populate EditBook.jsp -->
			    <a href="${pageContext.request.contextPath}/updateCustomerServlet?id=${customer.customer_id}" onclick="return confirm('Are you sure you want to continue?')">Edit</a>
				
			  </td>
			  <td>
			    <!--  /Book calls a servlet to fetch book by ID and populate EditBook.jsp -->
			    <a href="${pageContext.request.contextPath}/DeleteUserServlet?user_id=${customer.customer_id}" onclick="return confirm('Are you sure you want to continue?')">Delete</a>
			  </td>  
			  
		   </tr>
	
	</c:forEach>
	</table>
	
	</div>
</body>
</html>