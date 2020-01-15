package in.tp.jd.ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SampleConnectivityCheck {

	public static void main(String[] args) {
		
		try(Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/cgidb","root","root")){
			System.out.println("Connected!");
		}catch(SQLException ex) {
			ex.printStackTrace();
		}

	}

}
