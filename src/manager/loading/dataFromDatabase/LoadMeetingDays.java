package manager.loading.dataFromDatabase;

import database.ValuesFromDatabase;

public class LoadMeetingDays {

	public LoadMeetingDays(ValuesFromDatabase meetingDays) {
		meetingDays.getMeetingDaysFromDatabase();
	}
}
