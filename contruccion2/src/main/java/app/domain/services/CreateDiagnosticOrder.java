package app.domain.services;

import app.domain.model.DiagnosticOrder;
import app.domain.model.Patient;
import app.domain.ports.DiagnosticOrderPort;
import app.domain.ports.PatientPort;

public class CreateDiagnosticOrder {
    
    private DiagnosticOrderPort diagnosticOrderPort;
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
}
