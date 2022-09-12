package manager.loading.dataFromDatabase;

import database.DataFromDatabase;

public interface LoadBirthdays {
	
	default public void loadbirthdays(DataFromDatabase birthdays) {
		birthdays.birthdayFromDatabase();
	}
}
