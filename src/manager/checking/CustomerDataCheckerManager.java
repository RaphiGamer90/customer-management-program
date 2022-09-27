package manager.checking;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerDataCheckerManager extends CheckerManager {

	
	/*VORNAME*/
	public boolean isFirstName(String firstName) {
		if(!(isString(firstName) & isFirstLetterUpperCase(firstName))) {
			return false;
		}
		return true;
	}
	
	/*NACHNAME*/
	public boolean isLastName(String lastName) {
		if(!(isString(lastName) & isFirstLetterUpperCase(lastName))) {
			return false;
		}
		return true;
	}
	
	/*GEBURTSTAG*/
	public boolean isBirthday(String birthday) {
		if(!(isValidDatePattern(birthday))) {
			return false;
		}
		return true;
	}
	
	/*EMAIL*/
	public boolean isEmail(String email) {
		if(!(isValidEmailAddress(email))) {
			return false;
		}
		return true;
	}
	
	/*TELNR*/
	public boolean isTelNr(String telNr) {
	   if(!isValidTelNrPattern(telNr)) {
		   return false;
	   }
	   return true;
	}
	
	/*DEGREE*/
	public boolean isDegree(String degree) {
		if(!(isString(degree))) {
			return false;
		}
		return true;
	}
	
	/*MEETING DAY*/
	public boolean isMeetingDay(String meetingDay) {
		if(!(isValidEmailAddress(meetingDay))) {
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
