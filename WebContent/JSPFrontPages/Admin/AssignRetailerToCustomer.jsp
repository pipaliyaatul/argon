<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Assign Retailer</title>
<link rel="stylesheet" type="text/css" href="../../css/login.css">
</head>
<body>
<jsp:include page="../../Partials/AdminMenu.jsp" />
 <h1>Assign Retailer</h1>
 <form action="${pageContext.request.contextPath}/CustomerAssignUpdateServlet" method="post">
		    
		    <select name="retailer_id"  id="retailer_id">
					<c:forEach var="retailer" items="${retailerList}">
					<option value="${retailer.retailer_id}">  <c:out value = "${retailer.company_name}"/>  </option>
					</c:forEach>
			</select>
			<input type="hidden" name="action" value="retailer">
			<input type="hidden" value="${customer_id}" name = "customer_id">
			 <button type="submit" class="registerbtn" onclick="return confirm('Are you sure you want to continue?')">Assign</button>
</form>
</body>
</html>