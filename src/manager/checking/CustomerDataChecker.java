package manager.checking;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerDataChecker {

	Checker checker = new Checker();
	
	/*VORNAME*/
	public boolean isFirstName(String firstName) {
		if(!checker.isString(firstName) && !checker.isFirstLetterUpperCase(firstName)) {
			System.out.println("Das ist KEIN Vorname");
			return false;
		}
		System.out.println("Das ist EIN Vorname");
		return true;
	}
	
	/*NACHNAME*/
	public boolean isLastName(String lastName) {
		if(!(checker.isString(lastName) & checker.isFirstLetterUpperCase(lastName))) {
			return false;
		}
		return true;
	}
	
	/*GEBURTSTAG*/
	public boolean isBirthday(String birthday) {
		if(!(checker.isValidDate(birthday))) {
			return false;
		}
		return true;
	}
	
	/*EMAIL*/
	public boolean isEmail(String email) {
		if(!(checker.isValidEmailAddress(email))) {
			return false;
		}
		return true;
	}
	
	/*TELNR*/
	public boolean isTelNr(String telNr) {
	    String patterns 
	      = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$" 
	      + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$" 
	      + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";

	    Pattern pattern = Pattern.compile(patterns);
	    Matcher matcher = pattern.matcher(telNr);
	    return matcher.matches();
	}
	
	/*DEGREE*/
	public boolean isDegree(String degree) {
		if(!(checker.isString(degree))) {
			return false;
		}
		return true;
	}
	
	/*MEETING DAY*/
	public boolean isMeetingDay(String meetingDay) {
		if(!(checker.isValidEmailAddress(meetingDay))) {
			return false;
		}
		return true;
	}
	
	/*GENDER*/
	public boolean isGender(String gender) {
		if(!gender.equals("Herr") && !gender.equals("Frau") && !gender.equals("Divers") && !gender.equals("Unknown")) {
			return false;
		}
		return true;
	}
}
