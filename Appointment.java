package ca.health;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;

public class Appointment {

	private Patient patients;
	private LocalDateTime appointmentDateTime;
	
	public Appointment(Patient pat, LocalDateTime appointmentDate) {
		setPatients(pat);
		setAppointmentDate(appointmentDate);
	}
	
	public Patient getPatients() {
		return patients;
	}
	
	public void setPatients(Patient pat) {
		this.patients = pat;
	}
	
	public LocalDateTime getAppointmentDateTime() {
		return appointmentDateTime;
	}
	
	public void setAppointmentDate(LocalDateTime appointmentDate) {
		this.appointmentDateTime = appointmentDate;
	}
		
	public String toString() {
		return "Your appointment is on " +
		appointmentDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
	}
}
