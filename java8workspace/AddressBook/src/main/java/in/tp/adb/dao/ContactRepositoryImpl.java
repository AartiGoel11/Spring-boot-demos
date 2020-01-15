package in.tp.adb.dao;

import static in.tp.adb.dao.IQueryMapper.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import in.tp.adb.exception.ADBException;
import in.tp.adb.model.Contact;

public class ContactRepositoryImpl implements ContactRepository {

	Logger logger = null;
	public ContactRepositoryImpl() throws ADBException {
		logger = Logger.getLogger(this.getClass());
		
		final String dbPath = System.getProperty("user.home") +"/" + DB_LOC;
		System.setProperty("derby.system.home",dbPath);
		
		if (!Files.exists(Paths.get(dbPath))) {
			try {
				Files.createDirectory(Paths.get(dbPath));
				ContactRepository.initDB();
			} catch (IOException | SQLException e) {
				logger.error(e);
				throw new ADBException("DB initialization failed");
			}
		}
	}

	@Override
	public Contact addContact(Contact contact) throws ADBException {
		Contact result = null;
		try (Connection con = getADBConnection()) {
			PreparedStatement pIns = con.prepareStatement(INS_CONT_QRY);
			pIns.setLong(1, contact.getContactId());
			pIns.setString(2, contact.getName());
			pIns.setString(3, contact.getMobile());
			pIns.setString(4, contact.getMailId());
			pIns.executeUpdate();
			result = contact;
		} catch (SQLException e) {
			logger.error(e);
			throw new ADBException("Could not save the record");
		}
		return result;
	}

	@Override
	public Contact updateContact(Contact contact) throws ADBException {
		Contact result = null;
		try (Connection con = getADBConnection()) {
			PreparedStatement pUpd = con.prepareStatement(UPD_CONT_QRY);

			pUpd.setString(1, contact.getName());
			pUpd.setString(2, contact.getMobile());
			pUpd.setString(3, contact.getMailId());
			pUpd.setLong(4, contact.getContactId());
			pUpd.executeUpdate();
			result = contact;
		} catch (SQLException e) {
			logger.error(e);
			throw new ADBException("Could not save the record");
		}
		return result;
	}

	@Override
	public List<Contact> getAllContacts() throws ADBException {
		List<Contact> contacts = new ArrayList<>();
		try (Connection con = getADBConnection()) {
			ResultSet rs = con.prepareStatement(GET_ALL_CONT_QRY).executeQuery();
			while (rs.next()) {
				Contact c = new Contact();
				c.setContactId(rs.getLong(1));
				c.setName(rs.getString(2));
				c.setMobile(rs.getString(3));
				c.setMailId(rs.getString(4));
				contacts.add(c);
			}
		} catch (SQLException e) {
			logger.error(e);
			throw new ADBException("Could not retrive records");
		}
		return contacts.size() > 0 ? contacts : null;
	}

	@Override
	public Contact getContactById(long contactId) throws ADBException {
		Contact contact=null;
		try(Connection con = getADBConnection()){
			PreparedStatement pst = con.prepareStatement(GET_CONT_BY_ID_QRY);
			pst.setLong(1, contactId);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {		
				contact = new Contact();
				contact.setContactId(rs.getLong(1));
				contact.setName(rs.getString(2));
				contact.setMobile(rs.getString(3));
				contact.setMailId(rs.getString(4));
			}
		}catch(SQLException e) {
			logger.error(e);
			throw new ADBException("Could not retrive the record");
		}
		return contact;
	}

	@Override
	public boolean removeContact(long contactId) throws ADBException {
		boolean isDeleted=false;
		try(Connection con = getADBConnection()){
			PreparedStatement pst = con.prepareStatement(DEL_CONT_QRY);
			pst.setLong(1, contactId);
			if(pst.executeUpdate()>0)
				isDeleted=true;
		}catch(SQLException e) {
			logger.error(e);
			throw new ADBException("Could not delete the record");
		}
		return isDeleted;
	}

}
