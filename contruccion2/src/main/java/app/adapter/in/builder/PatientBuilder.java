package app.adapter.in.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapter.in.validators.PatientValidator;
import app.domain.model.EmergencyContact;
import app.domain.model.Patient;
import app.domain.model.emuns.Gender;

@Component
public class PatientBuilder {

    @Autowired
    private PatientValidator patientValidator;

    public Patient build(String document, String gender, String fullName, String address, String phoneNumber,
                        String email, String age, String emergencyContactName,
                        String relationShip, String emergencyPhoneNumber,
                        String insuranceCompany, String policyNumber,
                        String policyStatus, String policyEndDate) throws Exception {

        Patient patient = new Patient();

      
        long validatedDocument = patientValidator.idValidator(document);
        patient.setId(validatedDocument);
        
        // Datos básicos
        String validatedGender = patientValidator.genderValidator(gender);
        patient.setGender(validatedGender, Gender.valueOf(validatedGender));
        patient.setFullName(patientValidator.fullNameValidator(fullName));
        patient.setAddress(patientValidator.addressValidator(address));
        patient.setPhone(patientValidator.phoneValidator(phoneNumber));
        patient.setAge(patientValidator.ageValidator(age));
        patient.setEmail(patientValidator.emailValidator(email));

    
        EmergencyContact contact = new EmergencyContact();
        contact.setFirstName(patientValidator.firstNameValidator(emergencyContactName));
        contact.setRelationship(patientValidator.relationShipValidator(relationShip));
        contact.setPhone(patientValidator.emegercyPhoneNumber(emergencyPhoneNumber));
        patient.setEmergencyContact(contact);

   
        patient.setInsuranceCompany(patientValidator.insuranceCompany(insuranceCompany));
        patient.setPolicyNumber(patientValidator.policyNumber(policyNumber));
        patient.setPolicyEndDate(patientValidator.policyEndDate(policyEndDate));

        return patient;
    }
}