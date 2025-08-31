package app.domain.ports;

import app.domain.model.Patient;

public interface PatientPort {
    

    Patient findById(String string) throws Exception;   

    Patient findById(long id) throws Exception;   
<<<<<<< HEAD

=======
>>>>>>> d98169972ccf3fa424acb23690ca2ab08e9e2219
    
    Patient findByFullName(String fullName) throws Exception;
    
    void save(Patient patient) throws Exception;
<<<<<<< HEAD

}
=======
}
}
>>>>>>> d98169972ccf3fa424acb23690ca2ab08e9e2219

