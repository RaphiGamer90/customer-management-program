package manager.loading.dataFromDatabase;

import database.ValuesFromDatabase;

public interface LoadMeetingDays {

	default public void loadmeetingdays(ValuesFromDatabase meetingDays) {
		meetingDays.meetingDaysFromDatabase();
	}
}
