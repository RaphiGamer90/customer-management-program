package manager.loading.dataFromDatabase;

import database.DataFromDatabase;

public interface LoadEmails {
	
	default public void loademails(DataFromDatabase emails) {
		emails.emailFromDatabase();
	}
	
}
