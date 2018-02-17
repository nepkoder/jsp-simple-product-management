<%@page import="com.productmanagement.dao.*" %>
<%@page import="com.productmanagement.pojo.*"%>

<%

String pId = request.getParameter("ProdctID");
String pName = request.getParameter("productName");
String pCategory = request.getParameter("productCategory");
Integer pPrice = Integer.parseInt(request.getParameter("productPrice"));

Product product = new Product(pId,pName,pCategory,pPrice);

int status = ProductManagementDAO.updateProdcut(product);
if(status ==1) {
	response.sendRedirect("viewProduct.jsp");
} else {
	response.sendRedirect("error.jsp");
}

%>