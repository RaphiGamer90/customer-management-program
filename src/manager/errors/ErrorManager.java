package manager.errors;

import java.util.ArrayList;

import controllers.Controller;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class ErrorManager {

	Controller controller = new Controller();
	private ArrayList<String> errorMessages = new ArrayList<>();
	private Stage errorStage = new Stage();

	public void throwErrors(String errorMessage) {

		switch (controller.getMainController().root.getSelectionModel().getSelectedItem().getText()) {
		case "Verwaltung":
			controller.getMainController().managementErrorArea.appendText("" + errorMessage);
			controller.getMainController().tableManager.refreshWholeTableView();
			break;

		case "E-Mail":
			controller.getMainController().managementErrorArea.appendText("" + errorMessage);
			controller.getMainController().tableManager.refreshWholeTableView();
			break;

		default:
			break;
		}

	}

	public void createErrorPopUpWindow() {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/fxmlFiles/ErrorWindow.fxml"));
			Scene errorScene = new Scene(root);
			errorStage.setScene(errorScene);
			errorStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void throwPopUpError(String errorMessage) {
		if (!errorStage.isShowing()) {
			createErrorPopUpWindow();
			controller.getMainController().root.setDisable(true);
		}
		controller.getErrorWindowController().setErrorWindow(errorMessage);
		
	}


	public void clearErrorMessagesArea() {
		controller.getMainController().managementErrorArea.clear();
	}

	public ArrayList<String> getErrorMessages() {
		return errorMessages;
	}

	public Stage getErrorStage() {
		return errorStage;
	}

}
