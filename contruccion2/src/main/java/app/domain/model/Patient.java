package app.domain.model;

import app.domain.model.emuns.Gender;

public class Patient extends Person {
    private Gender gender;                
    private EmergencyContact emergencyContact; 
    private Insurance insurance;
    
    public Patient() {}
    
    public Gender getGender() {
        return gender;
    }
    
    public void setGender(String stringValue, Gender gender) {
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
    
    public void setInsurance() {
        if (this.insurance == null) {
            this.insurance = new Insurance();
        }
    }

    public void setPolicyNumber(int policyNumber) {
        if (this.insurance == null) {
            this.insurance = new Insurance();
        }
        this.insurance.setPolicyNumber(String.valueOf(policyNumber));
    }

    public void setPolicyEndDate(String policyEndDate) {
        if (this.insurance == null) {
            this.insurance = new Insurance();
        }
        this.insurance.setPolicyEndDate(policyEndDate);
    }

    public void setEmergencyPhoneNumber(String emergencyPhoneNumber) {
        if (this.emergencyContact == null) {
            this.emergencyContact = new EmergencyContact();
        }
        this.emergencyContact.setPhone(emergencyPhoneNumber);
    }

    public void setRelationShip(String relationShip) {
        if (this.emergencyContact == null) {
            this.emergencyContact = new EmergencyContact();
        }
        this.emergencyContact.setRelationship(relationShip);
    }

    public void setInsuranceCompany(String insuranceCompany) {
        if (this.insurance == null) {
            this.insurance = new Insurance();
        }
        this.insurance.setCompany(insuranceCompany);
    }
}