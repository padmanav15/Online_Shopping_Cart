<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 style="color: red">${msg}</h2>
	<form action="merchantloginvalidation" method="post">
		Enter Email : <input type="text" name="email"><br><br>
	    Enter Password : <input type="text" name="password"><br><br> 
	    <input type="submit" value="Login">
	</form>
</body>
</html>