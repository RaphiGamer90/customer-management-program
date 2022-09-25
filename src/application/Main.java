package application;

import java.net.URL;
import java.sql.SQLException;

import controllers.MainController;
import database.ConnectionToDatabase;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Side;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;


public class Main extends Application {
	
	ConnectionToDatabase connection = new ConnectionToDatabase();
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			connection.openConnection();
			primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			    @Override
			    public void handle(WindowEvent event) {
			    	try {
						ConnectionToDatabase.closeConnection();
					} catch (SQLException e) {
						e.printStackTrace();
					}
			        Platform.exit();
			        System.exit(0);
			    }
			});
			Parent root = FXMLLoader.load(getClass().getResource("ControlSystem.fxml"));
			MainController controller = root.getController();
			primaryStage.getIcons().add(new Image(this.getClass().getResourceAsStream("/images/ZanglIcon.png")));
			
			System.out.println("Program wurde gestartet!");
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/stylesheets/application.css").toExternalForm());
			primaryStage.setMaximized(true);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
