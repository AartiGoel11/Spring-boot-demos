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
 * Servlet implementation class MyServletDB
 */
public class MyServletDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServletDB() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name= request.getParameter("uname");
		String pass=request.getParameter("upass");
		
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
					
					while(rs.next())
					{
						String s1=rs.getString(1);
						String s2=rs.getString(2);
						
						if(s1.equals(name) && s2.equals(pass))
						{
							flag =true;
							break;
						}
				} }
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(flag==true)
				{
					out.println("Login Successful..");
				}
				else
				{
					out.println("Login Fail..");
				}
				
					
					
				

			
		
		
	}

}
