package app.domain.ports;

import java.util.List;
import app.domain.model.Patient;
import app.domain.model.ClinicalRecord;
import app.domain.model.RegistrationAttention; 

public interface ClinicalRecordPort {
    void save(ClinicalRecord clinicalRecord) throws Exception;
    List<ClinicalRecord> findByPatient(Patient patient) throws Exception;
    void addAttention(String patientId, RegistrationAttention attention) throws Exception;

}
<<<<<<< HEAD

=======
}
>>>>>>> d98169972ccf3fa424acb23690ca2ab08e9e2219

