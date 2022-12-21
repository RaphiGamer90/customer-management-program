package controllers;

import javafx.fxml.FXMLLoader;

public class Controller {

    private static MainController mainController;
    

    public MainController getMainController() {
        return mainController;
    }

    public static void setMainController(MainController mainController) {
    	Controller.mainController = mainController;
    }

    public static void setMainControllerLoader(FXMLLoader mainControllerLoader) {
    	Controller.mainController = mainControllerLoader.getController();
    }
    
    
    
    private static ErrorWindowController errorWindowController;
    
    public ErrorWindowController getErrorWindowController() {
        return errorWindowController;
    }

    public static void setErrorWindowController(ErrorWindowController mainController) {
    	Controller.errorWindowController = mainController;
    }

    public static void setErrorWindowControllerLoader(FXMLLoader errorWindowControllerLoader) {
    	Controller.errorWindowController = errorWindowControllerLoader.getController();
    }
}