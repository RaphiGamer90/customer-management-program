package manager.loading.dataFromDatabase;

import database.DataFromDatabase;

public interface LoadGenders {
 
	default public void loadgenders(DataFromDatabase genders) {
		genders.genderFromDatabase();
	}
}
