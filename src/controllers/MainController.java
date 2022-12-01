package controllers;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

import manager.errors.ErrorManager;
import manager.filter.SearchFilterManager;
import controllers.actions.AddCustomer;
import controllers.actions.DeletingCustomer;
import controllers.actions.EditColumn;
import controllers.actions.NewCustomer;
import manager.datePicker.DatePickerManager;
import database.AboutDatabase;
import database.DataFromDatabase;
import database.DeleteFromDatabase;
import database.PutInDatabase;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
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
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import manager.birthdayMessage.BirthdayMessageManager;
import manager.cellFactory.CellFactoryManager;
import manager.checking.CheckerManager;
import manager.combobox.ComboboxManager;
import manager.data.DataManager;
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
	public Button newPerson;
	@FXML
	public Button sendData;
	@FXML
	public Button nextPageButton;
	@FXML
	public Button darkmodeButton;
	@FXML
	public Button lightmodeButton;
	@FXML
	public Button searchButton;
	@FXML
	public Button lastPage;
	@FXML
	public Button undo;
	@FXML
	public Button restore;
	@FXML
	public Button beforeMail;
	@FXML
	public Button nextMail;
	@FXML
	public Button resetButton;
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
	public LoadManager loadManager;
	public DataManager dataManager;
	public TableManager tableManager;
	public CellFactoryManager cellFactoryManager;
	public DatePickerManager datePickerManager;	
	public ErrorManager errorManager;
	public ThreadManager threadManager;
	public ComboboxManager comboboxManager;
	public BirthdayMessageManager birthdayMessageManager;
	public SearchFilterManager searchFilterManager;
	
	//Controllers 
	public AddCustomer addCustomer;
	public EditColumn editColumns;
	public NewCustomer newCustomer;
	public DeletingCustomer deleteCustomer;
 
	int countForBirthdayEmails;
	Thread birthdayThread;
	
	

	
	//Setzen der Mails in die Birthday Area
	public void setBirthdayAreaContent() {
//		  countForBirthdayEmails = 0;
//			if (!birthdayMessage.getBirthdayEmailList().isEmpty()) {
//				String birthdayEmail = birthdayMessage.getBirthdayEmailList().get(countForBirthdayEmails);
//				birthdayEmailField.setText(birthdayEmail);
//			} else {
//				birthdayEmailField.setText("");
//			}
//
//			String birthDayMessageString = birthdayMessage.getBirthdayMessage().get(countForBirthdayEmails);
//			birthdayMessageArea.setText(birthDayMessageString);
	}
	
	//Listen Update der Birthday Area
	public void changeListenerForBirthdayArea() {
//		birthdayMessageArea.textProperty().addListener(new ChangeListener<String>() {
//
//			@Override
//			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
//				birthdayMessage.getBirthdayMessage().set(countForBirthdayEmails, birthdayMessageArea.getText());
//				
//			}
//		});
//		
	}
	
	//ALLES WAS BEIM START AUSGEFï¿½HRT WERDEN SOLL// 
	public void init() {
		setBirthdayAreaContent();
		changeListenerForBirthdayArea();
	}	
	
	
	//Wird ausgeführt, wenn das Program startet
	@Override
	public void initialize(URL url, ResourceBundle resource) {
		Controller.setMainController(this);
		//Manager Klassen
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
		searchFilterManager = new SearchFilterManager();
		birthdayMessageManager = new BirthdayMessageManager();
		

		
		addCustomer = new AddCustomer();
		editColumns = new EditColumn();
		newCustomer = new NewCustomer();
		deleteCustomer = new DeletingCustomer();
		
		
		tableView.getSelectionModel().setCellSelectionEnabled(true);
		
		tableManager.refreshWholeTableView();
		init();
			
	}

	//Daten in die Datenbank eintragen und auf der Tabelle sichtbar machen
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
		searchFilterManager.searchFilter();
	}

	/*
	 * Hiermit kï¿½nnen die Zellen unabhï¿½ngig voneinader bearbeitet werden
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
		root.getStylesheets().add(getClass().getResource("/stylesheets/darkmode.css").toExternalForm());
	}
	
	//Lightmode / Heller Modus
	public void setOnLightMode(ActionEvent event) {
		root.getStylesheets().remove(getClass().getResource("/stylesheets/darkmode.css").toExternalForm());
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
	public void switchBackMail(ActionEvent event) {
//		emailErrorField.setText("");
//		if (countForBirthdayEmails >= 0) {
//			countForBirthdayEmails -= 1;
//		}
//
//		if (countForBirthdayEmails >= 0 && !birthdayMessage.getBirthdayEmailList().isEmpty() && !birthdayMessage.getBirthdayMessage().isEmpty()) {
//			String birthdayEmail = birthdayMessage.getBirthdayEmailList().get(countForBirthdayEmails);
//			birthdayEmailField.setText(birthdayEmail);
//			String birthDayMessageString = birthdayMessage.getBirthdayMessage().get(countForBirthdayEmails);
//			birthdayMessageArea.setText(birthDayMessageString);
//		} else {
//			countForBirthdayEmails += 1;
//			return;
//		}
	}
	
	//Es wird zur nï¿½chsten Email gesprungen, falls eine existieren sollte.
	public void switchNextMail(ActionEvent event) {
//		emailErrorField.setText("");
//		if (countForBirthdayEmails < birthdayMessage.getBirthdayEmailList().size()) {
//			countForBirthdayEmails += 1;
//		}
//
//		if (countForBirthdayEmails < birthdayMessage.getBirthdayEmailList().size()&& !birthdayMessage.getBirthdayEmailList().isEmpty() && !birthdayMessage.getBirthdayMessage().isEmpty()) {
//			String birthdayEmail = birthdayMessage.getBirthdayEmailList().get(countForBirthdayEmails);
//			birthdayEmailField.setText(birthdayEmail);
//			String birthDayMessageString = birthdayMessage.getBirthdayMessage().get(countForBirthdayEmails);
//			birthdayMessageArea.setText(birthDayMessageString);
//		} else {
//			countForBirthdayEmails -= 1;
//			return;
//		}
	}
	
	//Text Area wird auf den Ursprung zurï¿½ckgesetzt
	public void reset(ActionEvent event) {
		emailErrorArea.setText("");
//		birthdayMessage = new BirthdayMessage();
//		birthdayMessageArea.setText(birthdayMessage.getBirthdayMessage().get(countForBirthdayEmails));
//		birthdayMessage.getBirthdayMessage().set(countForBirthdayEmails, birthdayMessage.getBirthdayMessage().get(countForBirthdayEmails));
		
	}
	
	
	//Email senden
	public void sendEmail(ActionEvent event) {
		ArrayList<String> mailErrorMessage = new ArrayList<>();
		boolean mailSendingChecker = true;
		
		if (birthdayEmailField.getText().equals("")) {
			emailErrorArea.setText("Es kann keine E-Mail verschickt werden!");
			mailSendingChecker = false;
		} else {
			if (regardingField.getText().equals("")) {
				mailErrorMessage.add("Bitte tragen Sie noch einen Betreff ein!");
				mailSendingChecker = false;
			}
			if (birthdayMessageArea.getText().equals("")) {
				mailErrorMessage.add("Es kann keine E-Mail verschickt werden, ohne Inhalt!");
				mailSendingChecker = false;
			}
			if (mailSendingChecker) {
//				SendingEmail sendingEmail = new SendingEmail();
				emailErrorArea.setStyle("-fx-text-fill: green;");
				emailErrorArea.setFont(new Font("Arial", 24));
				emailErrorArea.setText("Die E-Mail wird zum Versenden vorbereitet!");
//				sendingEmail.sendmail(birthdayEmailField.getText(), regardingField.getText(), birthdayMessageArea.getText());
//				emailErrorField.setText(sendingEmail.getMessageSendingText());
			} else {
				String messageForSendingProcessField = "";
				for (String error : mailErrorMessage) {
					messageForSendingProcessField += error + "\n";
				}
				emailErrorArea.setFont(new Font("Arial", 16));
				emailErrorArea.setText(messageForSendingProcessField);
			}
		}
	}


}
