package app.adapter.in.builder;

import app.adapter.in.validators.PatientValidator;
import app.domain.model.Patient;
import app.domain.model.User;

public class PatientBuilder {

private PatientValidator patientValidator;
	
	
	public Patient build(String gender, String fullName, String address, String phoneNumber, String email, String firstName, String relationShip, String emergencyPhoneNumber, String insuranceCompany, String policyNumber, String policyStatus, String policyEndDate, String age ) throws Exception {
		Patient patient = new Patient();
		patient.setGender(patientValidator.genderValidator(gender), null);
		
		patient.setAddress(patientValidator.addressValidator(address));
		
		patient.setAge(patientValidator.ageValidator(age));
		
		patient.setEmail(patientValidator.emailValidator(email));
		
		patient.setFullName(patientValidator.fullNameValidator(fullName));
		
		patient.setRelationShip(patientValidator.relationShipValidator(relationShip));
		
	patient.setEmergencyPhoneNumber(patientValidator.emegercyPhoneNumber(emergencyPhoneNumber));
		
		patient.setInsuranceCompany(patientValidator.insuranceCompany(insuranceCompany));
		
	patient.setPolicyNumber(patientValidator.policyNumber(policyNumber));
		
	patient.setPolicyEndDate(patientValidator.policyEndDate(policyEndDate));
		
		return patient;
	}
	public User build(String gender, String address, String phoneNumber, String email, String firstName,
			String relationship, String emergencyPhoneNumber, String insuranceCompany, String policyNumber,
			boolean policyStatus, String policyEndDate) {
		// TODO Auto-generated method stub
		return null;
		
	}
}
