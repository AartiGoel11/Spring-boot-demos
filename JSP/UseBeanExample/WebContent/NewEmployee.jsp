<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Employee</title>
</head>
<body>
<h1 align="center"><font color='blue'>New Employee</font></h1>
<form action="store.jsp">
<table align="center" bgcolor="wheat">
<tr>
	<td>Enter Employee ID:
	<td><input type="text" name="empid">
<tr>
	<td>Enter Employee Name:
	<td><input type="text" name="name">
<tr>
	<td>Enter Employee Address:
	<td><input type="text" name="address">
<tr>
	<td>Enter Employee Age:
	<td><input type="text" name="age">
<tr>
	<td>Enter Employee Salary:
	<td><input type="salary" name="salary">
<tr>
	<td><input type="submit" value="Submit">
	<td><input type="reset" value="Clear">

</table>
</form>
</body>
</html>