<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
    function Validate() {
        var password = document.getElementById("txtPassword").value;
        var confirmPassword = document.getElementById("txtConfirmPassword").value;
        if (password != confirmPassword) {
            alert("Passwords do not match.");
            return false;
        }
        return true;
    }
</script>
<link rel="stylesheet" type="text/css" href="../css/login.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/ChangePasswordServlet" method="post">
  <div class="container">
 
    <h1 style="text-align:center">Change Password</h1>
   
    <hr>

    <label for="uname"><b>User Name</b></label><br>
    <input type="text" placeholder="Enter UserName" value="${user_name}" name="user_name" required disabled><br><br>

    <label for="password"><b>Password</b></label><br>
    <input type="password" placeholder="Enter Password" id="txtPassword"  name="password" required><br><br>
	
	<label for="cpassword"><b> Confirm Password</b></label><br>
    <input type="password" placeholder="Enter confirm password" id="txtConfirmPassword" name="cpassword"><br><br>
    <input type="submit" class="registerbtn" required onclick="return Validate()"></button><br>
  </div>
  
  
  
</form>
</body>
</html>