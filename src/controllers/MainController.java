package controllers;

import java.net.URL;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

import controllers.actions.AddCustomer;
import controllers.actions.EditColumn;
import controllers.listener.DatePickerListener;
import database.AboutDatabase;
import database.ConnectionToDatabase;
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
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import manager.birthdayMessage.BirthdayMessage;
import manager.cellFactory.CellFactory;
import manager.checking.Checker;
import manager.data.DataManager;
import manager.loading.tableView.LoadWholeTableView;
import manager.models.TableModel;
import manager.sendEmail.SendingEmail;


public class MainController implements Initializable {
	
	
	// Root
	@FXML
	private TabPane root;
	
	//Tabl
	@FXML
	private Tab verwaltungstab;
	@FXML
	private Tab emailtab;

	
	//Panes
	@FXML
	private Pane verwaltung;
	@FXML
	private Pane email;

	
	//Labels
	@FXML
	private Label firstNameLabel;
	@FXML
	private Label lastNameLabel;
	@FXML
	private Label birthdayLabel;
	@FXML
	private Label emailLabel;
	@FXML
	private Label telephoneLabel;
	@FXML
	private Label titleLabel;
	@FXML
	private Label orderDateLabel;
	@FXML
	private Label genderLabel;
	@FXML
	private Label birthdayEmailLabel;
	
	//TextFields & Areas
	@FXML
	private TextField firstNameField;
	@FXML
	private TextField lastNameField;
	@FXML
	private TextField emailField;
	@FXML
	private TextField telephoneField;
	@FXML
	private TextField titleField;
	@FXML
	private TextField searchField;
	@FXML
	private TextField searchFieldOutput;
	@FXML
	private TextArea errorArea;
	@FXML
	private TextField deleteField;
	@FXML
	private TextField birthdayEmailField;
	@FXML
	private TextArea birthdayMessageArea;
	@FXML
	private TextArea emailErrorField;
	@FXML 
	private TextField regardingField;
	
	
	//Boxes and Pickers
	@FXML
	private DatePicker birthdayPicker;
	@FXML
	private DatePicker meetingDayPicker;
	@FXML
	private ComboBox<String> genderBox;
	@FXML
	private ComboBox<String> searchFor;
	
	//Buttons
	@FXML
	private Button newPerson;
	@FXML
	private Button sendData;
	@FXML
	private Button nextPage;
	@FXML
	private Button nightButton;
	@FXML
	private Button lightButton;
	@FXML
	private Button lastPage;
	@FXML
	private Button undo;
	@FXML
	private Button restore;
	@FXML
	private Button beforeMail;
	@FXML
	private Button nextMail;
	@FXML
	private Button resetButton;
	@FXML
	private Button sendEmailButton;

	
	//TableView + TableColumns
	@FXML
	private TableView<TableModel> tableView;
	@FXML
	private TableColumn<TableModel, String> firstNameColumn;
	@FXML
	private TableColumn<TableModel, String> lastNameColumn;
	@FXML
	private TableColumn<TableModel, String> birthdayColumn;
	@FXML
	private TableColumn<TableModel, String> emailColumn;
	@FXML
	private TableColumn<TableModel, String> telephoneColumn;
	@FXML
	private TableColumn<TableModel, String> titleColumn;
	@FXML
	private TableColumn<TableModel, String> orderDateColumn;
	@FXML
	private TableColumn<TableModel, String> genderColumn;
	
	//Images
	@FXML
	private ImageView backgroundImage;
	@FXML
	private ImageView ZanglLogo;
	@FXML
	private ImageView background;
	@FXML
	private ImageView zanglLogoBackground;
	
	//Connection
	ConnectionToDatabase connection = new ConnectionToDatabase();

	
	//Variablen 
	ObservableList<TableModel> searchModelObservableList = FXCollections.observableArrayList();
	AboutDatabase aboutDatabase = new AboutDatabase();
	DataManager dataManager = new DataManager();
	CellFactory cellFactory = new CellFactory();
	
	
	String birthdayFieldValue, meetingDayValue;
	
