<%@page import="com.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<center>
  <div id="alertSuccess" class="alert alert-primary"></div>
	<div id="alertError" class="alert alert-danger"></div>

	<br>
	<div id="divItemsGrid">
 		<%
 			User userObj = new User();
 			out.print(userObj.readUsers());
 		%>
	</div>
	</center>

</body>
</html>