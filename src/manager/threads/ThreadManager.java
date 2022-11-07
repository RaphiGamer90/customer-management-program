package manager.threads;

import controllers.Controller;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class ThreadManager {
	
	Controller controller = new Controller();
	
	//Threads
	Thread afkThread;
	
	
	//Variables
	int afkCount;

	public void startAFKThread() {
		afkCount = 240;
		
		afkThread = new Thread() {
			public void run() {
				while (true) {
					if (afkCount > 10) {
						afkCount--;
					} else if (afkCount <= 10 && afkCount >= 2) {
						controller.getMainController().errorArea.setText("Schlieﬂt in: " + afkCount);
						afkCount--;
					} else if (afkCount == 1) {
						controller.getMainController().errorArea.setText("Auf Wiedersehen!");
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

}
