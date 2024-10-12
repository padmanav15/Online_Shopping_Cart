<%@page import="com.jsp.shoppingcart.dto.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	Customer c = (Customer) session.getAttribute("customerinfo");
	if (c != null) {
	%>
	<h1>${msg1 }</h1>
	<h1>
		<a href="displayproducts">Display All Products</a>
	</h1>
	<h1>
		<a href="DisplayProductByBrand.jsp">Display Product By Brand</a>
	</h1>
	<h1>
		<a href="DisplayProductByCategory.jsp">Display Product By Category</a>
	</h1>
	<h1>
		<a href="DisplayProductBetweenRange.jsp">Display Product Between Range</a>
	</h1>
	<%
	} else {
	%>
	<h2><a href="CustomerLoginForm.jsp">Login First !!!</a></h2>
	<%
	}
	%>
</body>
</html>
