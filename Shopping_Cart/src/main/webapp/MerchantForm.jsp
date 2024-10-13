<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!-- JSTL form tag -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form:form action="savemerchant" modelAttribute="merchantobj">
Enter Name : <form:input path="name" />
		<br>
		<br>
Enter Mobile : <form:input path="mobilenumber" />
		<br>
		<br>
Enter Email : <form:input path="email" />
		<br>
		<br>
Enter Password : <form:input path="password" />
		<br>
		<br>
		<input type="submit">
	</form:form>
</body>
</html>
