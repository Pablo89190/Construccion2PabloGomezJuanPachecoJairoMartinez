package app.domain.ports;

import java.util.List;
import app.domain.model.ClinicalOrder;
import app.domain.model.Patient;

public interface ClinicalOrderPort {
    
<<<<<<< HEAD
    ClinicalOrder findById(long id) throws Exception;
    
    List<ClinicalOrder> findByPatient(Patient patient) throws Exception;
    
    void save(ClinicalOrder clinicalOrder) throws Exception;
}
=======
    ClinicalOrder findById(long id) throws Exception;   // Buscar por ID
    
    List<ClinicalOrder> findByPatient(Patient patient) throws Exception;  // Buscar todas las órdenes de un paciente
    
    void save(ClinicalOrder clinicalOrder) throws Exception;  // Guardar orden clínica
}
>>>>>>> e5de97035147bada9c1d2d5aee69811e23add275
