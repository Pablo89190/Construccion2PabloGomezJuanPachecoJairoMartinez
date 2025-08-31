package app.domain.ports;

import app.domain.model.User;

public interface UserPort {
    
    User findByUserName(String username) throws Exception; 
    
    User findByPassword(String password) throws Exception; 
    
    void save(User user) throws Exception; 
    
    void delete(User user);
<<<<<<< HEAD
}
=======
}
>>>>>>> e5de97035147bada9c1d2d5aee69811e23add275
