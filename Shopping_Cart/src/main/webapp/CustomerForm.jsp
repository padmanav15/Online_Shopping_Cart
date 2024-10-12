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
<form:form action="savecustomer" modelAttribute="customerobj">
Enter Name : <form:input path="name"/><br><br>
Enter Address : <form:input path="address"/><br><br>
Enter MobileNo : <form:input path="mobileno"/><br><br>
Enter Email : <form:input path="email"/><br><br>
Enter Password : <form:input path="password"/><br><br>
<input type="submit">
</form:form>
</body>
</html>
