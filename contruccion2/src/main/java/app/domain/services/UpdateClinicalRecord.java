package app.domain.services;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import app.domain.model.ClinicalRecord;
import app.domain.model.Patient;
import app.domain.model.RegistrationAttention;
import app.domain.model.User;
import app.domain.model.emuns.Role;
import app.domain.ports.ClinicalRecordPort;
import app.domain.ports.PatientPort;
import app.domain.ports.UserPort;

@Service
public class UpdateClinicalRecord {

    private final ClinicalRecordPort clinicalRecordPort;
    private final PatientPort patientPort;
    private final UserPort userPort;

    @Autowired
    public UpdateClinicalRecord(ClinicalRecordPort clinicalRecordPort, 
                                PatientPort patientPort, 
                                UserPort userPort) {
        this.clinicalRecordPort = clinicalRecordPort;
        this.patientPort = patientPort;
        this.userPort = userPort;
    }

    public void updateRecord(ClinicalRecord clinicalRecord) throws Exception {
        Patient patient = patientPort.findById(clinicalRecord.getPatientId());
        if (patient == null) {
            throw new Exception("No existe el paciente para actualizar la historia clínica");
        }

        if (clinicalRecord.getRecords() == null || clinicalRecord.getRecords().isEmpty()) {
            throw new Exception("No hay registros médicos para actualizar");
        }

        for (Map.Entry<String, RegistrationAttention> entry : clinicalRecord.getRecords().entrySet()) {
            RegistrationAttention attention = entry.getValue();
            if (attention.getDoctor() != null) {
                User doctor = userPort.findByUserName(attention.getDoctor().getUsername());
                if (doctor == null || !doctor.getRole().equals(Role.DOCTOR)) {
                    throw new Exception("Solo los médicos pueden actualizar registros médicos");
                }
                attention.setDoctor(doctor);
            }
        }

        clinicalRecord.setPatientId(patient.getId() + "");
        clinicalRecordPort.save(clinicalRecord);
    }

    public void addAttentionToRecord(String patientId, String date, RegistrationAttention attention) throws Exception {
        Patient patient = patientPort.findById(patientId);
        if (patient == null) {
            throw new Exception("No existe el paciente para agregar la atención");
        }

        if (attention.getDoctor() != null) {
            User doctor = userPort.findByUserName(attention.getDoctor().getUsername());
            if (doctor == null || !doctor.getRole().equals(Role.DOCTOR)) {
                throw new Exception("Solo los médicos pueden agregar registros de atención");
            }
            attention.setDoctor(doctor);
        }

        attention.setPatient(patient);
        clinicalRecordPort.addAttention(patientId, attention);
    }
}
