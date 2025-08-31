package app.domain.services;

import app.domain.model.ClinicalRecord;
import app.domain.model.Patient;
import app.domain.model.User;
import app.domain.model.ClinicalOrder;
import app.domain.model.emuns.Role;
import app.domain.ports.ClinicalRecordPort;
import app.domain.ports.ClinicalOrderPort;
import app.domain.ports.PatientPort;
import app.domain.ports.UserPort;

public class CreateClinicalRecord {
	
	private UserPort userPort;
	private PatientPort patientPort;
	private ClinicalRecordPort clinicalRecordPort;
	private ClinicalOrderPort clinicalOrderPort;

	public CreateClinicalRecord(UserPort userPort, PatientPort patientPort,
	                            ClinicalRecordPort clinicalRecordPort, ClinicalOrderPort clinicalOrderPort) {
		this.userPort = userPort;
		this.patientPort = patientPort;
		this.clinicalRecordPort = clinicalRecordPort;
		this.clinicalOrderPort = clinicalOrderPort;
	}
	
	public void create(ClinicalRecord clinicalRecord) throws Exception {
		Patient patient = patientPort.findById(clinicalRecord.getPatient().getId());
		if (patient == null) {
			throw new Exception("La historia clínica debe tener un paciente válido");
		}

		User doctor = userPort.findByUserName(clinicalRecord.getDoctor().getUsername());
		if (doctor == null || !doctor.getRole().equals(Role.DOCTOR)) {
			throw new Exception("La historia clínica debe ser registrada por un Médico");
		}

		ClinicalOrder clinicalOrder = clinicalOrderPort.findById(clinicalRecord.getClinicalOrder().getId());
		if (clinicalOrder == null) {
			throw new Exception("La historia clínica debe tener una orden válida asociada");
		}

		clinicalRecord.setPatient(patient);
		clinicalRecord.setDoctor(doctor);
		clinicalRecord.setClinicalOrder(clinicalOrder);
		clinicalRecordPort.save(clinicalRecord);
	}
}
