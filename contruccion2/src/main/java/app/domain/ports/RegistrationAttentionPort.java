package app.domain.ports;

import app.domain.model.RegistrationAttention;
import app.domain.model.Patient;
import java.util.List;

public interface RegistrationAttentionPort {
	
    RegistrationAttention findById(long id) throws Exception;
    
    List<RegistrationAttention> findByPatient(Patient patient) throws Exception;
   
    void save(RegistrationAttention attention) throws Exception;
<<<<<<< HEAD
}
=======
}
>>>>>>> e5de97035147bada9c1d2d5aee69811e23add275
