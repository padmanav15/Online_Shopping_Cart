<%@page import="com.jsp.shoppingcart.dto.Merchant"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% Merchant m = (Merchant)session.getAttribute("merchantinfo"); %>
<% if(m!=null) { %>
	<h2 style="color: green">${msg }</h2>
	<h2 style="color: green"><%= request.getAttribute("addProduct") %></h2>
	<h1><a href="addproduct">Add Product</a></h1>
	<h1><a href="ViewAllProducts.jsp">View All Product</a></h1>
	<%} else{ %>
	<h2><a href="MerchantLoginForm.jsp">Please Login First !!</a></h2>
	<%} %>
</body>
</html>