package app.domain.ports;

import app.domain.model.Patient;


public interface PatientPort {
	
	public Patient findById(Patient patient) throws Exception;
	public Patient findByFullName(Patient patient) throws Exception;
	
	public void save(Patient patient) throws Exception;
}
