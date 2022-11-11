package manager.checking;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class CheckerManager {

	/*
	 * Es wird überprüft, ob input ein String ist
	 * 
	 */
	public boolean isString(String input) {
		if (input == null || input.isEmpty()) {return false;}
		for (char i : input.toCharArray()) {
			if (Character.isDigit(i)) {
				return false;
			}
		}
		return true;
	}

	/*
	 * Es wird überpüft, ob input eine Zahl ist
	 * 
	 */
	public boolean isInteger(String input) {
		if (input == null || input.isEmpty()) {return false;}
		for (char i : input.toCharArray()) {
			if (!Character.isDigit(i)) {
				return false;
			}
		}
		return true;
	}

	/*
	 * Es wird überprüft, ob input ein Integer ist (Kann auch nur Abschnitte von
	 * Wörtern überüfen)
	 */
	public boolean isInteger(String input, int radix) {
		if (input == null || input.isEmpty()) {return false;}
		for (int i = 0; i < input.length(); i++) {
			if (i == 0 && input.charAt(i) == '-') {
				if (input.length() == 1)
					return false;
				else
					continue;
			}
			if (Character.digit(input.charAt(i), radix) < 0)
				return false;
		}
		return true;
	}

	/*
	 * Es wird überprüft, ob der erste Buchsabe in einem Namen groß geschrieben
	 * wird.
	 * 
	 */
	public boolean isFirstLetterUpperCase(String input) {
		if (input == null || input.isEmpty()) {return false;}
		if (!(Character.isUpperCase(input.charAt(0)))) {
			return false;
		}
		return true;
	}

	/*
	 * Überprüft, ob input das Format eines Datums hat
	 * 
	 */
	public boolean isValidDatePattern(String input) {
		String DATE_FORMAT = "dd.MM.yyyy";
		if (input == null || input.isEmpty()) {return false;}
		try {
			DateFormat df = new SimpleDateFormat(DATE_FORMAT);
			df.setLenient(false);
			df.parse(input);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}
	
	/*
	 * Überprüft, ob input das Muster einer Telefonnummer hat
	 * 
	 */
	public boolean isValidTelNrPattern(String input) {
		if (input == null || input.isEmpty()) {return false;}
	    String patterns 
	      = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$" 
	      + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$" 
	      + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";

	    Pattern pattern = Pattern.compile(patterns);
	    Matcher matcher = pattern.matcher(input);
	    return matcher.matches();
	}
	
	/*
	 * Überprüft, ob input eine Valide Email Adresse ist
	 * 
	 */
	public boolean isValidEmailAddress(String input) {
		if (input == null || input.isEmpty()) {return false;}
		try {
			InternetAddress emailAddr = new InternetAddress(input);
			emailAddr.validate();
		} catch (AddressException ex) {
			return false;
		}
		return true;
	}
	
	/*
	 * Überprüft, ob input eine Valides Geschlecht ist
	 * 
	 */
	public boolean isValidGender(String input) {
		if (input == null || input.isEmpty()) {return false;}
		if(!input.equals("Herr") && !input.equals("Frau") && !input.equals("Divers") && !input.equals("Unknown")) {
			return false;
		}
		return true;
	}
	
}
