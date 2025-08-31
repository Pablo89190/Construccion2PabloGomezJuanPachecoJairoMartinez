package app.domain.services;

import app.domain.model.User;
import app.domain.ports.UserPort;

public class CreateUser {
    
    private UserPort userPort;

    public CreateUser(UserPort userPort) {
        this.userPort = userPort;
    }
    
    public void createUser(User user) throws Exception {
        
       
        if (userPort.findByUserName(user.getUsername()) != null) {
            throw new Exception("Ya existe una persona con este nombre de usuario");
        }
        
     
        if (userPort.findByPassword(user.getPassword()) != null) {
            throw new Exception("Ya existe una persona con esta contraseña");
        }
      
        userPort.save(user);
    }
}
