package manager.birthdayMessage;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import controllers.Controller;

public class BirthdayMessageManager {

	Controller controller = new Controller();

	public BirthdayMessageManager() {
		setBithdayMessages();

	}

	/* Generiert Geburtstagsbenachrichtigungen */
	public ArrayList<List<String>> generateBirthdayMessages() {
		ArrayList<List<String>> birthdayMessageList = new ArrayList<>();

		Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int day = localDate.getDayOfMonth();
		int month = localDate.getMonthValue();

		for (int i = 0; i < controller.getMainController().aboutDatabase.getRowsCount(); i++) {
			List<String> messageList = new ArrayList<String>();

			if (controller.getMainController().dataManager.getReloadedBirthdays().get(i)
					.contains(day + "." + month + ".")) {

				switch (controller.getMainController().dataManager.getReloadedGenders().get(i)) {
				case "Herr":
					String[] herrList = {
							"Lieber Herr " + controller.getMainController().dataManager.getReloadedDegrees().get(i)
									+ " " + controller.getMainController().dataManager.getReloadedFirstNames().get(i)
									+ " \n" + "Alles Gute zum Geburtstag!",
							controller.getMainController().dataManager.getReloadedEmails().get(i), "Das ists!" };
					messageList = Arrays.asList(herrList);

					birthdayMessageList.add(messageList);
					break;
				case "Frau":
					String[] frauList = {
							"Liebe Frau" + controller.getMainController().dataManager.getReloadedDegrees().get(i)
									+ "\n" + controller.getMainController().dataManager.getReloadedFirstNames().get(i)
									+ " " + "Alles Gute zum Geburtstag!",
							controller.getMainController().dataManager.getReloadedEmails().get(i), "Das ists!" };
					messageList = Arrays.asList(frauList);

					birthdayMessageList.add(messageList);
					break;
				case "Divers":
					String[] diversList = {
							"Lieber Herr" + controller.getMainController().dataManager.getReloadedDegrees().get(i)
									+ "\n" + controller.getMainController().dataManager.getReloadedFirstNames().get(i)
									+ " " + "Alles Gute zum Geburtstag!",
							controller.getMainController().dataManager.getReloadedEmails().get(i), "Das ists!" };
					messageList = Arrays.asList(diversList);

					birthdayMessageList.add(messageList);
					break;
				case "Unknown":
					String[] unknownList = {
							"Lieber Herr" + controller.getMainController().dataManager.getReloadedDegrees().get(i)
									+ "\n" + controller.getMainController().dataManager.getReloadedFirstNames().get(i)
									+ " " + "Alles Gute zum Geburtstag!",
							controller.getMainController().dataManager.getReloadedEmails().get(i), "Das ists!" };
					messageList = Arrays.asList(unknownList);

					birthdayMessageList.add(messageList);
					break;

				default:
					break;
				}

			}

		}
		return birthdayMessageList;

	}

	public void setBithdayMessages() {
		for (List<String> a : generateBirthdayMessages()) {
			for (String b : a) {
				controller.getMainController().birthdayMessageArea.appendText(b);

			}
		}

	}

}
