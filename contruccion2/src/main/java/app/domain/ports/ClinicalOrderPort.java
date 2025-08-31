package app.domain.ports;

import java.util.List;
import app.domain.model.ClinicalOrder;
import app.domain.model.Patient;

public interface ClinicalOrderPort {
    
    ClinicalOrder findById(long id) throws Exception;
    
    List<ClinicalOrder> findByPatient(Patient patient) throws Exception;
    
    void save(ClinicalOrder clinicalOrder) throws Exception;
}
    ClinicalOrder findById(long id) throws Exception;   
    
    List<ClinicalOrder> findByPatient(Patient patient) throws Exception;  
    
    void save(ClinicalOrder clinicalOrder) throws Exception;  
}
