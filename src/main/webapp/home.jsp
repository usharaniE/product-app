<%@page import="org.jsp.product_app.dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	User user = (User) session.getAttribute("user");
	if (user != null) {
	%>
	<h1>
		Welcome Mr.<%=user.getName()%></h1>
	<h2>
		<a href="edit.jsp">Edit Account</a>
	</h2>
	<h2>
		<a href="AddProduct.jsp">Add Product</a>
	</h2>
	<h2>
		<a href="view?user_id=<%=user.getId()%>">View Kart</a>
	</h2>
	<%
	}

	else {
	response.sendRedirect("login.jsp");
	}
	%>

</body>
</html>