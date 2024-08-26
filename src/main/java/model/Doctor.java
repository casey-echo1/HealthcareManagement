package model;

public class Doctor {
	private int doctorID;
	private String firstName, lastName, specialty, email;

	//constructors
	public Doctor(){};

	public Doctor(int doctorID, String firstName, String lastName, String specialty, String email) {
		this.doctorID = doctorID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.specialty = specialty;
		this.email = email;
	}

	//getters and setters
	public int getDoctorID() {
		return doctorID;
	}
	public void setDoctorID(int doctorID) {
		this.doctorID = doctorID;
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
	public String getSpecialty() {
		return specialty;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
