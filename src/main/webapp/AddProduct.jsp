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
	<%User user=(User)session.getAttribute("user");
if(user!=null){%>
	<form action="saveProduct?user_id=<%=user.getId() %>" method="post">
		Name<input type="text" name="name"> 
		type<input type="text" name="type">
			 Cost<input type="number" name="cost">
			 <input type="submit" value="Add">
	</form>
	<%}else{
	 response.sendRedirect("login.jsp");
 }%>

</body>
</html>