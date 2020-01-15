package com.wipro.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletLogin
 */
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      String name = request.getParameter("uname");
      String pass = request.getParameter("upass");
      System.out.println(name+"  "+pass);
      boolean flag=false;
      
      try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      try {
			Connection	con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			PreparedStatement ps=con.prepareStatement("select * from users");
		    ResultSet rs = ps.executeQuery();
		    System.out.println("executed query.,,,");
		    while(rs.next())
		    {
		    	String s1= rs.getString(1);
		    	String s2= rs.getString(2);
		    	System.out.println("s1 "+s1);
		    	System.out.println("s2 "+s2);
		    	System.out.println("fetching values from db");
		    	if(s1.equals(name) && s2.equals(pass))
		    	{ 
		    		System.out.println("values....");
		    		flag=true;
		    	break;		    		
		    	}
		    }
			con.close();

			}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 if(flag==true)
	 { 
		 out.println("Hello "+name+" ! Welcome to my page <br>");
		 out.println("<html><body><a href='insertDetails.html'>Insert Product</a><br/></body></html>");
		 out.println("<html><body><a href='updateDetails.html'>Update Product</a><br/></body></html>");
		 out.println("<html><body><a href='deleteDetails.html'>Delete Product</a><br/></body></html>");
		 out.println("<html><body><a href='viewDetails.html'>View All Product details</a></body></html>");
		 
	 }

	}

}
