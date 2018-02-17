<%@ page import="com.productmanagement.dao.*" %>
<%@ page import="com.productmanagement.pojo.*" %>

<%

String username = request.getParameter("username");
String password = request.getParameter("password");

if(LoginDAO.isValidUser(new LoginInfo(username,password))) {
	
	session.setAttribute("username", username);
	session.setMaxInactiveInterval(200);
	response.sendRedirect("home.jsp");
} else {
	response.sendRedirect("loginFailed.jsp");
}

%>