package controllers;

import java.net.URL;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import manager.errors.ErrorManager;

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
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import manager.birthdayMessage.BirthdayMessage;
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
	public TextArea errorArea;
	@FXML
	public TextField deleteField;
	
	@FXML
	public TextField birthdayEmailField;
	@FXML
	public TextArea birthdayMessageArea;
	@FXML 
	public TextField regardingField;
	@FXML
	public TextArea emailErrorField;
	
	
	
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
	

	//Manager 
	public LoadManager loadManager;
	public DataManager dataManager;
	public TableManager tableManager;
	public CellFactoryManager cellFactoryManager;
	public AboutDatabase aboutDatabase;	
	public PutInDatabase putInDatabase;
	public DatePickerManager datePickerManager;	
	public ErrorManager errorManager;
	public ThreadManager threadManager;
	public ComboboxManager comboboxManager;
	
	//Controllers 
	public AddCustomer addCustomer;
	public EditColumn editColumns;
	public NewCustomer newCustomer;
	public DeletingCustomer deleteCustomer;
 
	int countForBirthdayEmails;
	Thread birthdayThread;
//	BirthdayMessage birthdayMessage = new BirthdayMessage();
	
	

	
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
	
	//ALLES WAS BEIM START AUSGEFÜHRT WERDEN SOLL// 
	public void init() {
		searchFilter();
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

		
		addCustomer = new AddCustomer();
		editColumns = new EditColumn();
		newCustomer = new NewCustomer();
		deleteCustomer = new DeletingCustomer();
		
		
		
		//Weiß nicht ob man das braucht :d
		tableView.getSelectionModel().setCellSelectionEnabled(true);
		emailErrorField.setStyle("-fx-text-fill: red;");


		//MUSS NOCH UMVERLAGERT WERDEN
		searchOutputField.setText(tableView.getItems().size() + "");
		
		tableManager.refreshWholeTableView();
		init();
			
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
		newCustomer.setNewCustomer();
	}

	//Daten in die Datenbank eintragen und auf der Tabelle sichtbar machen
	public void sendDataToDatabase(ActionEvent event) {
		addCustomer.setCustomerInDatabase();
	}

	/*
	 * Hiermit können die Zellen unabhängig voneinader bearbeitet werden
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
	public void setDarkMode(ActionEvent event) {   
	
	}
	
	
	//Lightmode / Heller Modus
	public void setOnLightMode(ActionEvent event) {

	}

	//Reihe aus der Datenbank entfernen und die Tabelle updaten
	public void deleteRow(ActionEvent event) {
		deleteCustomer.deleteCustomer();
		
	}
	
	
	//Neue Seite öffnen / weiter zur E-Mail Seite
	public void tabNewPage(ActionEvent event) {
//		birthdayMessage = new BirthdayMessage();
//		setBirthdayAreaContent();
//		verwaltungstab.getTabPane().getSelectionModel().select(emailtab);
		
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
	
	//Es wird zur nächsten Email gesprungen, falls eine existieren sollte.
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
	
	//Text Area wird auf den Ursprung zurückgesetzt
	public void reset(ActionEvent event) {
		emailErrorField.setText("");
//		birthdayMessage = new BirthdayMessage();
//		birthdayMessageArea.setText(birthdayMessage.getBirthdayMessage().get(countForBirthdayEmails));
//		birthdayMessage.getBirthdayMessage().set(countForBirthdayEmails, birthdayMessage.getBirthdayMessage().get(countForBirthdayEmails));
		
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
//				SendingEmail sendingEmail = new SendingEmail();
				emailErrorField.setStyle("-fx-text-fill: green;");
				emailErrorField.setFont(new Font("Arial", 24));
				emailErrorField.setText("Die E-Mail wird zum Versenden vorbereitet!");
//				sendingEmail.sendmail(birthdayEmailField.getText(), regardingField.getText(), birthdayMessageArea.getText());
//				emailErrorField.setText(sendingEmail.getMessageSendingText());
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


}
