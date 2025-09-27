package app.application.usecases;

import app.domain.model.User;
import app.domain.model.Invoice;
import app.domain.services.CreatePatient;
import app.domain.services.CreateInvoice;
import app.domain.services.CreateEmergencyContact;
import app.domain.services.CreateInsurance;
import app.domain.services.UpdatePatient;

public class AdminUseCase {

    private CreatePatient createPatient;
    private CreateInvoice createInvoice;
    private CreateEmergencyContact createEmergencyContact;
    private CreateInsurance createInsurance;
    private UpdatePatient updatePatient;

    public AdminUseCase(CreatePatient createPatient, CreateInvoice createInvoice,
                        CreateEmergencyContact createEmergencyContact, CreateInsurance createInsurance,
                        UpdatePatient updatePatient) {
        this.createPatient = createPatient;
        this.createInvoice = createInvoice;
        this.createEmergencyContact = createEmergencyContact;
        this.createInsurance = createInsurance;
        this.updatePatient = updatePatient;
    }

    public void createPatient(User patient) throws Exception {
        createPatient.createPerson(patient);
    }

    public void createInvoice(Invoice invoice) throws Exception {
        createInvoice.create(invoice);
    }

    public void registerEmergencyContact(String patientId, String firstName, String lastName, String relationship, String phone) {
        createEmergencyContact.registerEmergencyContact(patientId, firstName, lastName, relationship, phone);
    }

    public void registerInsurance(String patientId, String insuranceCompany, String policyNumber, String validity, String policyEndDate) {
        createInsurance.registerInsurance(patientId, insuranceCompany, policyNumber, validity, policyEndDate);
    }

    public void updatePatientData(User patient) throws Exception {
        updatePatient.updatePatientData(patient);
    }

    public void updateEmergencyContact(String patientId, String firstName, String lastName, String relationship, String phone) throws Exception {
        updatePatient.updateEmergencyContact(patientId, firstName, lastName, relationship, phone);
    }

    public void updateInsurance(String patientId, String insuranceCompany, String policyNumber, String validity, String policyEndDate) throws Exception {
        updatePatient.updateInsurance(patientId, insuranceCompany, policyNumber, validity, policyEndDate);
    }
}