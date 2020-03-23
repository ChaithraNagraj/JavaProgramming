<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body bgcolor="#523D5B">
	<h2>BridgeLabz-login</h2>
	<form action="LoginRegister" method="post">
<h3>${message}</h3>
		<h3>${successmessage}</h3> 
		UserID <input type="text" name="userID"><br> Password<input
			type="password" name="password"><br> <input
			type="submit" name="submit" value="login"><br> <br>
		<br> <br> <a href="register.jsp">Register</a>
	</form>
</body>
</html>
