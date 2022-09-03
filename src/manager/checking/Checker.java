package manager.checking;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;

public class Checker {
	LocalDate today = LocalDate.now();
	String formattedDate = today.format(DateTimeFormatter.ofPattern("yyyy"));
	int yearToday = Integer.parseInt(formattedDate);
	
	/*
	 * Es wird überprüft, ob input ein String ist
	 * 
	 * */
	public boolean isString(String input) {

		try {
			int string = Integer.parseInt(input);

			return false;
		} catch (NumberFormatException e) {
			return true;
		}
	}

	/*
	 * Es wird überpüft, ob input eine Zahl ist
	 * 
	 * */
	public boolean isInteger(String input) {
		for(char i : input.toCharArray()) {
			if(!Character.isDigit(i)) {
				return false;
			}
		}
		return true;
	}
	
	/*
	 * Es wird überprüft, ob input ein Integer ist 
	 * (Kann auch nur Abschnitte von Wörtern überüfen)
	 * */
	public boolean isInteger(String s, int radix) {
	    if(s.isEmpty()) return false;
	    for(int i = 0; i < s.length(); i++) {
	        if(i == 0 && s.charAt(i) == '-') {
	            if(s.length() == 1) return false;
	            else continue;
	        }
	        if(Character.digit(s.charAt(i),radix) < 0) return false;
	    }
	    return true;
	}

	
	/*
	 * Überprüft, ob input ein Datum ist (Mit Jahr)
	 * 
	 * */
	public boolean isDateWithYear(String input) {
		int days = 0;
		int months = 0;
		int year = 0;
		String dot1;
		String dot2;
		
		try {
			days = Integer.parseInt(input.substring(0, 2));
			months = Integer.parseInt(input.substring(3, 5));
			year = Integer.parseInt(input.substring(6, 10));
			dot1 = input.substring(2, 3);
			dot2 = input.substring(5, 6);

		} catch (NumberFormatException | StringIndexOutOfBoundsException e) { return false; }	
		
		if(!(days <= 31 || days >= 1) && !(months <= 12 || months >= 1) && !(year <= Calendar.getInstance().get(Calendar.YEAR)) && !dot1.equals(".") && !dot2.equals(".") && !(input.length() == 10)) {
			return false;
		}
		return true;
	}
	
	
	/*
	 * Überprüft, ob input ein Datum ist (Ohne Jahr)
	 * 
	 * */
	public boolean isDateWithoutYear(String input) {
		int days = 0;
		int months = 0;
		String dot1;
		String dot2;
		
		try {
			days = Integer.parseInt(input.substring(0, 2));
			months = Integer.parseInt(input.substring(3, 5));
			dot1 = input.substring(2, 3);
			dot2 = input.substring(5, 6);
		} catch (NumberFormatException | StringIndexOutOfBoundsException e) { return false; }	
		
		if(!(days <= 31 || days >= 1) && !(months <= 12 || months >= 1) && !dot1.equals(".") && !dot2.equals(".") && !(input.length() == 6)) {
			return false;
		}
		return true;
	}

	
	
	
	/*
	 * Überprüft, ob input eine Valide Email Adresse ist
	 * 
	 * */
	public boolean isValidEmail(String email) {
		boolean ret = true;

		if (email == null || email.trim().length() == 0) {
			ret = false;
		} else {
			int index = email.indexOf("@");
			if (index == -1) {
				ret = false;
			}
		}
		return ret;
	}

	
	
	
	/*
	 * Es wird überprüft, ob der erste Buchsabe in einem Namen groß geschrieben wird.
	 * 
	 * */
	public boolean isFirstLetterUpperCase(String name) {
		if (!(Character.isUpperCase(name.charAt(0)))) {
			return false;
		}
		return true;
	}
	
	
	
	/*
	 * Überprüft, ob input das Format eines Datums hat
	 * 
	 * */
	public boolean isValidDateFormat(String date) 
	{
		String DATE_FORMAT = "dd.MM.yyyy";
	        try {
	            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
	            df.setLenient(false);
	            df.parse(date);
	            return true;
	        } catch (ParseException e) {
	            return false;
	        }
	}
	
	
}
