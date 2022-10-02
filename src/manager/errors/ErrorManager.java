package manager.errors;

import java.util.HashMap;

import controllers.Controller;

public class ErrorManager {

	Controller controller = new Controller();
	private HashMap<String, String> addCustomerErrorMap = new HashMap<>();
	private HashMap<String, String> editColumnErrorMap = new HashMap<>();


	public void throwAddCustomerErrors() {
		String errorMessage = "";
		for(String error : controller.getMainController().errorManager.getAddCustomerErrorMap().values()) {
			errorMessage += error;
			controller.getMainController().errorArea.setText(errorMessage);
		}
	}
	
	public void throwEditColumnErrors() {
		
	}
	
	public void clearErrorMessages() {
		controller.getMainController().errorArea.clear();
	}

	public HashMap<String, String> getAddCustomerErrorMap() {
		return addCustomerErrorMap;
	}

	public HashMap<String, String> getEditColumnErrorMap() {
		return editColumnErrorMap;
	}

}
