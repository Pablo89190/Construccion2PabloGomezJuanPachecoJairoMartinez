package app.domain.services;

import app.domain.model.ClinicalOrder;
import app.domain.model.Invoice;
import app.domain.model.Patient;
import app.domain.ports.ClinicalOrderPort;
import app.domain.ports.InvoicePort;
import app.domain.ports.PatientPort;

public class CreateInvoice {
	
	private PatientPort patientPort ;
	private ClinicalOrderPort clinicalOrderPort;
	private InvoicePort invoicePort;
	
	public void create(Invoice invoice) throws Exception {
		Patient patient = patientPort.findById(invoice.getPatient());
		if(patient==null) {
			throw new Exception("La factura debe tener un Paciente asociado");
			
		}
		if(invoice.isMedicineId()) {
			ClinicalOrder clinicalOrder = clinicalOrderPort.findById(invoice.getOrder());
			if (clinicalOrder==null || patient.getId()!=clinicalOrder.getPatient().getId()) {
					throw new Exception ("La venta de un medicamento requiere una orden asociada");
				 
			}
			invoice.setOrder(clinicalOrder);
			
		}
		invoice.setPatient(patient);
		invoicePort.save(invoice);
	}
	
	

}
