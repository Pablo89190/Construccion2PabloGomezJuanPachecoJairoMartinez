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
	public void setGender(String string) {
		this.gender = string;
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

	public void setPolicyNumber(int policyNumber) {
		// TODO Auto-generated method stub
		
	}

	public void setPolicyEndDate(String policyEndDate) {
		// TODO Auto-generated method stub
		
	}

	public void setEmergencyPhoneNumber(String emegercyPhoneNumber) {
		// TODO Auto-generated method stub
		
	}

	public void setRelationShip(String relationShipValidator) {
		// TODO Auto-generated method stub
		
	}

	public void setInsuranceCompany(Object insuranceCompany) {
		// TODO Auto-generated method stub
		
	}           
    
    

}

