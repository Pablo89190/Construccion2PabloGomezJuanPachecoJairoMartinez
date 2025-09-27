package app.application.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.User;
import app.domain.model.emuns.Role;
import app.domain.services.CreateUser;
import app.domain.services.DeleteUser;

@Service
public class HumanUseCase {
    
	@Autowired
    private final CreateUser createUser;
	@Autowired
    private final DeleteUser deleteUser;

    public HumanUseCase(CreateUser createUser, DeleteUser deleteUser) {
        this.createUser = createUser;
        this.deleteUser = deleteUser;
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

    public void deleteUser(User user) throws Exception {
        deleteUser.delete(user);
    }
}

