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
	<form action="edit" method="post" %>
		Id<input type="number" value="<%=user.getId()%>" readonly="readonly" name="id"> 
		
			Name<input type="text" value="<%=user.getName()%>" name="name"> 
			
			Age<input type="number" value="<%=user.getAge()%>" name="age"> 
			
			Phone<input type="tel"	value="<%=user.getPhone()%>" name="phone"> 
			
			Password<input	type="password" value="<%=user.getPassword()%>" name="password"> 
			<input type="submit" value="update">
	</form>
	<%}else
	{
	response.sendRedirect("login.jsp");
	}%>

</body>
</html>