package app.domain.services;

import java.util.List;
import app.domain.model.ClinicalOrder;
import app.domain.model.Patient;
import app.domain.ports.ClinicalOrderPort;
import app.domain.ports.PatientPort;

public class SearchOrdersByPatient {

	private ClinicalOrderPort clinicalOrderPort;
	private PatientPort patientPort;

	public SearchOrdersByPatient(ClinicalOrderPort clinicalOrderPort, PatientPort patientPort) {
		this.clinicalOrderPort = clinicalOrderPort;
		this.patientPort = patientPort;
	}

	public List<ClinicalOrder> search(Patient patient) throws Exception {
	patient = patientPort.findById(patient.getId());
		if (patient == null) {
			throw new Exception("Debe consultar órdenes de un paciente registrado");
		}
		return clinicalOrderPort.findByPatient(patient);
	}
<<<<<<< HEAD
}
=======
}
>>>>>>> e5de97035147bada9c1d2d5aee69811e23add275
