package app.domain.ports;

import app.domain.model.Patient;

public interface PatientPort {
    

    Patient findById(String string) throws Exception;   

    Patient findById(long id) throws Exception;   

    
    Patient findByFullName(String fullName) throws Exception;
    
    void save(Patient patient) throws Exception;

}

