<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String productnameerror	 = (String)request.getAttribute("productnameerror");
	String priceError = (String)request.getAttribute("priceError");
	String categoryError = (String)request.getAttribute("categoryError");
	String qtyError = (String)request.getAttribute("qtyError");
%>
 <h2>ADD New Product</h2>
 <form action="SaveProductServlet" method="post">
 	ProductName : <input type="text" name="productName" /><%=productnameerror==null?"":productnameerror%><br>
 	<br>Price  :  <input type="text" name="price" /><%=priceError==null?"":priceError %><br>
 	<br>Category: <input type="text" name="category" /><%=categoryError==null?"":categoryError %><br>
 	<br>Qty :     <input type="text" name="qty" /><%=qtyError==null?"":qtyError %><br>
 	<br>
 	<input type="submit" value="Save Product"/>
 </form>
</body>
</html>