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
<form:form action="saveproduct" modelAttribute="productobj">
Enter brand : <form:input path="brand"/><br><br>
Enter Category : <form:input path="category"/><br><br>
Enter Model : <form:input path="model"/><br><br>
Enter Price : <form:input path="price"/><br><br>
Enter Stock : <form:input path="stock"/><br><br>
<input type="submit">
</form:form>
</body>
</html>