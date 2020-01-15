<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.lang.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register into Database</title>
</head>
<body>
<%
String s1 = request.getParameter("uname");
String s2=request.getParameter("upass");
boolean flag=false;
  Class.forName("oracle.jdbc.driver.OracleDriver");
Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
PreparedStatement ps=conn.prepareStatement("insert into users values(?,?)");
ps.setString(1, s1);
ps.setString(2, s2);
 int k = ps.executeUpdate();
 if(k==1)
	{
		out.println("<h4 align='center'><font color='green'> Successfully Registered</font></html>");
		response.sendRedirect("index.jsp");
	}


%>
</body>
</html>