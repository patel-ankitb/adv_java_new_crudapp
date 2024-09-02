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
	String firstNameError = (String)request.getAttribute("firstNameError");
	String birthYearError = (String) request.getAttribute("birthYearError");
	%>
	
  <form action="EmployeeRegistrationServlet" method="post">
  		FirstName : <input type="text" name="firstName" />
		<%=firstNameError==null?"":firstNameError %>
		<br>
		<Br> Email : <input type="text" name="email" /><br>
		<Br> Password : <input type="text" name="password" /><br>
		<Br> BirthYear : <input type="text" name="birthYear" />
			<%=birthYearError==null?"":birthYearError %>
		<br>
		<Br> <input type="submit" value="Register" />
  			
  
  </form>
</body>
</html>