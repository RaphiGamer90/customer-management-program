package manager.loading.dataFromDatabase;

import database.ValuesFromDatabase;

public interface LoadGenders {
 
	default public void loadgenders(ValuesFromDatabase genders) {
		genders.genderFromDatabase();
	}
}
