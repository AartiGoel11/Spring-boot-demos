package com.wipro.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Update
 */
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int id= Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		float price = Float.parseFloat(request.getParameter("price"));
		int qty= Integer.parseInt(request.getParameter("qty"));
		int k=0;
		 try {
				Connection	con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
				PreparedStatement ps=con.prepareStatement("update product set name=?,price=?,quantity=? where id=?");
				ps.setString(1, name);
				ps.setFloat(2, price);
				ps.setInt(3, qty);
				ps.setInt(4, id);
			   k = ps.executeUpdate();
			   con.close();
			   		    }
				
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(k==1)
		{
			out.println("Updated successfully..");
		}
		else
			out.println("Fail..");
	}

}
