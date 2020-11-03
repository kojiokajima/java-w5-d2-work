package ca.health;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class Patient {
	private int patientID;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	private LocalDate dateOfBirth;
	private String gender;
	
	private final String DEFAULT_UNKNOWN = "Unknown";

	public Patient(String firstName, String lastName, String phoneNumber, String email,
			LocalDate dateOfBirth, String gender) {
		setPatientID();
		setFirstName(firstName);
		setLastName(lastName);
		setPhoneNumber(phoneNumber);
		setEmail(email);
		setDateOfBirth(dateOfBirth);
		setGender(gender);
	}


	public int getPatientID() {
		return patientID;
	}


	public void setPatientID() {
		int randomNum = (int)(Math.random() * 10000 * 1000 + 1) + 1000;
		this.patientID = randomNum;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		if (!firstName.isEmpty() && !firstName.equalsIgnoreCase(null)) {
			this.firstName = firstName;
		} else {
			this.firstName = DEFAULT_UNKNOWN;
		}
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		if (!lastName.isEmpty() && !lastName.equalsIgnoreCase(null)) {
			this.lastName = lastName;
		} else {
			this.lastName = DEFAULT_UNKNOWN;
		}
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		String pattern = "^\\d{3}-\\d{3}-\\d{4}$";
		Pattern p = Pattern.compile(pattern);
		
		if (!phoneNumber.isEmpty() && !phoneNumber.equalsIgnoreCase(null)) {
			
			if (p.matcher(phoneNumber).find()) {
				this.phoneNumber = phoneNumber;
			} else {
				this.phoneNumber = "Invalid phone number";
			}
			
		} else {
			this.phoneNumber = DEFAULT_UNKNOWN;
		}
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
	    String pattern = "^([a-zA-Z0-9])+([a-zA-Z0-9\\._-])*@([a-zA-Z0-9_-])+([a-zA-Z0-9\\._-]+)+$";
	    Pattern p = Pattern.compile(pattern);
	    
	    if (!email.isEmpty() && !email.equalsIgnoreCase(null)) {
	    	
	    	if (p.matcher(email).find()) {
	    		this.email = email;
	    	} else {
	    		this.email = "Invalid email";
	    	}
	    	
	    } else {
	    	this.email = DEFAULT_UNKNOWN;
	    }
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		if (!gender.isEmpty() && !gender.equalsIgnoreCase(null)) {
			
			if (gender.equalsIgnoreCase("m")) {
				this.gender = "Male";
			} else if (gender.equalsIgnoreCase("f")){
				this.gender = "Female";
			}
			
		} else {
			this.gender = DEFAULT_UNKNOWN;
		}
	}
	
	public String toString() {
		return "Patient ID : " + patientID + "\n" +
	           "Phone Number : " + phoneNumber + "\n" +
			   "Email : " + email + "\n" +
	           "Date of Birth : " + dateOfBirth + "\n" +
			   "Gender : " + gender  + "\n";
	}
	
}
