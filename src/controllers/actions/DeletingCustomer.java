package controllers.actions;

import controllers.Controller;
import database.DeleteFromDatabase;

public class DeletingCustomer {

	Controller controller = new Controller();
	DeleteFromDatabase deleteFromDatabase = new DeleteFromDatabase();
	
	public void deleteCustomer() {
		if(!controller.getMainController().dataManager.getReloadedEmails().contains(controller.getMainController().deleteField.getText())) {
			controller.getMainController().errorManager.throwErrors("Diese E-Mail existiert nicht!\n");
		}
		else {
			deleteFromDatabase.deleteValueFromDatabase(controller.getMainController().deleteField.getText());
			controller.getMainController().errorManager.clearErrorMessagesArea();
			controller.getMainController().errorManager.throwErrors("Person wurde erfolgreich entfernt!\n");
		}
	}
	
}
