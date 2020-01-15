<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.lang.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
int id= Integer.parseInt(request.getParameter("id"));
String name=request.getParameter("name");
float price = Float.parseFloat(request.getParameter("price"));
int qty= Integer.parseInt(request.getParameter("qty"));
int k=0;
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
PreparedStatement ps=conn.prepareStatement("insert into product values(?,?,?,?)");
ps.setInt(1, id);
ps.setString(2, name);
ps.setFloat(3, price);
ps.setInt(4, qty);
k = ps.executeUpdate();
if(k==1)
{
	 out.println("Product details inserted successfully..");
	 response.sendRedirect("divisions.jsp");
}
else
	 out.println("fail");

%>
</body>
</html>