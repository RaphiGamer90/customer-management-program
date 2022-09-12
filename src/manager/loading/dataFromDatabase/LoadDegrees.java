package manager.loading.dataFromDatabase;

import database.DataFromDatabase;

public interface LoadDegrees {

	default public void loaddegrees(DataFromDatabase degrees) {
		degrees.degreesFromDatabase();
	}
}
