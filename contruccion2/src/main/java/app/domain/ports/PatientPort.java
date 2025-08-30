package app.domain.ports;

import app.domain.model.Patient;


public interface PatientPort {
	
	public static  Patient findById(Patient patient) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	public Patient findByFullName(Patient patient) throws Exception;
	
	public void save(Patient patient) throws Exception;
}