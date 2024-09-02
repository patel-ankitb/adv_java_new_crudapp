<%@page import="java.sql.ResultSet"%>
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
	ResultSet rs = (ResultSet)request.getAttribute("rs");
%>
	<h2>Search Result</h2>
	<table border="1">
		<tr>
			<th>Name</th>
			<th>price</th>
			<th>qty</th>
		</tr>
		<%
			while(rs.next()){
				String Name = rs.getString("productName");
				Integer price = rs.getInt("price");
				Integer qty = rs.getInt("qty");
				out.println("<tr>");
				out.print("<td>" + Name+"</td>");
				out.print("<td>" + price +"</td>");
				out.print("<td>" + qty + "</td>");
				out.println("</tr>");
			}
		%>
	</table>
</body>
</html>