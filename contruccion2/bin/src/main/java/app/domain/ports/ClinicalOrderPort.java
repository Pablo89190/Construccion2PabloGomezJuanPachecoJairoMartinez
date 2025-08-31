package app.domain.ports;

import java.util.List;
import app.domain.model.ClinicalOrder;
import app.domain.model.Patient;

public interface ClinicalOrderPort {
    
    ClinicalOrder findById(long id) throws Exception;   // Buscar por ID
    
    List<ClinicalOrder> findByPatient(Patient patient) throws Exception;  // Buscar todas las órdenes de un paciente
    
    void save(ClinicalOrder clinicalOrder) throws Exception;  // Guardar orden clínica
}
