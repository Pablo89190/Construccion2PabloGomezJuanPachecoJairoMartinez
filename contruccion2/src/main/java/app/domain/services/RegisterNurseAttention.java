package app.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.ClinicalRecord;
import app.domain.model.Patient;
import app.domain.model.RegistrationAttention;
import app.domain.model.VitalData;
import app.domain.ports.ClinicalRecordPort;
import app.domain.ports.PatientPort;

import java.util.HashMap;
import java.util.List;

@Service
public class RegisterNurseAttention {
    
    @Autowired
    private ClinicalRecordPort clinicalRecordPort;
    
    @Autowired
    private PatientPort patientPort;

    public RegisterNurseAttention(ClinicalRecordPort clinicalRecordPort, PatientPort patientPort) {
        this.clinicalRecordPort = clinicalRecordPort;
        this.patientPort = patientPort;
    }

    public void registerAttention(String patientId, RegistrationAttention attention, VitalData vitalData) throws Exception {
        System.out.println(" REGISTRO DE ATENCIÓN DE ENFERMERÍA");
        System.out.println("PatientId: " + patientId);
        
        if (attention == null) {
            throw new Exception("La atención no puede ser nula");
        }

        // Validar que el paciente existe
        long patientIdLong = Long.parseLong(patientId);
        Patient patient = patientPort.findById(patientIdLong);
        
        if (patient == null) {
            throw new Exception("El paciente no existe en el sistema");
        }
        
        System.out.println("✅ Paciente encontrado: " + patient.getFullName());

    
        List<ClinicalRecord> existingRecords = clinicalRecordPort.findByPatient(patient);
        
        ClinicalRecord clinicalRecord = null;
        
        if (existingRecords == null || existingRecords.isEmpty()) {
            System.out.println("No existe historia clínica, creando una nueva...");
            
            // Crear nueva historia clínica CON TODOS LOS DATOS DEL PACIENTE
            clinicalRecord = new ClinicalRecord();
            clinicalRecord.setPatientId(patientId);
            
            // Establecer el paciente completo con todos sus datos
            Patient fullPatient = new Patient();
            fullPatient.setId(patient.getId());
            fullPatient.setFullName(patient.getFullName());
            fullPatient.setAge(patient.getAge());
            fullPatient.setEmail(patient.getEmail());
            fullPatient.setAddress(patient.getAddress());
            fullPatient.setPhone(patient.getPhone());
            fullPatient.setGender(patient.getGender() != null ? patient.getGender().name() : null, patient.getGender());
            
            clinicalRecord.setPatient(fullPatient);
            clinicalRecord.setRecords(new HashMap<>());
            
            // Guardar la historia clínica
            clinicalRecordPort.save(clinicalRecord);
            
            System.out.println(" Historia clínica creada automáticamente");
        } else {
            System.out.println(" Historia clínica ya existe");
            clinicalRecord = existingRecords.get(0);
        }

        // Establecer datos vitales en la atención
        attention.setVitalData(vitalData);
        
        // Asegurar que el paciente esté establecido en la atención
        attention.setPatient(patient);

        // Guardar la atención
        clinicalRecordPort.addAttention(patientId, attention);
        
        System.out.println("Atención de enfermería registrada exitosamente");
        System.out.println("FIN REGISTRO DE ATENCIÓN \n");
    }
}