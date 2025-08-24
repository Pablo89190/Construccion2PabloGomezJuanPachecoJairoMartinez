package app.application.usecases;

import app.domain.services.CreateProcedure;
import app.domain.model.Procedure;

public class NurseUseCase {

	private CreateProcedure createProcedure;
	
	public void createOrder(Procedure procedure) throws Exception {
		createProcedure.create(procedure);
		
	}
		
}  