package controllers.actions;

import controllers.Controller;
import manager.email.SendingEmail;

public class SendEmails {
	
	SendingEmail sendingEmail = new SendingEmail();
	Controller controller = new Controller();

	/*
	 *Versenden einer Mail unter bestimmten Vorraussetzungen 
	 * */
	public void sendEmail() {		
		if((controller.getMainController().birthdayEmailField.getText().isEmpty() 
				|| controller.getMainController().birthdayEmailField.getText().isBlank()) 
				|| (controller.getMainController().regardingField.getText().isEmpty()
				|| controller.getMainController().regardingField.getText().isBlank())
				|| (controller.getMainController().birthdayMessageArea.getText().isEmpty()
				|| controller.getMainController().birthdayMessageArea.getText().isBlank())) {
			controller.getMainController().errorManager.throwErrors("Überprüfen Sie, ob alle Felder ausgefüllt sind!");
			return;
		}
		
		if(!controller.getMainController().checkerManager.isValidEmailAddress(controller.getMainController().birthdayEmailField.getText())) {
			controller.getMainController().errorManager.throwErrors("Die E-Mail, die Sie versuchen zu kontaktieren ist keine richtige E-Mail!");
			return;
		}
		
		sendingEmail.sendmail(controller.getMainController().birthdayEmailField.getText(), 
				controller.getMainController().regardingField.getText(), 
				controller.getMainController().birthdayMessageArea.getText());
		controller.getMainController().errorManager.throwErrors("Die E-Mail wurde versendet!");
	}
}
