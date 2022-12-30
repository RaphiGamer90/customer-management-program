package manager.threads;

import java.util.Random;

import controllers.Controller;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class ThreadManager {

	Controller controller = new Controller();

	// Threads
	Thread afkThread;
	Thread birthdayThread;

	// Variables
	int afkCount;

	public ThreadManager() {
		startAFKThread();
		startBirthdayThread();
	}

	// Es wird ein Thread gestartet, der das Programm nach 4 Minuten schließt, wenn
	// der User die Maus nicht bewegt
	public void startAFKThread() {
		afkCount = 240;

		afkThread = new Thread() {
			public void run() {
				while (true) {
					if (afkCount > 10) {
						afkCount--;
					} else if (afkCount <= 10 && afkCount >= 2) {
						controller.getMainController().managementErrorArea.setText("Schließt in: " + afkCount);
						afkCount--;
					} else if (afkCount == 1) {
						controller.getMainController().managementErrorArea.setText("Auf Wiedersehen!");
						afkCount--;
					} else if (afkCount == 0) {
						Platform.exit();
					} else {
						Platform.exit();
					}
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		};

		controller.getMainController().root.setOnMouseMoved(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				afkCount = 240;
			}
		});

		afkThread.start();
	}

	// Es wird für die Überschrift ein Thread gestartet, der die Farbe der Schrift
	// verändert
	public void startBirthdayThread() {
		birthdayThread = new Thread() {
			public void run() {
				while (true) {
					Random myColor = new Random();
					controller.getMainController().birthdayEmailLabel
							.setTextFill(Color.rgb(myColor.nextInt(255), myColor.nextInt(255), myColor.nextInt(255)));
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		};
		birthdayThread.start();
	}

}
