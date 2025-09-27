package app.application.usecases;

import app.domain.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.Invoice;
import app.domain.services.CreatePatient;
import app.domain.services.CreateInvoice;
import app.domain.services.CreateEmergencyContact;
import app.domain.services.CreateInsurance;

@Service
public class AdminUseCase {

	@Autowired
    private CreatePatient createPatient;
	@Autowired
    private CreateInvoice createInvoice;
	@Autowired
    private CreateEmergencyContact createEmergencyContact;
	@Autowired
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

    public void registerInsurance(String patientId, String insuranceCompany, String policyNumber, String validity, String policyEndDate) {
        createInsurance.registerInsurance(patientId, insuranceCompany, policyNumber, validity, policyEndDate);
    }
}
