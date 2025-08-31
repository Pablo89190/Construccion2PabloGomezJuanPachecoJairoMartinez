package app.domain.services;

import java.util.List;

import app.domain.model.ClinicalRecord;
import app.domain.model.Patient;
import app.domain.ports.ClinicalRecordPort;
import app.domain.ports.PatientPort;

public class SearchClinicalRecordByPatient {
    
    private ClinicalRecordPort clinicalRecordPort;
    private PatientPort patientPort;

    public SearchClinicalRecordByPatient(ClinicalRecordPort clinicalRecordPort, PatientPort patientPort) {
        this.clinicalRecordPort = clinicalRecordPort;
        this.patientPort = patientPort;
    }

    public List<ClinicalRecord> search(long patientId) throws Exception {
        Patient patient = patientPort.findById(patientId); 
        if (patient == null) {
            throw new Exception("No existe el paciente buscado");
        }
        return clinicalRecordPort.findByPatient(patient);
    }
}
