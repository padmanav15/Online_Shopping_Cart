<%@page import="com.jsp.shoppingcart.dto.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.jsp.shoppingcart.dto.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>
		<center>
			<b><u>Product Table</u></b>
		</center>
	</h1>
	<% 
       List<Product> plist = (List<Product>) request.getAttribute("productlist");
    %>
    <h3><a href="fetchitemsfromcart">View Cart</a></h3>
	<table border="2" align="center" cellpadding="20px">
		<th>Brand</th>
		<th>Category</th>
		<th>Model</th>
		<th>Price</th>
		<th>Add to Cart</th>


		<%
		for (Product p : plist) {
		%>
		<tr>
			<td><%=p.getBrand()%></td>
			<td><%=p.getCategory()%></td>
			<td><%=p.getModel()%></td>
			<td><%=p.getPrice()%></td>
			<td><a href="addtocart?id=<%= p.getId() %>"><center>add</center></a></td>
		</tr>

		
		<%} %>

	</table>
	<br>
	<br>
	<center>
		<a href="CustomerMenu.jsp">click here to go Menu Page </a><br> <br>
		<a href="CustomerOption.jsp">click here to go Option Page </a>
	</center>
</body>
</html>