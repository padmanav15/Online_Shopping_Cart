<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- JSTL form tag -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center><h1>Order Form</h1></center>
<form:form action="saveorder" modelAttribute="orderobj" align="center">
 Name : <form:input path="name"/> <br><br>
 Address : <form:input path="address"/> <br><br>
 Mob No : <form:input path="mobilenumber"/> <br><br>
 <input type="submit" value="Confirm Order">
</form:form>
</body>
</html>