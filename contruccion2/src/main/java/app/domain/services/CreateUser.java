package app.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.User;
import app.domain.ports.UserPort;

@Service
public class CreateUser {
   @Autowired
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
