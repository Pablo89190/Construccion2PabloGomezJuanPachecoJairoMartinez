package app.domain.services;

import app.domain.model.EmergencyContact;
import app.domain.model.Insurance;
import app.domain.model.Patient;
import app.domain.model.User;
import app.domain.ports.EmergencyContactPort;
import app.domain.ports.InsurancePort;
import app.domain.ports.PatientPort;

public class UpdatePatient {

    private PatientPort patientPort;
    private EmergencyContactPort emergencyContactPort;
    private InsurancePort insurancePort;

    public UpdatePatient(PatientPort patientPort, EmergencyContactPort emergencyContactPort, InsurancePort insurancePort) {
        this.patientPort = patientPort;
        this.emergencyContactPort = emergencyContactPort;
        this.insurancePort = insurancePort;
    }

    public void updatePatientData(User patient) throws Exception {
        if (patient == null) {
            throw new Exception("El paciente no puede ser nulo");
        }


        Patient existingPatient = patientPort.findById(patient.getId());
        if (existingPatient == null) {
            throw new Exception("No existe un paciente con este ID");
        }

        patientPort.save(patient);
    }

    public void updateEmergencyContact(String patientId, String firstName, String lastName, String relationship, String phone) throws Exception {

        Patient patient = patientPort.findById(patientId);
        if (patient == null) {
            throw new Exception("No existe un paciente con este ID");
        }

        EmergencyContact updatedContact = new EmergencyContact();
        updatedContact.setFirstName(firstName);
        updatedContact.setLastName(lastName);
        updatedContact.setRelationship(relationship);
        updatedContact.setPhone(phone);

        emergencyContactPort.updateEmergencyContact(patientId, updatedContact);
    }

    public void updateInsurance(String patientId, String insuranceCompany, String policyNumber, String validity, String policyEndDate) throws Exception {

        Patient patient = patientPort.findById(patientId);
        if (patient == null) {
            throw new Exception("No existe un paciente con este ID");
        }

        Insurance updatedInsurance = new Insurance();
        updatedInsurance.setCompany(insuranceCompany);
        updatedInsurance.setPolicyNumber(policyNumber);
        updatedInsurance.setValidity(validity);
        updatedInsurance.setPolicyEndDate(policyEndDate);

        insurancePort.updateInsurance(patientId, updatedInsurance);
    }
}