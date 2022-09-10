package manager.loading.dataFromDatabase;

import java.util.ArrayList;

import database.ValuesFromDatabase;

public interface LoadEmails {
	
	default public void loademails(ValuesFromDatabase emails) {
		emails.emailFromDatabase();
	}
	
}
