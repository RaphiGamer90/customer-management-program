package controllers.actions;

import controllers.Controller;

public class NewCustomer {

	Controller controller = new Controller();
	
	public void setNewCustomer() {
		controller.getMainController().firstNameField.setText("");
		controller.getMainController().lastNameField.setText("");
		controller.getMainController().birthdayPicker.getEditor().clear();
		controller.getMainController().birthdayPicker.setValue(null);
		controller.getMainController().emailField.setText("");
		controller.getMainController().telephoneField.setText("");
		controller.getMainController().degreeField.setText("");
		controller.getMainController().meetingDayPicker.getEditor().clear();
		controller.getMainController().meetingDayPicker.setValue(null);
		controller.getMainController().genderBox.getSelectionModel().clearSelection();
	}
	
}
