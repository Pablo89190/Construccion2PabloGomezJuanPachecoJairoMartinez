package app.domain.services;

import app.domain.model.ClinicalOrder;
import app.domain.model.Invoice;
import app.domain.model.Patient;
import app.domain.ports.ClinicalOrderPort;
import app.domain.ports.InvoicePort;
import app.domain.ports.PatientPort;

public class CreateInvoice {
	
	private PatientPort patientPort;
	private ClinicalOrderPort clinicalOrderPort;
	private InvoicePort invoicePort;

	public CreateInvoice(PatientPort patientPort, ClinicalOrderPort clinicalOrderPort, InvoicePort invoicePort) {
		this.patientPort = patientPort;
		this.clinicalOrderPort = clinicalOrderPort;
		this.invoicePort = invoicePort;
	}
	
	public void create(Invoice invoice) throws Exception {
		Patient patient = patientPort.findById(invoice.getPatient().getId());
		if (patient == null) {
			throw new Exception("La factura debe tener un Paciente asociado");
		}

		if (invoice.isMedicineId()) {
			ClinicalOrder clinicalOrder = clinicalOrderPort.findById(invoice.getOrder().getId());
			if (clinicalOrder == null || patient.getId() != clinicalOrder.getPatient().getId()) {
				throw new Exception("La venta de un medicamento requiere una orden asociada");
			}
			invoice.setOrder(clinicalOrder);
		}

		invoice.setPatient(patient);
		invoicePort.save(invoice);
	}
}

