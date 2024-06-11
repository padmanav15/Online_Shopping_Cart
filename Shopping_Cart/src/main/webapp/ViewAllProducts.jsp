<%@page import="com.jsp.shoppingcart.dto.Merchant"%>
<%@page import="com.jsp.shoppingcart.dto.Product"%>
<%@page import="java.util.List" isELIgnored="false"%>
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
	Merchant merchant = (Merchant) session.getAttribute("merchantinfo");
	List<Product> plist = merchant.getProducts();
	%>
	<table border="2" align="center" cellpadding="20px">
		<th>Id</th>
		<th>Brand</th>
		<th>Category</th>
		<th>Model</th>
		<th>Price</th>
		<th>Stock</th>
		<th>Update</th>
		<th>Delete</th>

		<%
		for (Product p : plist) {
		%>
		<tr>
			<td><%=p.getId()%></td>
			<td><%=p.getBrand()%></td>
			<td><%=p.getCategory()%></td>
			<td><%=p.getModel()%></td>
			<td><%=p.getPrice()%></td>
			<td><%=p.getStock()%></td>
			<td><a href="Updateproduct">update</a></td>
			<td><a href="deleteproduct?id=<%=p.getId()%>">delete</a></td>
		</tr>
		<%
		}
		%>

	</table>
	<br>
	<br>
	<center>
		<a href="MerchantMenu.jsp">click here to go Menu Page </a>
	</center>
</body>
</html>