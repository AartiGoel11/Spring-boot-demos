package in.tp.adb.service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;

import in.tp.adb.dao.ContactRepository;
import in.tp.adb.dao.ContactRepositoryImpl;
import in.tp.adb.exception.ADBException;
import in.tp.adb.exception.ADBValidationException;
import in.tp.adb.model.Contact;

public class ContactServiceImpl implements ContactService {
	
	private ContactRepository repo;
	
	public ContactServiceImpl() throws ADBException {
		repo=new ContactRepositoryImpl();
	}

	private boolean isValidContactId(long contactId) {
		return contactId>=1;
	}
	
	private boolean isValidName(String name) {
		return name.trim().length()>0 && name.trim().length()<=25;
	}
	
	private boolean isValidMobile(String mobile) {
		Pattern mobilePattern = Pattern.compile("\\d{10}");
		return mobilePattern.matcher(mobile).matches();
	}
	
	private boolean isValidEmail(String mailId) {
		Pattern emailPattern = Pattern.compile("^(.+)@(.+)$");
		return emailPattern.matcher(mailId).matches();
	}
	
	@Override
	public boolean isValidContact(Contact contact) throws ADBValidationException {
		boolean isValid=false;
		
		if(contact!=null) {
			Map<String,String> errMsgs = new TreeMap<>();
			if(!isValidContactId(contact.getContactId())) {
				errMsgs.put("contactId", "can not be negative or zero");
			}
			if(!isValidName(contact.getName())) {
				errMsgs.put("name", 
						"can not be empty and must be less than 25 chars in length");
			}
			if(!isValidMobile(contact.getMobile())) {
				errMsgs.put("mobile", 
						"cannot anything other than 10 digits");
			}
			if(!isValidEmail(contact.getMailId())) {
				errMsgs.put("mailId", "is not valid");
			}
			
			if(errMsgs.size()>0)
				throw new ADBValidationException(errMsgs);
			else
				isValid=true;
			
		}else {
			throw new ADBValidationException(Collections.singletonMap("contact", null));
		}
		
		return isValid;
	}

	@Override
	public Contact addContact(Contact contact) throws ADBValidationException, ADBException {
		Contact result=null;
		if(isValidContact(contact))
			result=repo.addContact(contact);
		return result;
	}

	@Override
	public Contact updateContact(Contact contact) throws ADBValidationException, ADBException {
		Contact result=null;
		if(isValidContact(contact))
			result=repo.updateContact(contact);
		return result;
	}

	@Override
	public List<Contact> getAllContacts() throws ADBException {
		return repo.getAllContacts();
	}

	@Override
	public Contact getContactById(long contactId) throws ADBException {
		return repo.getContactById(contactId);
	}

	@Override
	public boolean removeContact(long contactId) throws ADBException {
		return repo.removeContact(contactId);
	}

}
