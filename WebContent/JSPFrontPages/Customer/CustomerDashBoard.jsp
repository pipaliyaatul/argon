<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
<title>Customer DashBoard</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
* {
  box-sizing: border-box;
}


.column {
  float: left;
  width: 33.33%;
  padding: 10px;
  height: 250px;
  margin-left:35%; 
  text-align:center;
}


.row:after {
  content: "";
  display: table;
  clear: both;
}
</style>

<body >
<jsp:include page="../../Partials/CustomerMenu.jsp" />
<form>
<h1 class="column" style="font-size:45px">Welcome ${user_name}</h1>


  <div class="column" style="background-color:#e6eeff " >
  
  
  
  <p>Assigned Operator: ${op_name}</p>
  
  <p>Assigned Retailer:${retailer_name}</p>
  
  <!--   <p>Select SetTopBox Type</p>
<select>
  <option value="standard">Standard</option>
  <option value="hd">HD</option>
  <option value="hdplus">HD+</option>
  <option value="iptv">IPTV</option>
</select>

<input type="submit" value="Enroll"> -->
  </div>


</form>
</body>
</head>
</html>
