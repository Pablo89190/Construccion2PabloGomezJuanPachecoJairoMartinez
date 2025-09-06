package app.domain.services;

import app.domain.model.Patient;
import app.domain.model.User;
import app.domain.ports.PatientPort;

public class CreatePatient {
	
	private PatientPort patientPort;

	public CreatePatient(PatientPort patientPort) {
		this.patientPort = patientPort;
	}

	public void createPerson(User patient) throws Exception {
		if (patientPort.findById(patient.getId()) != null) { 
			throw new Exception("Ya existe una persona con este documento");
		}
		if (patientPort.findByFullName(patient.getFullName()) != null) {
			throw new Exception("Ya existe una persona con este nombre");
		}
		patientPort.save(patient);
	}
}

