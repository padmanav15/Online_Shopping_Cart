<%@page import="com.jsp.shoppingcart.dto.Cart"%>
<%@page import="com.jsp.shoppingcart.dto.Product"%>
<%@page import="com.jsp.shoppingcart.dto.Customer"%>
<%@page import="java.util.List"%>
<%@page import="com.jsp.shoppingcart.dto.Item"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	List<Item> items = (List<Item>) request.getAttribute("itemslist");
	double totalprice = (double) request.getAttribute("totalprice");
	%>
	<center>
		<h1>Cart Table</h1>
	</center>
	<table border="2" align="center" cellpadding="20px">
		<th>Brand</th>
		<th>Category</th>
		<th>Model</th>
		<th>Quantity</th>
		<th>Price</th>

		<%
		for (Item i : items) {
		%>

		<tr>
			<td><%=i.getBrand()%></td>
			<td><%=i.getCategory()%></td>
			<td><%=i.getModel()%></td>
			<td><%=i.getQuantity()%></td>
			<td><%=i.getPrice() %></td>
		</tr>

		<%
		}
		%>


	</table><br>
	<center>
				Total Price : <input type="number" value="<%=totalprice%>"><br>
			</center>
	<center>
		<h3>
			<a href="addorder">Buy Now</a>
		</h3>
	</center>
</body>
</html>