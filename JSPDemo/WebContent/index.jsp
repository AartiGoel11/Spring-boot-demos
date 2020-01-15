<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FlipKart</title>
</head>
<body>
<h1 align="center"><font color="blue">Welcome to FlipKart </font></h1>
<h4 align="center">Please Login :</h4>
<form action="login.jsp" method="post">
<table align="center" bgcolor="wheat">
<tr><td> Enter Your Name : </td><td><input type="text" name="uname"></td></tr>
<tr><td>Enter Password :</td><td><input type="password" name="upass"></td></tr>
<tr><td><input type="submit" value="Submit"></td><td><input type="reset" value="Clear"></td></tr>
<tr><td><a href="registration.jsp">New User? Sign up here</a></td></tr>
</table>
</form>
</body>
</html>