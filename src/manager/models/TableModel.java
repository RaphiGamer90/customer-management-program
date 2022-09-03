package manager.models;

public class TableModel {
	
	String firstName, lastName, birthday, email, telNr, degree, meetingDay, gender;
	
	public TableModel(String firstName, String lastName, String birthday, String email, String telNr, String degree, String meetingDay, String gender) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.email = email;
		this.telNr = telNr;
		this.degree = degree;
		this.meetingDay = meetingDay;
		this.gender = gender;
	}

	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelNr() {
		return telNr;
	}

	public void setTelNr(String telNr) {
		this.telNr = telNr;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getMeetingDay() {
		return meetingDay;
	}

	public void setMeeingDay(String meetingDay) {
		this.meetingDay = meetingDay;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
