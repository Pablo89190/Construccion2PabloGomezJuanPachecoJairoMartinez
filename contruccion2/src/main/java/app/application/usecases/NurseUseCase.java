package app.application.usecases;

import app.domain.services.CreateProcedure;
import app.domain.model.Procedure;

public class NurseUseCase {

	private CreateProcedure createProcedure;
	
	public void createOrder(Procedure procedure) throws Exception {
		createProcedure.create(procedure);
		
	}
		
<<<<<<< HEAD
}  
=======
}  
>>>>>>> a927a2e5c8e06e091f48b5505e174b60b84318c2