	String firstNameForDatabase, lastNameForDatabase, birthdayForDatabase, emailForDatabase, telephoneForDatabase, titleForDatabase, orderDateForDatabase, genderForDatabase;
	
	DataFromDatabase dataFromDatabase = new DataFromDatabase();
	Checker checker = new Checker();
	PutInDatabase putInDatabase = new PutInDatabase();
	ColorAdjust colorAdjust = new ColorAdjust(); 
	int afkCount;
	int countForBirthdayEmails;
	Thread afkThread;
	Thread birthdayThread;
	DeleteFromDatabase deleteFromDatabase = new DeleteFromDatabase();
	BirthdayMessage birthdayMessage = new BirthdayMessage();
	
	
	
	
	DatePickerListener datepickerListener = new DatePickerListener();
	

	
	//AFK Thread
	public void startAFKThread() {
		afkCount = 1200;
		afkThread = new Thread() 
		{
			public void run()
			{
				while (true){
					if(afkCount > 10) {
						afkCount--;
	            	}else if(afkCount <= 10 && afkCount >= 2) {
	            		errorArea.setText("Schließt in: " + afkCount);
	            		afkCount--;
	            	}else if(afkCount == 1) {
	            		errorArea.setText("Auf Wiedersehen!");
	            		afkCount--;
	            	}
	            	else if(afkCount == 0) {
	            		Platform.exit();
	            	}
	            	else {
	            		Platform.exit();
	            	}
					try
	                {
	                    Thread.sleep(1000); 
	                } catch (Exception e)
	                {
	                    e.printStackTrace();
	                }
	            }
	        }
	    };
	    
	    root.setOnMouseMoved(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				afkCount = 1200;
			}
			
	    });
		
	}
	
	//Es wird für die Überschrift ein Thread gestartet, der die Farbe der Schrift verändert
	public void startBirthdayThread() {
		birthdayThread = new Thread() 
		{
			public void run()
			{
				while (true){
					 Random myColor = new Random();
					 birthdayEmailLabel.setTextFill(Color.rgb(myColor.nextInt(255), myColor.nextInt(255), myColor.nextInt(255)));
					try
	                {
	                    Thread.sleep(1000); 
	                } catch (Exception e)
	                {
	                    e.printStackTrace();
	                }
	            }
	        }
	    };
	}
	
	//Setzen der Mails in die Birthday Area
	public void setBirthdayAreaContent() {
		  countForBirthdayEmails = 0;
			if (!birthdayMessage.getBirthdayEmailList().isEmpty()) {
				String birthdayEmail = birthdayMessage.getBirthdayEmailList().get(countForBirthdayEmails);
				birthdayEmailField.setText(birthdayEmail);
			} else {
				birthdayEmailField.setText("");
			}

			String birthDayMessageString = birthdayMessage.getBirthdayMessage().get(countForBirthdayEmails);
			birthdayMessageArea.setText(birthDayMessageString);
	}
	
	//Listen Update der Birthday Area
	public void changeListenerForBirthdayArea() {
		birthdayMessageArea.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				birthdayMessage.getBirthdayMessage().set(countForBirthdayEmails, birthdayMessageArea.getText());
				
			}
		});
		
	}
	
	//Formalitäten setzen
	public void setFormalities() {
		searchFieldOutput.setText(tableView.getItems().size() + "");
	    afkThread.start();
	    birthdayThread.start();
		firstNameLabel.setId("label");
		lastNameLabel.setId("label");
		birthdayLabel.setId("label");
		emailLabel.setId("label");
		telephoneLabel.setId("label");
		titleLabel.setId("label");
		orderDateLabel.setId("label");
		genderLabel.setId("label");
		genderBox.setScaleX(2);
		genderBox.setScaleY(2);
		birthdayPicker.setScaleX(2);
		birthdayPicker.setScaleY(2);
		meetingDayPicker.setScaleX(2);
		meetingDayPicker.setScaleY(2);
		tableView.getSelectionModel().setCellSelectionEnabled(true);
		tableView.setEditable(true);
		genderBox.getItems().addAll("Herr", "Frau", "Divers", "Unknown");
		searchFor.getItems().addAll("Alle", "Vorname", "Nachname", "Geburtstag", "E-Mail", "Telefonnummer", "Titel", "Auftrag Datum", "Geschlecht");
	}
	
	//ALLES WAS BEIM START AUSGEFÜHRT WERDEN SOLL// 
	public void init() {
		loadData();
		searchFilter();
		startAFKThread();
		startBirthdayThread();
		setFormalities();
		setBirthdayAreaContent();
		changeListenerForBirthdayArea();
		hasToBe();
	}	
	
	//Wird ausgeführt, wenn das Program startet
	@Override
	public void initialize(URL url, ResourceBundle resource) {
			init();
		 datepickerListener.addBirthdayDatepickerListener(birthdayPicker);
		 datepickerListener.addMeetingDayDatePickerListener(meetingDayPicker);
	}
	
	//Ladet Daten, die in die Tabelle eingetragen werden
	public void loadData() {
		LoadWholeTableView loadTableView = new LoadWholeTableView();
		loadTableView.loadWholeTableView(tableView, firstNameColumn, lastNameColumn, birthdayColumn, emailColumn, telephoneColumn, titleColumn, orderDateColumn, genderColumn,
				searchModelObservableList, aboutDatabase, dataManager, cellFactory);
	}
	
	
	//Suchfilter für Daten aus der Tabelle
	public void searchFilter() {
//		searchField.textProperty().addListener((observable, oldValue, newValue) -> {
//			filteredData.setPredicate(searchModel -> {
//				if(newValue.isEmpty() || newValue.isBlank() || newValue == null) {
//					return true;
//				}
//				String searchKeyword = newValue.toLowerCase();
//				
//				if(searchFor.getValue() == null || searchFor.getValue() == "Alle") {
//					if(searchModel.getFirstName().toLowerCase().indexOf(searchKeyword) != -1) {
//						return true;
//					}	
//					else if(searchModel.getLastName().toLowerCase().indexOf(searchKeyword) != -1) {
//						return true;
//					}
//					else if(searchModel.getBirthday().toLowerCase().indexOf(searchKeyword) != -1) {
//						return true;
//					}
//					else if(searchModel.getEmail().toLowerCase().indexOf(searchKeyword) != -1) {
//						return true;
//					}
//					else if(searchModel.getTelNr().toLowerCase().indexOf(searchKeyword) != -1) {
//						return true;
//					}
//					else if(searchModel.getDegree().toLowerCase().indexOf(searchKeyword) != -1) {
//						return true;
//					}
//					else if(searchModel.getMeetingDay().toLowerCase().indexOf(searchKeyword) != -1) {
//						return true;
//					}
//					else if(searchModel.getGender().toLowerCase().indexOf(searchKeyword) != -1) {
//						return true;
//					}
//					
//				}
//				else if(searchFor.getValue().equals("Vorname")) {
//					if(searchModel.getFirstName().toLowerCase().indexOf(searchKeyword) != -1) {
//						return true;
//					}
//					return false;
//				}
//				else if(searchFor.getValue().equals("Nachname")) {
//					if(searchModel.getLastName().toLowerCase().indexOf(searchKeyword) != -1) {
//						return true;
//					}
//					return false;
//				}
//				else if(searchFor.getValue().equals("Geburtstag")) {
//					if(searchModel.getBirthday().toLowerCase().indexOf(searchKeyword) != -1) {
//						return true;
//					}
//					return false;
//				}
//				else if(searchFor.getValue().equals("E-Mail")) {
//					if(searchModel.getEmail().toLowerCase().indexOf(searchKeyword) != -1) {
//						return true;
//					}
//					return false;
//				}
//				else if(searchFor.getValue().equals("Telefonnummer")) {
//					if(searchModel.getTelNr().toLowerCase().indexOf(searchKeyword) != -1) {
//						return true;
//					}
//					return false;
//				}
//				else if(searchFor.getValue().equals("Titel")) {
//					if(searchModel.getDegree().toLowerCase().indexOf(searchKeyword) != -1) {
//						return true;
//					}
//					return false;
//				}
//				else if(searchFor.getValue().equals("Auftrag Datum")) {
//					if(searchModel.getMeetingDay().toLowerCase().indexOf(searchKeyword) != -1) {
//						return true;
//					}
//					return false;
//				}
//				else if(searchFor.getValue().equals("Geschlecht")) {
//					if(searchModel.getGender().toLowerCase().indexOf(searchKeyword) != -1) {
//						return true;
//					}
//					return false;
//				}
//				
//				return false;
//				
//			});
//			
//			searchFieldOutput.setText(tableView.getItems().size() + "");
//		});
		
//		SortedList<TableModel> sortedData = new SortedList<>(filteredData);
//		
//		sortedData.comparatorProperty().bind(tableView.comparatorProperty());
//		
//		tableView.setItems(sortedData);
		
	}
	
	
	
	//Neue Person anlegen
	public void setNewPerson(ActionEvent event) {
		try {
			firstNameField.setText("");
			lastNameField.setText("");
			birthdayPicker.getEditor().clear();
			birthdayPicker.setValue(null);
			emailField.setText("");
			telephoneField.setText("");
			titleField.setText("");
			meetingDayPicker.getEditor().clear();
			meetingDayPicker.setValue(null);
			genderBox.getSelectionModel().clearSelection();	
		} catch (DateTimeParseException e) {}
		
		
	}

	//Daten in die Datenbank eintragen und auf der Tabelle sichtbar machen
	public void sendDataToDatabase(ActionEvent event) {
		AddCustomer addPerson = new AddCustomer();
		addPerson.setCustomerInDatabase(firstNameField, lastNameField, emailField, 
				datepickerListener.getBirthdayDatePickerValue(), telephoneField, titleField, datepickerListener.getMeetingDayDatePickerValue(), genderBox, errorArea);
		loadData();
	}

	/*
	 * Hiermit können die Zellen unabhängig voneinader bearbeitet werden
	 * */
	EditColumn editColumns = new EditColumn();
	public void firstNameColumnEdit(CellEditEvent<TableModel, String> event) {
		editColumns.editFirstNameColumn(event);
		loadData();
	}

	public void lastNameColumnEdit(CellEditEvent<TableModel, String> event) {
		editColumns.editLastNameColumn(event);
		loadData();
	}

	public void birthdayColumnEdit(CellEditEvent<TableModel, String> event) {
		editColumns.editBirthdayColumn(event);
		loadData();
	}

	public void emailColumnEdit(CellEditEvent<TableModel, String> event) {
		editColumns.editEmailColumn(event);
		loadData();
	}

	public void telephoneColumnEdit(CellEditEvent<TableModel, String> event) {
		editColumns.editTelNr(event);
		loadData();
	}

	public void degreeColumnEdit(CellEditEvent<TableModel, String> event) {
		editColumns.editDegree(event);
		loadData();
	}

	public void meetingDayColumnEdit(CellEditEvent<TableModel, String> event) {
		
	}

	public void genderColumnEdit(CellEditEvent<TableModel, String> event) {
	
	}

	
	//Darkmode / Nachtmodus
	public void setOnNightMode(ActionEvent event) {   
		//Image Background Views
		//Muss nicht unbedingt sein :d
		
		//Vorname
		firstNameLabel.setStyle("-fx-text-fill: #e8e8df;");
		firstNameField.setStyle("-fx-background-color: grey; -fx-text-inner-color: #e8e8df; -fx-border-color: black;");
		//Nachname
		lastNameLabel.setStyle("-fx-text-fill: #e8e8df;");
		lastNameField.setStyle("-fx-background-color: #292b2a; -fx-text-inner-color: #e8e8df; -fx-border-color: black;");
		//Geburtstag
		birthdayLabel.setStyle("-fx-text-fill: #e8e8df;");
		birthdayPicker.getStylesheets().add(getClass().getResource("@../stylesheets/picker.css").toExternalForm());
		birthdayPicker.getStylesheets().add(getClass().getResource("@../stylesheets/popupForPicker.css").toExternalForm());
		//E-Mail
		emailLabel.setStyle("-fx-text-fill: #e8e8df;");
		emailField.setStyle("-fx-background-color: #292b2a; -fx-text-inner-color: #e8e8df; -fx-border-color: black;");
		//Telefon
		telephoneLabel.setStyle("-fx-text-fill: #e8e8df;");
		telephoneField.setStyle("-fx-background-color: grey; -fx-text-inner-color: #e8e8df; -fx-border-color: black;");
		//Title
		titleLabel.setStyle("-fx-text-fill: #e8e8df;");
		titleField.setStyle("-fx-background-color: #292b2a; -fx-text-inner-color: #e8e8df; -fx-border-color: black;");
		//Auftrag Datum
		orderDateLabel.setStyle("-fx-text-fill: #e8e8df;");
		meetingDayPicker.getStylesheets().add(getClass().getResource("/cssfiles/picker.css").toExternalForm());
		meetingDayPicker.getStylesheets().add(getClass().getResource("/cssfiles/popupForPicker.css").toExternalForm());
		//Geschlecht
		genderLabel.setStyle("-fx-text-fill: #e8e8df;");
		genderBox.getStylesheets().add(getClass().getResource("/cssfiles/combobox.css").toExternalForm());
		//Neue Person
		newPerson.getStylesheets().add(getClass().getResource("/cssfiles/button.css").toExternalForm());
		//Daten senden
		sendData.getStylesheets().add(getClass().getResource("/cssfiles/button.css").toExternalForm());
		//Error Area
		errorArea.setStyle("-fx-background-color: black; -fx-control-inner-background: #292b2a;");
		//Suchen
		searchField.setStyle("-fx-background-color: grey; -fx-text-inner-color: #e8e8df; -fx-border-color: black;");
		//Suche nach
		searchFor.getStylesheets().add(getClass().getResource("/cssfiles/combobox.css").toExternalForm());
		//Darkmode
		nightButton.getStylesheets().add(getClass().getResource("/cssfiles/button.css").toExternalForm());
		//Lightmode
		lightButton.getStylesheets().add(getClass().getResource("/cssfiles/button.css").toExternalForm());
		//Such Feld ausgabe
		searchFieldOutput.setStyle("-fx-text-fill: #e8e8df;");
		searchFieldOutput.setStyle("-fx-background-color: grey; -fx-text-inner-color: #e8e8df; -fx-border-color: black;");
		//Lösch Feld
		deleteField.setStyle("-fx-text-fill: #e8e8df;");
		deleteField.setStyle("-fx-background-color: grey; -fx-text-inner-color: #e8e8df; -fx-border-color: black;");
		//Nächste Seite
		nextPage.getStylesheets().add(getClass().getResource("/cssfiles/button.css").toExternalForm());
		//TableView
		tableView.getStylesheets().add(getClass().getResource("/cssfiles/tableview.css").toExternalForm());
		
		//Email Feld
		birthdayEmailField.setStyle("-fx-text-fill: #e8e8df;");
		birthdayEmailField.setStyle("-fx-background-color: #292b2a; -fx-text-inner-color: #e8e8df; -fx-border-color: black;");
		//Betreff Feld
		regardingField.setStyle("-fx-text-fill: #e8e8df;");
		regardingField.setStyle("-fx-background-color: #292b2a; -fx-text-inner-color: #e8e8df; -fx-border-color: black;");
		//Geburtstags Area
		birthdayMessageArea.setStyle("-fx-background-color: black; -fx-control-inner-background: #292b2a;");
		//Einen Schritt zurück
		undo.getStylesheets().add(getClass().getResource("/cssfiles/button.css").toExternalForm());
		//Einen Schritt wieder herstellen
		restore.getStylesheets().add(getClass().getResource("/cssfiles/button.css").toExternalForm());
		//Zurück
		lastPage.getStylesheets().add(getClass().getResource("/cssfiles/button.css").toExternalForm());
		//Geburtstags Mail Error Feld
		emailErrorField.setStyle("-fx-background-color: black; -fx-control-inner-background: #292b2a;");
		//Mail zuvor
		beforeMail.getStylesheets().add(getClass().getResource("/cssfiles/button.css").toExternalForm());
		//Mail danach
		nextMail.getStylesheets().add(getClass().getResource("/cssfiles/button.css").toExternalForm());
		//Zurücksetzen
		resetButton.getStylesheets().add(getClass().getResource("/cssfiles/button.css").toExternalForm());
		//Senden
		sendEmailButton.getStylesheets().add(getClass().getResource("/cssfiles/button.css").toExternalForm());
		
	}
	
	
	//Lightmode / Heller Modus
	public void setOnLightMode(ActionEvent event) {
		background.setEffect(null);
		backgroundImage.setEffect(null);  
		firstNameLabel.setStyle(null);
		firstNameField.setStyle(null);
		lastNameLabel.setStyle(null);
		lastNameField.setStyle(null);
		birthdayLabel.setStyle(null);
		birthdayPicker.getStylesheets().clear();
		emailLabel.setStyle(null);
		emailField.setStyle(null);
		telephoneLabel.setStyle(null);
		telephoneField.setStyle(null);
		titleLabel.setStyle(null);
		titleField.setStyle(null);
		orderDateLabel.setStyle(null);
		meetingDayPicker.getStylesheets().clear();
		genderLabel.setStyle(null);
		genderBox.getStylesheets().clear();
		newPerson.getStylesheets().clear();
		sendData.getStylesheets().clear();
		errorArea.setStyle(null);
		searchField.setStyle(null);
		searchFor.getStylesheets().clear();
		nightButton.getStylesheets().clear();
		lightButton.getStylesheets().clear();
		searchFieldOutput.setStyle(null);
		deleteField.setStyle(null);
		nextPage.getStylesheets().clear();
		tableView.getStylesheets().clear();
		
		birthdayEmailField.setStyle(null);
		regardingField.setStyle(null);
		birthdayMessageArea.setStyle(null);
		undo.getStylesheets().clear();
		restore.getStylesheets().clear();
		lastPage.getStylesheets().clear();
		emailErrorField.setStyle(null);
		beforeMail.getStylesheets().clear();
		nextMail.getStylesheets().clear();
		resetButton.getStylesheets().clear();
		sendEmailButton.getStylesheets().clear();
		hasToBe();
		
	}
	
	//Reihe aus der Datenbank entfernen und die Tabelle updaten
	public void deleteRow(ActionEvent event) {
		deleteFromDatabase.deleteValueFromDatabase(deleteField.getText());
		loadData();
	}
	
	
	//Neue Seite öffnen / weiter zur E-Mail Seite
	public void tabNewPage(ActionEvent event) {
		birthdayMessage = new BirthdayMessage();
		setBirthdayAreaContent();
		verwaltungstab.getTabPane().getSelectionModel().select(emailtab);
		
	}
	
	//Zurück zur Verwaltungsseite
	public void tabLastPage(ActionEvent event) {
		emailtab.getTabPane().getSelectionModel().select(verwaltungstab);
	}
	
	//Einen Schritt zurückgehen
	public void undoBirthdayEmailArea(ActionEvent event) {
		birthdayMessageArea.undo();
	}
	
	//Einen Schritt nach vorne
	public void restoreBirthdayEmailArea(ActionEvent event) {
		birthdayMessageArea.redo();
	}
	
	//Es wird eine Mail zurückgesprungen, falls eine existieren sollte.
	public void switchBackMail(ActionEvent event) {
		emailErrorField.setText("");
		if (countForBirthdayEmails >= 0) {
			countForBirthdayEmails -= 1;
		}

		if (countForBirthdayEmails >= 0 && !birthdayMessage.getBirthdayEmailList().isEmpty() && !birthdayMessage.getBirthdayMessage().isEmpty()) {
			String birthdayEmail = birthdayMessage.getBirthdayEmailList().get(countForBirthdayEmails);
			birthdayEmailField.setText(birthdayEmail);
			String birthDayMessageString = birthdayMessage.getBirthdayMessage().get(countForBirthdayEmails);
			birthdayMessageArea.setText(birthDayMessageString);
		} else {
			countForBirthdayEmails += 1;
			return;
		}
	}
	
	//Es wird zur nächsten Email gesprungen, falls eine existieren sollte.
	public void switchNextMail(ActionEvent event) {
		emailErrorField.setText("");
		if (countForBirthdayEmails < birthdayMessage.getBirthdayEmailList().size()) {
			countForBirthdayEmails += 1;
		}

		if (countForBirthdayEmails < birthdayMessage.getBirthdayEmailList().size()&& !birthdayMessage.getBirthdayEmailList().isEmpty() && !birthdayMessage.getBirthdayMessage().isEmpty()) {
			String birthdayEmail = birthdayMessage.getBirthdayEmailList().get(countForBirthdayEmails);
			birthdayEmailField.setText(birthdayEmail);
			String birthDayMessageString = birthdayMessage.getBirthdayMessage().get(countForBirthdayEmails);
			birthdayMessageArea.setText(birthDayMessageString);
		} else {
			countForBirthdayEmails -= 1;
			return;
		}
	}
	
	//Text Area wird auf den Ursprung zurückgesetzt
	public void reset(ActionEvent event) {
		emailErrorField.setText("");
		birthdayMessage = new BirthdayMessage();
		birthdayMessageArea.setText(birthdayMessage.getBirthdayMessage().get(countForBirthdayEmails));
		birthdayMessage.getBirthdayMessage().set(countForBirthdayEmails, birthdayMessage.getBirthdayMessage().get(countForBirthdayEmails));
		
	}
	
	
	//Email senden
	public void sendEmail(ActionEvent event) {
		ArrayList<String> mailErrorMessage = new ArrayList<>();
		boolean mailSendingChecker = true;
		
		if (birthdayEmailField.getText().equals("")) {
			emailErrorField.setText("Es kann keine E-Mail verschickt werden!");
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
				SendingEmail sendingEmail = new SendingEmail();
				emailErrorField.setStyle("-fx-text-fill: green;");
				emailErrorField.setFont(new Font("Arial", 24));
				emailErrorField.setText("Die E-Mail wird zum Versenden vorbereitet!");
				sendingEmail.sendmail(birthdayEmailField.getText(), regardingField.getText(), birthdayMessageArea.getText());
				emailErrorField.setText(sendingEmail.getMessageSendingText());
			} else {
				String messageForSendingProcessField = "";
				for (String error : mailErrorMessage) {
					messageForSendingProcessField += error + "\n";
				}
				emailErrorField.setFont(new Font("Arial", 16));
				emailErrorField.setText(messageForSendingProcessField);
			}
		}
	}

	
	//Sachen die immer so sein sollen!
	public void hasToBe() {
		errorArea.setStyle("-fx-text-fill: red;");
		errorArea.setEditable(false);
		errorArea.setFont(new Font(14));
		emailErrorField.setStyle("-fx-text-fill: red;");
		genderBox.getStylesheets().add(getClass().getResource("/stylesheets/popupForGenderbox.css").toExternalForm());
		birthdayPicker.getStylesheets().add(getClass().getResource("/stylesheets/popupForPicker.css").toExternalForm());
		meetingDayPicker.getStylesheets().add(getClass().getResource("/stylesheets/popupForPicker.css").toExternalForm());
	}
	
}
