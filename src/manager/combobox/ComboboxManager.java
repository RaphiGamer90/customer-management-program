package manager.combobox;

import controllers.Controller;

public class ComboboxManager {

	Controller controller = new Controller();

	public ComboboxManager() {
		setGenderBoxChoices();
		setSearchBoxChoices();
	}

	public void setGenderBoxChoices() {
		controller.getMainController().genderBox.getItems().addAll("Herr", "Frau", "Divers");
	}

	public void setSearchBoxChoices() {
		controller.getMainController().searchBox.getItems().addAll("Alle", "Vorname", "Nachname", "Geburtstag",
				"E-Mail", "Telefonnummer", "Titel", "Auftrag Datum", "Geschlecht");
	}

}
