package manager.loading.dataFromDatabase;

import database.ValuesFromDatabase;

public interface LoadDegrees {

	default public void loaddegrees(ValuesFromDatabase degrees) {
		degrees.degreesFromDatabase();
	}
}
