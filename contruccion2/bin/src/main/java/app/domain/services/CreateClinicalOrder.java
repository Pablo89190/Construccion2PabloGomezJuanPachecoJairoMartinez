package app.domain.services;

import app.domain.model.ClinicalOrder;
import app.domain.model.Patient;
import app.domain.model.User;
import app.domain.model.emuns.Role;
import app.domain.ports.ClinicalOrderPort;
import app.domain.ports.PatientPort;
import app.domain.ports.UserPort;

public class CreateClinicalOrder {
	
	private UserPort userPort;
	private PatientPort patientPort;
	private ClinicalOrderPort clinicalOrderPort;

	public CreateClinicalOrder(UserPort userPort, PatientPort patientPort, ClinicalOrderPort clinicalOrderPort) {
		this.userPort = userPort;
		this.patientPort = patientPort;
		this.clinicalOrderPort = clinicalOrderPort;
	}
	
	public void create(ClinicalOrder clinicalOrder) throws Exception {
		User doctor = userPort.findByUserName(clinicalOrder.getDoctor().getUsername());
		if (doctor == null || !doctor.getRole().equals(Role.DOCTOR)) {
			throw new Exception("Las órdenes solo las pueden crear los Médicos");
		}

		Patient patient = patientPort.findById(clinicalOrder.getPatient().getId());
		if (patient == null) {
			throw new Exception("Las órdenes se deben aplicar a pacientes ya registrados");
		}

		clinicalOrder.setPatient(patient);
		clinicalOrder.setDoctor(doctor);
		clinicalOrderPort.save(clinicalOrder);
	}
}

