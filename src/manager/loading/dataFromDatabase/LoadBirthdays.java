package manager.loading.dataFromDatabase;

import database.ValuesFromDatabase;

public interface LoadBirthdays {
	
	default public void loadbirthdays(ValuesFromDatabase birthdays) {
		birthdays.birthdayFromDatabase();
	}
}
