package ca.health;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {	
	public static void printInstruction(ArrayList<Patient> pat, ArrayList<Doctor> doc) {
		Scanner input = new Scanner(System.in);
		
		String userInput = "zzz";
		
		while(!userInput.equalsIgnoreCase("p") && !userInput.equalsIgnoreCase("d")) {
			System.out.print("Enter P for patient or D for doctor: ");
			userInput = input.nextLine();
		}
		if (userInput.equalsIgnoreCase("p")) {
			for (Patient  patient : pat) {
				System.out.println(patient.toString());
			}
			patientOperation(pat, doc);
		} else if (userInput.equalsIgnoreCase("d")) {
			doctorOperation();
		}
	}
	
	public static void patientOperation(ArrayList<Patient> pat, ArrayList<Doctor> doc) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a patient ID: ");
		int userInputPatientId = input.nextInt();
		Patient returnedPatient = checkPatientId(pat, userInputPatientId);
		
		while(returnedPatient == null) {
			System.err.println("\nWe don'n have a patient with this ID.\n");
			System.out.print("Enter a patient ID again: ");
			userInputPatientId = input.nextInt();
			returnedPatient = checkPatientId(pat, userInputPatientId);
		}
		
		
		for (Doctor doctor : doc) {
			System.out.println(doctor.toString());
		}
		System.out.print("Enter a doctor ID: ");
		int userInputDoctorId = input.nextInt();
		Doctor returnedDoctor = checkDoctorId(doc, userInputDoctorId);
		
		while(returnedDoctor == null) {
			System.err.println("We don'n have a doctor with this ID.\n");
			System.out.print("Enter a doctor ID again: ");
			userInputDoctorId = input.nextInt();
			returnedDoctor = checkDoctorId(doc, userInputDoctorId);
		}
		
		System.out.print("\nEnter year: ");
		int userInputYear = input.nextInt();
		System.out.print("Enter month: ");
		int userInputMonth = input.nextInt();
		System.out.print("Enter day: ");
		int userInputDay = input.nextInt();
		System.out.print("Enter hour: ");
		int userInputHour = input.nextInt();
		System.out.print("Enter minute: ");
		int userInputMinute = input.nextInt();
		LocalDate appoDate = LocalDate.of(userInputYear, userInputMonth, userInputDay);
		LocalTime appoTime = LocalTime.of(userInputHour, userInputMinute);
		LocalDateTime appoDateTime = LocalDateTime.of(appoDate, appoTime);
		
		Appointment appointment = new Appointment(returnedPatient, appoDateTime);
		returnedDoctor.addAppointment(appointment);
		System.out.println(appointment.toString() + " with " +
							returnedDoctor.getFirstName() + " " + returnedDoctor.getLastName());
		
		
		
	}
	
	
	public static Patient checkPatientId(ArrayList<Patient> patient, int patientId) {
		for (Patient pat : patient) {
			if (pat.getPatientID() == patientId) {
				return pat;
			}
		}
		return null;
	}

	
	public static void doctorOperation() {
		
	}
	
	public static Doctor checkDoctorId(ArrayList<Doctor> doctor, int doctorId) {
		for (Doctor doc : doctor) {
			if (doc.getDoctorId() == doctorId) {
				return doc;
			}
		}
		return null;
	}
	
	

	public static void main(String[] args) {
        ArrayList<Patient> patients = new ArrayList<Patient>();
        ArrayList<Doctor> doctors = new ArrayList<Doctor>();
		
		Patient p1 = new Patient("Marwan", "Pace", "111-123-4567", "marwan@gmail.com", LocalDate.of(1981, 1, 2), "m");
		Patient p2 = new Patient("Farrah", "Hook", "222-123-4567", "farrah@yahoo.ca", LocalDate.of(1985, 3, 21), "f");
		Patient p3 = new Patient("Clare", "Levine", "333-123-4567", "clairelevine@gmail.com", LocalDate.of(1990, 10, 2), "f");
		Patient p4 = new Patient("Rares", "Daniels", "444-123-4567", "danielsrares@yahoo.ca", LocalDate.of(1991, 3, 1), "f");
		Patient p5 = new Patient("Youssef", "Tapia", "555-123-4567", "tapis@outlook.com", LocalDate.of(1983, 11, 12), "m");
		Patient p6 = new Patient("Odin", "Mcculloch", "666-123-4567", "odin@yahoo.ca", LocalDate.of(1999, 5, 21), "f");
		Patient p7 = new Patient("Tabatha", "Cousins", "777-123-4567", "tabatha@outlook.com", LocalDate.of(1994, 7, 24), "m");
		Patient p8 = new Patient("Hamid", "Gilmore", "888-123-4567", "hamid@yahoo.ca", LocalDate.of(1997, 8, 31), "f");
		Patient p9 = new Patient("Emmie", "Edwards", "999-123-4567", "emmie@gmail.com", LocalDate.of(1997, 12, 5), "m");
		Patient p10 = new Patient("Tylor", "Johnston", "111-111-4567", "tylorjohnston@yahoo.ca", LocalDate.of(1999, 6, 11), "f");
		Doctor d1 = new Doctor("Martin", "Garrix", "122-441-4257", "marting@gmail.com", "Family Doctor");
		Doctor d2 = new Doctor("Mike", "Perry", "123-456-2456", "mikw@gmail.com", "Surgeon");
		Doctor d3 = new Doctor("Adam", "Young", "200-821-3228", "mike@gmail.com", "MASUI");
		Doctor d4 = new Doctor("Phillip", "Phillips", "987-235-9192", "phillip@gmail.com", "JUJU");
		
		patients.add(p1);
		patients.add(p2);
		patients.add(p3);
		patients.add(p4);
		patients.add(p5);
		patients.add(p6);
		patients.add(p7);
		patients.add(p8);
		patients.add(p9);
		patients.add(p10);
		doctors.add(d1);
		doctors.add(d2);
		doctors.add(d3);
		doctors.add(d4);
		
		printInstruction(patients, doctors);
	}

}
