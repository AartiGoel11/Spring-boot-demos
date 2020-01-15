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
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		String name = request.getParameter("userName");
		String password=request.getParameter("password");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int k=0;
				try {
					Connection	con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
					PreparedStatement ps=con.prepareStatement("insert into users values(?,?)");
					ps.setString(1, name);
					ps.setString(2, password);
					 k = ps.executeUpdate();		
					con.close();
		
					}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(k==1)
				{
					out.println(" Successfully Registered");
					out.println("<html><body><a href='mainPage.html'> Login Page</a>");
				}
		
		
		
	}

}
