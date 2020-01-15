<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.wipro.bean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="e1" class="com.wipro.bean.Employee"/>
<jsp:setProperty property="*" name="e1"/>
<table align="center" border="1" bgcolor="pink">
<tr>
	<td>Employee ID
	<td>Employee Name
	<td>Employee Address
	<td>Employee Age
	<td>Employee Salary
<tr>
	<td><jsp:getProperty property="empid" name="e1"/>
	<td><jsp:getProperty property="name" name="e1"/>
	<td><jsp:getProperty property="address" name="e1"/>
	<td><jsp:getProperty property="age" name="e1"/>
	<td><jsp:getProperty property="salary" name="e1"/>
</table>

</body>
<jsp:include page="NewEmployee.jsp"></jsp:include>
</html>