package app.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.User;
import app.domain.ports.PatientPort;

@Service
public class CreatePatient {
    
    @Autowired
    private PatientPort patientPort;

    public CreatePatient(PatientPort patientPort) {
        this.patientPort = patientPort;
    }

    public void createPerson(User patient) throws Exception {
        // Validar que tenga documento
        if (patient.getId() == 0) {
            throw new Exception("El documento del paciente es requerido");
        }
        
        // Validar si ya existe por documento
        if (patientPort.findById(patient.getId()) != null) { 
            throw new Exception("Ya existe un paciente con este documento");
        }
        
        // Validar por nombre completo
        if (patientPort.findByFullName(patient.getFullName()) != null) {
            throw new Exception("Ya existe un paciente con este nombre");
        }
        
        patientPort.save(patient);
    }
}