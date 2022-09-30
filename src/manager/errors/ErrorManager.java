package manager.errors;

import java.util.HashMap;

import controllers.Controller;

public class ErrorManager {

	Controller controller = new Controller();
	
	
	public boolean addCustomerErrors(String firstName, String lastName, String birthday, String email, String telNr, String degree, String meetingDay, String gender) {
		
		if(controller.getMainController().addCustomer.set)
		
		return true;
	}
	HashMap<String, String> addCustomerErrorMap = new HashMap<>();
	
	
	
	
	HashMap<String, String> editColumnErrorMap = new HashMap<>();
	
}
