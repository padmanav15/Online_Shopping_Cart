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
<center><h2><u><b>Update Page</b></u></h2></center>
<% Product p = (Product) request.getAttribute("updateproduct"); %>
<form action="productupdate" align="center" >

Id : <input type="number" value="<%= p.getId()%>"><br><br>
Brand : <input type="text" value="<%= p.getBrand()%>"><br><br>
Category : <input type="text" value="<%= p.getCategory()%>"><br><br>
Model : <input type="text" value="<%= p.getModel()%>"><br><br>
Price : <input type="number" value="<%= p.getPrice()%>"><br><br>
Stock : <input type="number" value="<%= p.getStock()%>"><br><br>
<input type="submit">
</form>
</body>
</html>