package manager.checking;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerDataChecker {

	/*VORNAME*/
	public boolean isFirstName(String firstName) {
		return true;
	}
	
	/*NACHNAME*/
	public boolean isLastName(String lastName) {
		return true;
	}
	
	/*GEBURTSTAG*/
	public boolean isBirthday(String birthday) {
		return true;
	}
	
	/*EMAIL*/
	public boolean isEmail(String email) {
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
		return true;
	}
	
	/*MEETING DAY*/
	public boolean isMeetingDay(String meetingDay) {
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
