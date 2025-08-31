package app.domain.ports;

import app.domain.model.Patient;

public interface PatientPort {
    
<<<<<<< HEAD
    Patient findById(String string) throws Exception;   
=======
    Patient findById(long id) throws Exception;   
>>>>>>> e5de97035147bada9c1d2d5aee69811e23add275
    
    Patient findByFullName(String fullName) throws Exception;
    
    void save(Patient patient) throws Exception;
<<<<<<< HEAD
}
=======
}
>>>>>>> e5de97035147bada9c1d2d5aee69811e23add275
