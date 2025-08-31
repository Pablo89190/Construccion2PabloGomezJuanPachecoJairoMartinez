package app.domain.ports;

import java.util.List;
import app.domain.model.ClinicalOrder;
import app.domain.model.Patient;

public interface ClinicalOrderPort {
    
<<<<<<< HEAD

=======
>>>>>>> d98169972ccf3fa424acb23690ca2ab08e9e2219
    ClinicalOrder findById(long id) throws Exception;
    
    List<ClinicalOrder> findByPatient(Patient patient) throws Exception;
    
    void save(ClinicalOrder clinicalOrder) throws Exception;
}
<<<<<<< HEAD

  

=======
    ClinicalOrder findById(long id) throws Exception;   
    
    List<ClinicalOrder> findByPatient(Patient patient) throws Exception;  
    
    void save(ClinicalOrder clinicalOrder) throws Exception;  
}
>>>>>>> d98169972ccf3fa424acb23690ca2ab08e9e2219
