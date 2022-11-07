package manager.datePicker;


import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class DatePickerManager {

	
	private String birthdayDatePickerValue, meetingDayDatePickerValue;
	
	
	/*
	 * Listener for textProperty Change from Datepickers
	 * 
	 * */
	public void addBirthdayDatepickerListener(DatePicker birthdayDatePicker) {
		birthdayDatePicker.getEditor().textProperty().addListener((observable, oldValue, newValue) -> {
			birthdayDatePickerValue = newValue;
		});
	}
	
	public void addMeetingDayDatePickerListener(DatePicker meetingDayDatePicker) {
		meetingDayDatePicker.getEditor().textProperty().addListener((observable, oldValue, newValue) -> {
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
