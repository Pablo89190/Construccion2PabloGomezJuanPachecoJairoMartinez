

package app.application.usecases;

import app.domain.model.Patient;
import app.domain.model.Invoice;
import app.domain.services.CreatePatient;
import app.domain.services.CreateInvoice;

public class AdminUseCase {

    private CreatePatient createPatient;
    private CreateInvoice createInvoice;

    public AdminUseCase(CreatePatient createPatient, CreateInvoice createInvoice) {
        this.createPatient = createPatient;
        this.createInvoice = createInvoice;
    }

    public void createPatient(Patient patient) throws Exception {
        createPatient.createPerson(patient);
    }

    public void createInvoice(Invoice invoice) throws Exception {
        createInvoice.create(invoice);
    }
}
