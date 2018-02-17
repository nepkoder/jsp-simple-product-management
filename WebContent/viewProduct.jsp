<%@page import="java.util.List"%>
<%@page import="com.productmanagement.dbutil.*" %>
<%@page import="com.productmanagement.dao.*" %>
<%@page import="com.productmanagement.pojo.*" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View products</title>
</head>
<body>

<table align="text-center">
<thead>
<tr>
<th>Product ID</th>
<th>Product Name</th>
<th>Product Category</th>
<th>Product Price</th>
</tr>
</thead>

<%
List<Product> pList = ProductManagementDAO.getAllProducts();
for(Product p: pList) {
	%>
	<tr>
	<td><%=p.getProductId() %></td>
	<td><%=p.getProductName() %></td>
	<td><%=p.getProductCategory() %></td>
	<td><%=p.getProductPrice() %></td>
	<td><button class="btn btn-primary"></button>
	</tr>
	<% 
}
%>

</table>

</body>
</html>