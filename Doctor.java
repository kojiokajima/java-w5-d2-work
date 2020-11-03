package ca.health;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
public class Doctor {

	private int doctorId;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	private String specialty;
	private ArrayList<Appointment> appointments;
	
	
	//constructor
	public Doctor(String firstName, String lastName, String phoneNumber, String email, String specialty) {
		setDoctorId();
		setFirstName(firstName);
		setLastName(lastName);
		setPhoneNumber(phoneNumber);
		setEmail(email);
		setSpecialty(specialty);
		this.appointments = new ArrayList<Appointment>();
	}
	
		
	public void addAppointment(Appointment a) {
		this.appointments.add(a);
	}
	
	
	//getters
	public int getDoctorId() {
		return doctorId;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getEmail() {
		return email;
	}
	public String getSpecialty() {
		return specialty;
	}
	public ArrayList<Appointment> getApointments() {
		return appointments;
	}
	
	
	//setters
	public void setDoctorId() {
		int randomtNumber = (int)((Math.random() * 99001) + 1000);
		this.doctorId = randomtNumber;
	}
	public void setFirstName(String firstName) {
		if (!firstName.isEmpty() && !firstName.equalsIgnoreCase(null)) {
			this.firstName = firstName;
		} else {
			this.firstName = "Unknown";
		}
	}
	public void setLastName(String lastName) {
		if (!lastName.isEmpty() && !lastName.equalsIgnoreCase(null)) {
			this.lastName = lastName;
		} else {
			this.lastName = "Unknown";
		}
	}
	public void setPhoneNumber(String phoneNumber) {
		if (!phoneNumber.isEmpty() && !phoneNumber.equalsIgnoreCase(null)) {
			this.phoneNumber = phoneNumber;
		} else {
			this.phoneNumber = "Unknown";
		}
	}
	public void setEmail(String email) {
		if (!email.isEmpty() && !email.equalsIgnoreCase(null)) {
			this.email = email;
		} else {
			this.email = "Unknown";
		}
	}
	public void setSpecialty(String specialty) {
		if (!specialty.isEmpty() && !specialty.equalsIgnoreCase(null)) {
			this.specialty = specialty;
		} else {
			this.specialty = "Unknown";
		}
	}
	
	
	@Override
	public String toString() {
		return "Doctor ID: " + doctorId +
				"\nName: " + firstName + " " + lastName +
				"\nPhone#: " + phoneNumber +
				"\nEmail: " + email +
				"\nSpecialty: " + specialty + "\n";
	}
	
	
}
