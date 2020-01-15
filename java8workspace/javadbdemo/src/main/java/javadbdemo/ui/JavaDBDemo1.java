package javadbdemo.ui;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JavaDBDemo1 {

	static final String DBURL="jdbc:derby:vamcdb;create=true;";
	
	public static void main(String[] args) {
	
		final String dbPath = System.getProperty("user.home") +"/jdb";
		if(!Files.exists(Paths.get(dbPath)))
			try {
				Files.createDirectory(Paths.get(dbPath));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		System.setProperty("derby.system.home", dbPath);
		
		try(Connection con = DriverManager.getConnection(DBURL)){
			
			Statement st = con.createStatement();
			
			//create table
			st.execute("create table sampleTab(testid int primary key,testnm varchar(25))");
			
			System.out.println("database is initialized!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
