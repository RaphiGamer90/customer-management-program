package controllers;

import java.net.URL;
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
//		closeWindow();
	}

	public void setErrorWindow(String errorMessage) {
		errorWindowTextArea.appendText("" + errorMessage);
	}

	public void cancelErrorInformation(ActionEvent event) {
		controller.getMainController().errorManager.getErrorStage().close();
		controller.getMainController().root.setDisable(false);
	}

	public void confirmErrorInformation(ActionEvent event) {
		controller.getMainController().errorManager.getErrorStage().close();
		controller.getMainController().root.setDisable(false);
		controller.getMainController().addCustomer.confirmErrorPopUp = true;
		System.out.println("Bestätigt");
		
	}	

	public void closeWindow() {
		controller.getMainController().errorManager.getErrorStage().setOnCloseRequest(new EventHandler<WindowEvent>() {
			public void handle(WindowEvent we) {
				controller.getMainController().errorManager.getErrorStage().close();
				controller.getMainController().root.setDisable(false);
			}
		});
		System.out.println("Das vorhaben wird abgebrochen!");
	}

	public boolean getErrorInformation() {
		return errorInformation;
	}
	
	
	

}
