package app.application.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.services.CreateProcedure;
import app.domain.model.Procedure;
import app.domain.model.VitalData;
import app.domain.model.RegistrationAttention;
import app.domain.services.CreateVitalData;
import app.domain.services.RegisterNurseAttention;

@Service
public class NurseUseCase {

	@Autowired
	private CreateProcedure createProcedure;
	@Autowired
	private CreateVitalData createVitalData;
	@Autowired
	private RegisterNurseAttention registerNurseAttention;
	
	   public NurseUseCase(CreateVitalData createVitalData, RegisterNurseAttention registerNurseAttention, CreateProcedure createProcedure) {
	        this.createVitalData = createVitalData;
	        this.registerNurseAttention = registerNurseAttention;
	        this.createProcedure = createProcedure;
	    }
	public void createOrder(Procedure procedure) throws Exception {
		createProcedure.create(procedure);
		
	}
	
	  public void registerVitalData(VitalData vitalData) throws Exception {
	        createVitalData.create(vitalData);
	    }
	  
	  public void registerAttention(String patientId, RegistrationAttention attention, VitalData vitalData) throws Exception {
	        registerNurseAttention.registerAttention(patientId, attention, vitalData);
	    }
}

