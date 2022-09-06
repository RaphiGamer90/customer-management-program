package manager.checking;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class Checker {
	
	/*
	 * Es wird überprüft, ob input ein String ist
	 * 
	 * */
	public boolean isString(String input) {
		for(char i : input.toCharArray()) {
			if(Character.isDigit(i)) {
				System.out.println("Das ist KEIN String" + " " + i);
				return false;
			}
		}
		System.out.println("Das ist EIN String");
		return true;
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
	 * Überprüft, ob input eine Valide Email Adresse ist
	 * 
	 * */
	public boolean isValidEmailAddress(String email) {
		boolean result = true;
		try {
			InternetAddress emailAddr = new InternetAddress(email);
			emailAddr.validate();
		} catch (AddressException ex) {
			result = false;
		}
		return result;
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
	public boolean isValidDate(String date) 
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
