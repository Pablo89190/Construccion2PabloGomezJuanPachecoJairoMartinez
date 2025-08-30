package app.domain.services;

import java.util.List;

import app.domain.model.ClinicalRecord;
import app.domain.model.Patient;
import app.domain.ports.ClinicalRecordPort;
import app.domain.ports.PatientPort;

public class SearchClinicalRecordByPatient {
	
	private static ClinicalRecordPort clinicalRecordPort;
	
	public static List<ClinicalRecord> search(Patient patient) throws Exception{
		patient = PatientPort.findById(patient);
		if(patient == null) {
			throw new Exception("No existe el paciente buscado");
		}
		return clinicalRecordPort.findByPatient(patient);
		
	}

}