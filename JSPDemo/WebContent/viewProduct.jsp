<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.lang.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Product Details.</title>
</head>
<body>
<%
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
Statement st = conn.createStatement();
ResultSet rs = st.executeQuery("select * from product");
 out.println("<table border=1 width=50% height=50 align='center' bgcolor='pink'>");
 out.println("<tr><th>ProductId</th><th>ProductName</th><th>Price</th><th>Quantity</th><tr>");
 while (rs.next()) {
     int n = rs.getInt("id");
     String nm = rs.getString("name");
     float p=rs.getFloat("price");
     int q=rs.getInt("quantity");
  
     out.println("<tr><td>" + n + "</td><td>" + nm + "</td><td>" + p + "</td><td>"+q+"</td></tr>"); 
 }
 out.println("</table>");
 out.println("</html></body>");

%>

</body>
</html>