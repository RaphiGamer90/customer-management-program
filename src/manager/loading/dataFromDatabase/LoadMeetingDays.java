package manager.loading.dataFromDatabase;

import database.DataFromDatabase;

public interface LoadMeetingDays {

	default public void loadmeetingdays(DataFromDatabase meetingDays) {
		meetingDays.meetingDaysFromDatabase();
	}
}
