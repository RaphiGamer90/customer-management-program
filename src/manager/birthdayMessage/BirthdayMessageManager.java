package manager.birthdayMessage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import controllers.Controller;
import manager.checking.CheckerManager;
import database.ConnectionToDatabase;


public class BirthdayMessageManager {
	
	Controller controller = new Controller();
	String salutation, content, adoption;
	private ArrayList<String> birthdayMessageList = new ArrayList<>();
	
	
	public BirthdayMessageManager() {
		setBirthdayMessages();
	
	}
	
	/* Generiert Geburtstagsbenachrichtigungen */
    public void setBirthdayMessages() {
    	  
    	LocalDateTime now = LocalDateTime.now();  
    	System.out.println(now);
    	
    	
    	
    }

    
	
}
