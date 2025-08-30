package app.domain.services;

import app.domain.model.Patient;
import app.domain.model.RegistrationAttention;
import app.domain.model.User;
import app.domain.model.emuns.Role;
import app.domain.ports.PatientPort;
import app.domain.ports.RegistrationAttentionPort;
import app.domain.ports.UserPort;

public class CreateRegistrationAttention {
    private PatientPort patientPort;
    private UserPort userPort;
    private RegistrationAttentionPort registrationAttentionPort;

    public CreateRegistrationAttention(PatientPort patientPort, UserPort userPort, RegistrationAttentionPort registrationAttentionPort) {
        this.patientPort = patientPort;
        this.userPort = userPort;
        this.registrationAttentionPort = registrationAttentionPort;
    }

    public void create(RegistrationAttention attention) throws Exception {
        
        Patient patient = patientPort.findById(attention.getPatient().getId());
        if (patient == null) {
            throw new Exception("El paciente no existe");
        }
        
        User doctor = userPort.findByUserName(attention.getDoctor().getUsername());
        if (doctor == null || !doctor.getRole().equals(Role.DOCTOR)) {
            throw new Exception("La atención solo puede ser registrada por un médico");
        }

        attention.setPatient(patient);
        attention.setDoctor(doctor);
        registrationAttentionPort.save(attention);
    }
}
