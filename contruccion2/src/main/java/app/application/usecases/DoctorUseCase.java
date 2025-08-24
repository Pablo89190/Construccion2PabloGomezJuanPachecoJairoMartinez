package app.application.usecases;

import java.util.List;

import app.domain.model.ClinicalRecord;
import app.domain.model.Patient;
import app.domain.services.CreateClinicalRecord;

public class DoctorUseCase {
	
	private CreateClinicalRecord createClinicalRecord;
	
	public void createRecord(ClinicalRecord record)throws Exception {
		createClinicalRecord.create(record);
	}
	
	//crear el services necesario para poder aplicar este fragmento
	//public List<ClinicalRecord> searchRecords(Patient patient) throws Exception {
		//return searchClinicalRecord.search(patient);
	}

	