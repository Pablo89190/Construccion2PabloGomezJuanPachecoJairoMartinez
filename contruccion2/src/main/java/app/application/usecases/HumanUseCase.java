package app.application.usecases;

import app.domain.model.User;
import app.domain.model.emuns.Role;
import app.domain.services.CreateUser;

public class HumanUseCase {
    
    private CreateUser createUser;

    public HumanUseCase(CreateUser createUser) {
        this.createUser = createUser;
    }
    
    public void createAdmin(User user) throws Exception {
        user.setRole(Role.ADMIN);
        createUser.createUser(user);
    }
    
    public void createDoctor(User user) throws Exception {
        user.setRole(Role.DOCTOR);
        createUser.createUser(user);
    }
    
    public void createNurse(User user) throws Exception {
        user.setRole(Role.NURSE);
        createUser.createUser(user);
    }
    
    public void createSupport(User user) throws Exception {
        user.setRole(Role.SUPPORT);
        createUser.createUser(user);
    }
    
}
