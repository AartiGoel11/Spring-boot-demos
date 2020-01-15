<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.lang.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Remove Product Details.</title>
</head>
<body>

<%
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
int id = Integer.parseInt(request.getParameter("id"));
int k=0;
PreparedStatement ps=conn.prepareStatement("delete from product where id=?");
ps.setInt(1, id);
k=ps.executeUpdate();
if(k==1)
{
	 out.println("<html><body><h3 align='center'><font color='green'>Product is successfully deleted..</font></h3></body></html>");
}
else
{
	 out.println("<html><body><h3 align='center'><font color='red'>Product does not exist.</font></h3></body></html>");
}
%>

</body>
</html>