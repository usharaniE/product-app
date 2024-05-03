<%@page import="org.jsp.product_app.dto.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%List<Product> products=(List<Product>)request.getAttribute("products");
 %>
	<table border="2px">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Cost</th>
			<th>Type</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<%for(Product product:products){ %>
		<tr>
			<td><%=product.getId() %></td>
			<td><%=product.getName() %></td>
			<td><%=product.getCost() %></td>
			<td><%=product.getType() %></td>
			<td><a href="">edit</a></td>
			<td><a href="">delete</a></td>
		</tr>
		<%} %>
	</table>
</body>
</html>