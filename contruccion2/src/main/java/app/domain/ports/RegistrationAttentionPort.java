package app.domain.ports;

import app.domain.model.RegistrationAttention;
import app.domain.model.Patient;
import java.util.List;

public interface RegistrationAttentionPort {
	
    RegistrationAttention findById(long id) throws Exception;
    
    List<RegistrationAttention> findByPatient(Patient patient) throws Exception;
   
    void save(RegistrationAttention attention) throws Exception;
}


<<<<<<< HEAD
=======

>>>>>>> 077db3882d5d312ddc26ce9dac7407cb9dda70d5
