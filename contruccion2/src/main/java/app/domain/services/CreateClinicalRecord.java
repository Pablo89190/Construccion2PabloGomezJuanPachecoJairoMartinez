package app.domain.services;

import app.domain.model.ClinicalRecord;
import app.domain.ports.ClinicalRecordPort;
import app.domain.model.Patient;
import app.domain.model.User;
import app.domain.model.emuns.Role;
import app.domain.ports.PatientPort;
import app.domain.ports.UserPort;
import app.domain.model.ClinicalOrder;
import app.domain.ports.ClinicalOrderPort;

public class CreateClinicalRecord {
	
	private PatientPort patientPort;
	private UserPort userPort;
	private ClinicalRecordPort clinicalRecordPort;
    private ClinicalOrderPort clinicalOrderPort;
	
	public void create(ClinicalRecord clinicalRecord) throws Exception {
		
		Patient patient = patientPort.findById(clinicalRecord.getPatient());
		if (patient== null) {
			throw new Exception("La historia clinica debe tener un paciente");
			
		}
		User doctor = userPort.findByUserName(clinicalRecord.getDoctor());
		if(doctor==null || !doctor.getRole().equals(Role.DOCTOR)) {
			throw new Exception("La historia clinica debe ser registrada por un Medico");
		}
		
		ClinicalOrder clinicalOrder = clinicalOrderPort.findById(clinicalRecord.getClinicalOrder());
		if(clinicalOrder==null) {
			
			throw new Exception("la historia clinica debe tener una orden valida asociada");
		}
		clinicalRecord.setPatient(patient);
		clinicalRecord.setDoctor(doctor);
		clinicalRecord.setClinicalOrder(clinicalOrder);
		clinicalRecordPort.save(clinicalRecord);
		
	}

}
