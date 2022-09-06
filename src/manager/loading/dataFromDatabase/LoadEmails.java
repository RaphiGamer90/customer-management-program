package manager.loading.dataFromDatabase;

import java.util.ArrayList;

import database.ValuesFromDatabase;

public class LoadEmails {
 
	ValuesFromDatabase emails = new ValuesFromDatabase();
	
	public LoadEmails() {
		emails.emailFromDatabase();
	}
	
	public ArrayList<String> getLoadedEmails() {
		return emails.getEmailsFromDatabase();
	}
	
}
