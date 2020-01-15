<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add new Product</title>
</head>
<body>
	<h1 align="center">
		<font color="blue">Add Product Details </font>
	</h1>
	<form action="insertDB.jsp" method="post">
		<table align="center" bgcolor="wheat">
			<tr>
				<td>Enter Product Id :</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>Enter Product Name :</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Enter Product Price :</td>
				<td><input type="text" name="price"></td>
			</tr>
			<tr>
				<td>Enter Quantity :</td>
				<td><input type="text" name="qty"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit"></td>
			
				<td><input type="reset" value="Clear"></td>
			</tr>
		</table>
	</form>
</body>
</html>