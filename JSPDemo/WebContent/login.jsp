<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.lang.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Validation Details</title>
</head>
<body>

	<%
String s1 = request.getParameter("uname");
String s2=request.getParameter("upass");
boolean flag=false;
  Class.forName("oracle.jdbc.driver.OracleDriver");
Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
PreparedStatement ps = conn.prepareStatement("select * from users"); 
ResultSet rs = ps.executeQuery();
while(rs.next())
{ String col1 = rs.getString(1);
String col2=rs.getString(2);
	
	if(s1.equals(col1) && s2.equals(col2))
	{
		flag=true;
		break;
	}
	
}
if(flag==true)
{
	out.println("<h4 align='center'><font color='green'>Successfully Login</font></h4>");
	response.sendRedirect("divisions.jsp");
}
else
{
	response.sendRedirect("failure.jsp");
}
%>
</body>
</html>