<%@page import="com.jsp.shoppingcart.dto.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center><h1><b><u>Add To Cart Page</u></b></h1></center>
<% Product p = (Product) request.getAttribute("prodobj");  %>
<form action="additemtocart" align="center">
<input type="hidden" name="id" value="<%= p.getId() %>" readonly="true"><br><br>
Brand : <input type="text" name="brand" value="<%= p.getBrand() %>" readonly="true"><br><br>
Model : <input type="text" name="model" value="<%= p.getModel() %>" readonly="true"><br><br>
Category : <input type="text" name="category" value="<%= p.getCategory() %>" readonly="true"><br><br>
Price : <input type="number" name="price" value="<%= p.getPrice() %>" readonly="true"><br><br>
Quantity : <input type="number" name="quantity" ><br><br>
<input type="submit" value="Add To Cart">
</form>
</body>
</html>