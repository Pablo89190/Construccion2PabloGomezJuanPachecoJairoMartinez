package app.domain.ports;

import java.util.List;
import app.domain.model.Patient;
import app.domain.model.ClinicalRecord;
import app.domain.model.RegistrationAttention; 

public interface ClinicalRecordPort {
    void save(ClinicalRecord clinicalRecord) throws Exception;
    List<ClinicalRecord> findByPatient(Patient patient) throws Exception;
    void addAttention(String patientId, RegistrationAttention attention) throws Exception;
<<<<<<< HEAD
}
=======
}
>>>>>>> e5de97035147bada9c1d2d5aee69811e23add275
