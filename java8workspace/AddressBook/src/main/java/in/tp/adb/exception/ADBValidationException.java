package in.tp.adb.exception;

import java.util.Map;

public class ADBValidationException extends Exception {
	
	Map<String, String> errorMessages;
	
	public ADBValidationException(Map<String, String> errorMessages) {
		super(errorMessages.toString());
		this.errorMessages=errorMessages;
	}
	
	public Map<String, String> getErrorMessages(){
		return errorMessages;
	}
	
	public String getErrorOfField(String field) {
		return errorMessages.get(field);
	}
}
