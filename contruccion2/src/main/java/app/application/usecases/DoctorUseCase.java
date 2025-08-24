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
	
<<<<<<< HEAD
	//crear el services necesario para poder aplicar este fragmento
	//public List<ClinicalRecord> searchRecords(Patient patient) throws Exception {
		//return searchClinicalRecord.search(patient);
	}

	
=======
	//public List<ClinicalRecord> searchRecords(Patient patient) throws Exception {
	//	return searchClinicalRecord.search(patient);
	}
	


>>>>>>> a927a2e5c8e06e091f48b5505e174b60b84318c2
