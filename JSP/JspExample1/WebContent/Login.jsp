<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.Date"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login page</title>
</head>
<body>
<%!
public String getDate()
{
	Date d1=new Date();
	return d1.toString();
}


%>
<h5 align="right"><%=getDate() %></h5>
<h1 align="center"><font color="blue">Login Page</font></h1>
<form action="validate.jsp">
<table align="center" bgcolor="wheat">
<tr>
	<td>Enter username:
	<td><input type="text" name="uname">
<tr>
	<td>Enter password:
	<td><input type="password" name="upass">
<tr>
	<td><input type="submit" value="Submit">
	<td><input type="reset" value="Clear">

</table>
</form>
</body>
</html>