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

<<<<<<< HEAD
    public List<ClinicalRecord> search(String string) throws Exception {
        Patient patient = patientPort.findById(string); 
=======
    public List<ClinicalRecord> search(long patientId) throws Exception {
        Patient patient = patientPort.findById(patientId); 
>>>>>>> e5de97035147bada9c1d2d5aee69811e23add275
        if (patient == null) {
            throw new Exception("No existe el paciente buscado");
        }
        return clinicalRecordPort.findByPatient(patient);
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> e5de97035147bada9c1d2d5aee69811e23add275
