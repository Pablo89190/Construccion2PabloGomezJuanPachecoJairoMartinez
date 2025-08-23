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

	
public void create(ClinicalOrder clinicalOrder) throws Exception{
		User doctor = userPort.findByUserName(clinicalOrder.getDoctor());
		if (doctor ==null || !doctor.getRole().equals(Role.DOCTOR)) {
			throw new Exception ("Las ordenes solo las pueden crear los Medicos");
		}
		Patient patient = patientPort.findById(clinicalOrder.getPatient());
		if (patient ==null) {
			throw new Exception("Las ordernes se deben aplicar a Pacientes ya registrados");
		}
		
		clinicalOrder.setPatient(patient);
		clinicalOrder.setDoctor(doctor);
		clinicalOrderPort.save(clinicalOrder);
		
		
			
	}
}
