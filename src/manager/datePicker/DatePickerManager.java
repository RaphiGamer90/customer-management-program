package manager.datePicker;


import controllers.Controller;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class DatePickerManager {

	Controller controller = new Controller();
	
	private String birthdayDatePickerValue, meetingDayDatePickerValue;
	
	public DatePickerManager() {
		addBirthdayDatepickerListener();
		addMeetingDayDatePickerListener();
	}
	
	
	/*
	 * Listener for textProperty Change from Datepickers
	 * 
	 * */
	public void addBirthdayDatepickerListener() {
		controller.getMainController().birthdayPicker.getEditor().textProperty().addListener((observable, oldValue, newValue) -> {
			birthdayDatePickerValue = newValue;
		});
	}
	
	public void addMeetingDayDatePickerListener() {
		controller.getMainController().meetingDayPicker.getEditor().textProperty().addListener((observable, oldValue, newValue) -> {
			meetingDayDatePickerValue = newValue;
		});
	}
	
	public String getBirthdayDatePickerValue() {
		return birthdayDatePickerValue;
	}

	public String getMeetingDayDatePickerValue() {
		return meetingDayDatePickerValue;
	}
	
	
}
