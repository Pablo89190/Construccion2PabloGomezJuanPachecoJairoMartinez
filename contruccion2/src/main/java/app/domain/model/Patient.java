package app.domain.model;
import app.domain.model.emuns.Gender;

public class Patient extends Person {
    private Gender gender;                
    private EmergencyContact emergencyContact; 
    private Insurance insurance;
    
    public Patient () {}
    
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public EmergencyContact getEmergencyContact() {
		return emergencyContact;
	}
	public void setEmergencyContact(EmergencyContact emergencyContact) {
		this.emergencyContact = emergencyContact;
	}
	public Insurance getInsurance() {
		return insurance;
	}
	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}           
    
    

}

