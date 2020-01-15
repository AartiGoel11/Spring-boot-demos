package com.wipro;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 * Servlet implementation class MyServlet
 */
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn=null;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init()throws ServletException
    {
    	try{
    		Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
    public void destroy()
    {
    	try{
    		conn.close();
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String name=request.getParameter("uname");
		String pass=request.getParameter("upass");
		boolean flag=false;
		try{
			
			PreparedStatement pst=conn.prepareStatement("select * from users");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				String s1=rs.getString(1);
				String s2=rs.getString(2);
				System.out.println(s1+"   "+s2);
				if(s1.equals(name)&& s2.equals(pass))
				{
					flag=true;
					break;
				}
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		pw.println("<html><head><title>welcome</title></head><body>");
		if(flag==true)
		{
			pw.println("<h1>SUCCESS!!!!</h1>");
		}
		else
		{
			pw.println("<h1>FAIL!!!!</h1>");
		}
		
		pw.close();
		
	}

}
