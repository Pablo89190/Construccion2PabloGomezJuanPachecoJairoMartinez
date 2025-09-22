package app.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.DiagnosticOrder;
import app.domain.model.Patient;
import app.domain.ports.DiagnosticOrderPort;
import app.domain.ports.PatientPort;

@Service
public class CreateDiagnosticOrder {
    
	@Autowired
    private DiagnosticOrderPort diagnosticOrderPort;
	@Autowired
    private PatientPort patientPort;

    public CreateDiagnosticOrder(DiagnosticOrderPort diagnosticOrderPort, PatientPort patientPort) {
        this.diagnosticOrderPort = diagnosticOrderPort;
        this.patientPort = patientPort;
    }

    public void create(DiagnosticOrder order) throws Exception {
    	Patient patient = patientPort.findById(order.getPatient().getId());

        if (patient == null) {
            throw new Exception("El paciente no existe");
        }
        diagnosticOrderPort.save(order);
    }
}


