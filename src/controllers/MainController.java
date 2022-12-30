package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import controllers.actions.AddCustomer;
import controllers.actions.DeletingCustomer;
import controllers.actions.EditColumn;
import controllers.actions.NewCustomer;
import controllers.actions.SearchFilter;
import controllers.actions.SendEmails;
import database.AboutDatabase;
import database.PutInDatabase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import manager.birthdayMessage.BirthdayMessageManager;
import manager.cellFactory.CellFactoryManager;
import manager.checking.CheckerManager;
import manager.combobox.ComboboxManager;
import manager.data.DataManager;
import manager.datePicker.DatePickerManager;
import manager.errors.ErrorManager;
import manager.loading.LoadManager;
import manager.models.TableModel;
import manager.tableView.TableManager;
import manager.threads.ThreadManager;


public class MainController implements Initializable {
	
	
	// Root
	@FXML
	public TabPane root;
	
	//Tabl
	@FXML
	public Tab verwaltungstab;
	@FXML
	public Tab emailtab;

	
	//Panes
	@FXML
	public Pane verwaltung;
	@FXML
	public Pane email;

	
	//Labels
	@FXML
	public Label birthdayEmailLabel;
	
	//TextFields & Areas
	@FXML
	public TextField firstNameField;
	@FXML
	public TextField lastNameField;
	@FXML
	public TextField emailField;
	@FXML
	public TextField telephoneField;
	@FXML
	public TextField degreeField;
	@FXML
	public TextField searchField;
	@FXML
	public TextField searchOutputField;
	@FXML
	public TextArea  managementErrorArea;
	@FXML
	public TextField deleteField;
	
	@FXML
	public TextField birthdayEmailField;
	@FXML
	public TextArea birthdayMessageArea;
	@FXML 
	public TextField regardingField;
	@FXML
	public TextArea emailErrorArea;
	
	
	
	//Boxes and Pickers
	@FXML
	public DatePicker birthdayPicker;
	@FXML
	public DatePicker meetingDayPicker;
	@FXML
	public ComboBox<String> genderBox;
	@FXML
	public ComboBox<String> searchBox;
	
	//Buttons
	@FXML
	public Button newPersonButton;
	@FXML
	public Button sendDataButton;
	@FXML
	public Button nextPageButton;
	@FXML
	public Button darkmodeButton;
	@FXML
	public Button lightmodeButton;
	@FXML
	public Button searchButton;
	@FXML
	public Button lastPageButton;
	@FXML
	public Button undoButton;
	@FXML
	public Button restoreButton;
	@FXML
	public Button lastBirthdayMailButton;
	@FXML
	public Button nextBirthdayMailButton;
	@FXML
	public Button resetBirthdayMailButton;
	@FXML
	public Button sendEmailButton;

	
	//TableView + TableColumns
	@FXML
	public TableView<TableModel> tableView;
	@FXML
	public TableColumn<TableModel, String> firstNameColumn;
	@FXML
	public TableColumn<TableModel, String> lastNameColumn;
	@FXML
	public TableColumn<TableModel, String> birthdayColumn;
	@FXML
	public TableColumn<TableModel, String> emailColumn;
	@FXML
	public TableColumn<TableModel, String> telephoneColumn;
	@FXML
	public TableColumn<TableModel, String> degreeColumn;
	@FXML
	public TableColumn<TableModel, String> meetingDayColumn;
	@FXML
	public TableColumn<TableModel, String> genderColumn;
	
	//Images
	@FXML
	public ImageView backgroundImage;
	@FXML
	public ImageView ZanglLogo;
	@FXML
	public ImageView background;
	@FXML
	public ImageView zanglLogoBackground;
	
	//Database
	public AboutDatabase aboutDatabase;	
	public PutInDatabase putInDatabase;
	
	//Manager 
	public CheckerManager checkerManager;
	public LoadManager loadManager;
	public DataManager dataManager;
	public TableManager tableManager;
	public CellFactoryManager cellFactoryManager;
	public DatePickerManager datePickerManager;	
	public ErrorManager errorManager;
	public ThreadManager threadManager;
	public ComboboxManager comboboxManager;
	public BirthdayMessageManager birthdayMessageManager;
	
	//Controllers 
	public AddCustomer addCustomer;
	public EditColumn editColumns;
	public NewCustomer newCustomer;
	public DeletingCustomer deleteCustomer;
	public SearchFilter searchFilter;
	public SendEmails sendEmails;
	
	//Variablen
	

