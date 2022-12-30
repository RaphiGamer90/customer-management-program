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
		setBirthdayMessages(0);
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
									+ " \n\n" + "Alles Gute zum Geburtstag!"
									+ " \n\n" + "Mit freundlichen Grüßen, \nGabriela Zangl-Gottwald",
							controller.getMainController().dataManager.getReloadedEmails().get(i)};
					messageList = Arrays.asList(herrList);

					birthdayMessageList.add(messageList);
					break;

				case "Frau":
					String[] frauList = {
							"Liebe Frau " + controller.getMainController().dataManager.getReloadedDegrees().get(i)
									+ " " + controller.getMainController().dataManager.getReloadedFirstNames().get(i)
									+ " \n\n" + "Alles Gute zum Geburtstag!"
									+ " \n\n" + "Mit freundlichen Grüßen, \nGabriela Zangl-Gottwald",
							controller.getMainController().dataManager.getReloadedEmails().get(i)};
					messageList = Arrays.asList(frauList);

					birthdayMessageList.add(messageList);
					break;
				
				case "Divers":
					String[] diversList = {
							"Liebe/r Frau/Herr " + controller.getMainController().dataManager.getReloadedDegrees().get(i)
									+ " " + controller.getMainController().dataManager.getReloadedFirstNames().get(i)
									+ " \n\n" + "Alles Gute zum Geburtstag!"
									+ " \n\n" + "Mit freundlichen Grüßen, \nGabriela Zangl-Gottwald",
							controller.getMainController().dataManager.getReloadedEmails().get(i)};
					messageList = Arrays.asList(diversList);

					birthdayMessageList.add(messageList);
					break;
				}
			}
			else {
				controller.getMainController().birthdayMessageArea.setText("Heute hat niemand Geburtstag!");
			}
		}
		
		return birthdayMessageList;
	}

	/*Setzt die generierten Geburtstags Emails*/
	public void setBirthdayMessages(int emailCount) {
		ArrayList<List<String>> emailList = generateBirthdayMessages();
		if(!emailList.isEmpty()) {
			controller.getMainController().birthdayEmailField.setText(emailList.get(emailCount).get(1));
			controller.getMainController().birthdayMessageArea.setText(emailList.get(emailCount).get(0));			
		}
	}
	
	int birthdayMessagesCount = 0;	
	public void nextBirthdayMail() {
		if(birthdayMessagesCount < generateBirthdayMessages().size()-1) {
			birthdayMessagesCount++;			
			setBirthdayMessages(birthdayMessagesCount);
		}
	}
	
	public void lastBirthdayMail() {
		if(birthdayMessagesCount > 0) {
			birthdayMessagesCount--;			
			setBirthdayMessages(birthdayMessagesCount);
		}
	}
	
	public void resetBirthdayMail() {
		setBirthdayMessages(birthdayMessagesCount);
	}

}
