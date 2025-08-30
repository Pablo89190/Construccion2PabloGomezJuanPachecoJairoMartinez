package app.application.usecases;

import java.util.List;

import app.domain.model.ClinicalRecord;
import app.domain.model.Patient;
import app.domain.services.CreateClinicalRecord;
import app.domain.services.SearchClinicalRecordByPatient;

public class DoctorUseCase {
	
	private CreateClinicalRecord createClinicalRecord;
	
	public void createRecord(ClinicalRecord record)throws Exception {
		createClinicalRecord.create(record);
	}
	

	public List<ClinicalRecord> searchRecords(Patient patient) throws Exception {
		return SearchClinicalRecordByPatient.search(patient);
	}

}