	//Wird ausgeführt, wenn das Program startet
	@Override
	public void initialize(URL url, ResourceBundle resource) {
		Controller.setMainController(this);
		//Manager Klassen
		checkerManager = new CheckerManager();
		loadManager = new LoadManager();
		dataManager = new DataManager();
		tableManager = new TableManager();
		cellFactoryManager = new CellFactoryManager();
		aboutDatabase = new AboutDatabase();
		putInDatabase = new PutInDatabase();
		datePickerManager = new DatePickerManager();
		errorManager = new ErrorManager();
		threadManager = new ThreadManager();
		comboboxManager = new ComboboxManager();
		birthdayMessageManager = new BirthdayMessageManager();
		
		//Controller Klassen
		addCustomer = new AddCustomer();
		editColumns = new EditColumn();
		newCustomer = new NewCustomer();
		deleteCustomer = new DeletingCustomer();
		searchFilter = new SearchFilter();
		sendEmails = new SendEmails();
		
		//Initialisation of Variables
		tableView.getSelectionModel().setCellSelectionEnabled(true);
		tableManager.refreshWholeTableView();	
	}

	//Daten in die Datenbank eintragen und auf der TableView sichtbar machen
	public void sendDataToDatabase(ActionEvent event) {
		managementErrorArea.clear();
		addCustomer.setCustomerInDatabase();
	}	
	
	//Neue Person anlegen
	public void setNewPerson(ActionEvent event) {
		newCustomer.setNewCustomer();
	}
	
	//Suchen mit Button 
	public void search(ActionEvent event) {
		searchFilter.searchFilter();
	}

	/*
	 * Hiermit kï¿½nnen die Zellen unabhängig voneinader bearbeitet werden
	 * */
	public void firstNameColumnEdit(CellEditEvent<TableModel, String> event) {
		editColumns.editFirstNameColumn(event);
		
	}

	public void lastNameColumnEdit(CellEditEvent<TableModel, String> event) {
		editColumns.editLastNameColumn(event);	
	}

	public void birthdayColumnEdit(CellEditEvent<TableModel, String> event) {
		editColumns.editBirthdayColumn(event);
	}

	public void emailColumnEdit(CellEditEvent<TableModel, String> event) {
		editColumns.editEmailColumn(event);
	}

	public void telephoneColumnEdit(CellEditEvent<TableModel, String> event) {
		editColumns.editTelNr(event);
	}

	public void degreeColumnEdit(CellEditEvent<TableModel, String> event) {
		editColumns.editDegree(event);
	}

	public void meetingDayColumnEdit(CellEditEvent<TableModel, String> event) {
		editColumns.editMeetingDayColumn(event);
	}

	public void genderColumnEdit(CellEditEvent<TableModel, String> event) {
		editColumns.editGenderColumn(event);
	}

	//Darkmode / Nachtmodus
	public void setDarkMode(ActionEvent event) throws IOException {  
		root.getStylesheets().addAll(getClass().getResource("/stylesheets/darkmode.css").toExternalForm());
	}
	
	//Lightmode / Heller Modus
	public void setOnLightMode(ActionEvent event) {
		root.getStylesheets().removeAll(getClass().getResource("/stylesheets/darkmode.css").toExternalForm());
	}

	//Reihe aus der Datenbank entfernen und die Tabelle updaten
	public void deleteRow(ActionEvent event) {
		deleteCustomer.deleteCustomer();	
	}
		
	//Neue Seite öffnen / weiter zur E-Mail Seite
	public void tabEmailPage(ActionEvent event) {
		verwaltungstab.getTabPane().getSelectionModel().select(emailtab);
	}
	
	//Zurï¿½ck zur Verwaltungsseite
	public void tabManagementPage(ActionEvent event) {
		emailtab.getTabPane().getSelectionModel().select(verwaltungstab);
	}
	
	//Einen Schritt zur+ckgehen
	public void undoBirthdayEmailArea(ActionEvent event) {
		birthdayMessageArea.undo();
	}

	//Einen Schritt nach vorne
	public void restoreBirthdayEmailArea(ActionEvent event) {
		birthdayMessageArea.redo();
	}
	
	//Es wird eine Mail zurï¿½ckgesprungen, falls eine existieren sollte.
	public void lastBirthdayMail(ActionEvent event) {
		birthdayMessageManager.lastBirthdayMail();
	}	
	
	//Es wird zur nï¿½chsten Email gesprungen, falls eine existieren sollte.
	public void nextBirthdayMail(ActionEvent event) {
		birthdayMessageManager.nextBirthdayMail();
	}
	
	//Text Area wird auf den Ursprung zurï¿½ckgesetzt
	public void resetBirthdayMessage(ActionEvent event) {
		birthdayMessageManager.resetBirthdayMail();
	}
	
	//Email senden
	public void sendEmail(ActionEvent event) {
		sendEmails.sendEmail();
	}
}
