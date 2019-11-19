<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View all operators</title>
<link rel="stylesheet" type="text/css" href="../../css/login.css">
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
	<h1 align="center"> View Operator List </h1>

	<table class="alternate">
	<thead>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email Address</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
	</thead>
	
	<c:forEach var="operatorList" items="${operatorList}">
	  	   <tr>
		      <td>
				<c:out value = "${operatorList.first_name}"/>
			  </td>
			  <td>
			  	<c:out value = "${operatorList.last_name}"/>
			  </td>
			  <td>
			  	<c:out value = "${operatorList.email_id}"/>
			  </td>
			  <td>			    
			    <a href="${pageContext.request.contextPath}/EditOperator?id=${operatorList.operator_id}" onclick="return confirm('Are you sure you want to continue?')">Edit</a>	
			  </td>
			  <td>
			    <a href="${pageContext.request.contextPath}/DeleteUserServlet?user_id=${operatorList.operator_id}" onclick="return confirm('Are you sure you want to continue?')">Delete</a>
			  </td>
		   </tr>
	
	</c:forEach>
	</table>
	</div>
</body>
</html>