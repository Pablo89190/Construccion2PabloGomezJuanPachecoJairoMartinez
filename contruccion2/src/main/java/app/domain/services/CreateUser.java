package app.domain.services;

import app.domain.model.User;
import app.domain.ports.UserPort;

public class CreateUser {
	
	private UserPort userPort;
	
	public void createPerson(User user) throws Exception {
		
		if(userPort.findByUserName(user)!=null) {
			throw new Exception (" Ya existe una persona con este Id");
		}
		
	if (userPort.findByPassword(user)!=null) {
		throw new Exception ("Ya existe una persona con este nombre ");
	  }
	userPort.save(user);
	  
	}

}
