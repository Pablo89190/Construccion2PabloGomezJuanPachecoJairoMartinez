package app.domain.services;

import app.domain.model.Patient;
import app.domain.ports.PatientPort;

public class CreatePatient {
	
	private PatientPort patientPort;

	public void createPerson (Patient patient) throws Exception {
		
		
		if(PatientPort.findById(patient)!=null) { 
			throw new Exception ("Ya existe una persona con este documento");
			
		}
		if (patientPort.findByFullName(patient)!=null) {
			throw new Exception ("Ya existe una persona con este nombre");
		  }
		patientPort.save(patient);
	}
	

}