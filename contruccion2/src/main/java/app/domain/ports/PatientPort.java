package app.domain.ports;

import app.domain.model.Patient;
import app.domain.model.User;

public interface PatientPort {
    

    Patient findById(String string) throws Exception;   

    Patient findById(long id) throws Exception;   

    Patient findByFullName(String fullName) throws Exception;
    
    void save(User patient) throws Exception;
}
