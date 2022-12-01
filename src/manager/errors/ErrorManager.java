package manager.errors;

import java.util.ArrayList;
import java.util.HashMap;

import controllers.Controller;

public class ErrorManager {

	Controller controller = new Controller();
	private ArrayList<String> errorMessages = new ArrayList<>();
	
	public ErrorManager() {

	}

	
	public void throwErrors(String errorMessage) {
		
		switch (controller.getMainController().root.getSelectionModel().getSelectedItem().getText()) {
		case "Verwaltung":
			controller.getMainController().managementErrorArea.appendText(""+errorMessage);
			controller.getMainController().tableManager.refreshWholeTableView();
			break;
		
		case "E-Mail":
			controller.getMainController().managementErrorArea.appendText(""+errorMessage);
			controller.getMainController().tableManager.refreshWholeTableView();
		break;
		
		default:
			break;
		}

		
	}
	
	
	public void clearErrorMessagesArea() {
		controller.getMainController().managementErrorArea.clear();
	}

	public ArrayList<String> getErrorMessages() {
		return errorMessages;
	}
	
}
