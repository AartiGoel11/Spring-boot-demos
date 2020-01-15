package in.tp.adb.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

import in.tp.adb.exception.ADBException;
import in.tp.adb.model.Contact;

public interface ContactRepository {

	public static final String DB_URL="jdbc:derby:contactsDB;";
	public static final String DB_LOC=".addressBook";
	
	public static void initDB() throws IOException, SQLException {
		
		String[] dbCmds = new String(Files.readAllBytes(
				Paths.get("scripts/dbscript.sql"))).split(";");
		
		try(Connection con = DriverManager.getConnection(
				DB_URL+"create=true;")){
			Statement st = con.createStatement();
			Arrays.stream(dbCmds).forEach((cmd)->{
				try {
					st.execute(cmd);
				} catch (SQLException e) {
					System.err.println(e.getMessage());
				}
			});
		} catch (SQLException e) {
			throw e;
		}
	}
	
	default Connection getADBConnection() throws SQLException {
		return DriverManager.getConnection(DB_URL);
	}
	
	Contact addContact(Contact contact) throws ADBException;
	Contact updateContact(Contact contact) throws ADBException;
	List<Contact> getAllContacts() throws ADBException;
	Contact getContactById(long contactId) throws ADBException;
	boolean removeContact(long contactId) throws ADBException;
}
