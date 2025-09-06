package app.application.usecases;

import app.domain.model.Patient;
import app.domain.model.User;
import app.domain.model.Invoice;
import app.domain.services.CreatePatient;
import app.domain.services.CreateInvoice;
import app.domain.services.CreateEmergencyContact;
import app.domain.services.CreateInsurance;

public class AdminUseCase {

    private CreatePatient createPatient;
    private CreateInvoice createInvoice;
    private CreateEmergencyContact createEmergencyContact;
    private CreateInsurance createInsurance;

    public AdminUseCase(CreatePatient createPatient, CreateInvoice createInvoice,
                        CreateEmergencyContact createEmergencyContact, CreateInsurance createInsurance) {
        this.createPatient = createPatient;
        this.createInvoice = createInvoice;
        this.createEmergencyContact = createEmergencyContact;
        this.createInsurance = createInsurance;
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

    public void registerInsurance(String patientId, String company, String policyNumber, String validity) {
        createInsurance.registerInsurance(patientId, company, policyNumber, validity);
    }
}
