
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
<meta http-equiv="Refresh" content="3;url=Login.jsp">
<title>Login Error Page</title>
<script>
	window.onload = function(){
		document.querySelector('#my_msg').innerHTML = "${msg}"
	}
</script>
</head>
<body style="margin-top: 20%">
<div class="center">
	<h1>Message: </h1>
	<h1 id = "my_msg"></h1>
	<h1>Redirecting to Login Page...</h1>
</div>

</body>
</html>