package com.wipro.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class View
 */
public class View extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public View() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		 try {
				Connection	con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("select * from product");
				out.println("<html><body>All Product Details..</body></html>");
				 out.println("<table border=1 width=50% height=50%>");
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
				
			   con.close();
			   		    }
				
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
