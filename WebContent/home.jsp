<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>Welcome !!</h2>
<%
String username = (String)session.getAttribute("username");
%>
<h2>Product Management System</h2>
<h3>Welcome <%= username %> !!</h3>

</body>
</html>