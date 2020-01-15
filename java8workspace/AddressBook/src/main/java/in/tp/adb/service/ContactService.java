package in.tp.adb.service;

import java.util.List;
import java.util.Map;

import in.tp.adb.exception.ADBException;
import in.tp.adb.exception.ADBValidationException;
import in.tp.adb.model.Contact;

public interface ContactService {
	boolean isValidContact(Contact contact) throws ADBValidationException;
	Contact addContact(Contact contact) throws ADBValidationException, ADBException;
	Contact updateContact(Contact contact) throws ADBValidationException, ADBException;
	List<Contact> getAllContacts() throws ADBException;
	Contact getContactById(long contactId) throws ADBException;
	boolean removeContact(long contactId) throws ADBException;
}
