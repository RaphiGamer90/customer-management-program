package controllers;

import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.WindowEvent;

public class ErrorWindowController implements Initializable {

	@FXML
	public BorderPane root;

	@FXML
	public TextArea errorWindowTextArea;

	@FXML
	public Button cancel;

	@FXML
	public Button confirm;

	Controller controller = new Controller();
	private boolean errorInformation;

	@Override
	public void initialize(URL url, ResourceBundle bundle) {
		Controller.setErrorWindowController(this);
		closeWindow();
	}
	
	/*Es werden die Fehlermeldungen ins Feld eigetragen*/
	public void setErrorWindow(String errorMessage) {
		errorWindowTextArea.appendText("" + errorMessage);
	}

	/*Abbruch der Fehlermeldung*/
	public void cancelErrorInformation(ActionEvent event) {
		controller.getMainController().errorManager.getErrorStage().close();
		controller.getMainController().root.setDisable(false);
	}

	/*Zustimmung der Fehlermeldung*/
	public void confirmErrorInformation(ActionEvent event) {
		controller.getMainController().errorManager.getErrorStage().close();
		controller.getMainController().root.setDisable(false);
		
		if(!(controller.getMainController().managementErrorArea.getText() == "" || controller.getMainController().managementErrorArea.getText().isEmpty() 
				|| controller.getMainController().managementErrorArea.getText().isBlank())) {
			return;
		}
		else if(errorWindowTextArea.getText().contains("E-Mail") || errorWindowTextArea.getText().contains("Telefonnummer")) {
			controller.getMainController().putInDatabase.putInDatabase(
					controller.getMainController().firstNameField.getText(), 
					controller.getMainController().lastNameField.getText(), 
					controller.getMainController().datePickerManager.getBirthdayDatePickerValue(), 
					controller.getMainController().emailField.getText(), 
					controller.getMainController().telephoneField.getText(), 
					controller.getMainController().degreeField.getText(), 
					controller.getMainController().datePickerManager.getMeetingDayDatePickerValue(), 
					controller.getMainController().genderBox.getValue());
			controller.getMainController().errorManager.clearErrorMessagesArea();
				
		}		
	}	

	/*Schlieﬂung der Fehlermeldung*/
	public void closeWindow() {
		controller.getMainController().errorManager.getErrorStage().setOnCloseRequest(new EventHandler<WindowEvent>() {
			public void handle(WindowEvent we) {
				controller.getMainController().errorManager.getErrorStage().close();
				controller.getMainController().root.setDisable(false);
			}
		});
	}

}
