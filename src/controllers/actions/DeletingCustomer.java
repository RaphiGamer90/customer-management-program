package controllers.actions;

import controllers.Controller;
import database.DeleteFromDatabase;

public class DeletingCustomer {

	Controller controller = new Controller();
	DeleteFromDatabase deleteFromDatabase = new DeleteFromDatabase();
	
	public void deleteCustomer() {
		if(!controller.getMainController().dataManager.getReloadedEmails().contains(controller.getMainController().deleteField.getText())) {
			controller.getMainController().errorManager.getErrorMessages().add(controller.getMainController().errorManager.getManagementErrorMessages().get("emailNotExists"));
			controller.getMainController().errorManager.throwErrors();
		}
		else {
			deleteFromDatabase.deleteValueFromDatabase(controller.getMainController().deleteField.getText());
			controller.getMainController().errorManager.clearErrorMessagesArea();
			controller.getMainController().tableManager.refreshWholeTableView();	
		}
	}
	
}
