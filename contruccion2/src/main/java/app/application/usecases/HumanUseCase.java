package app.application.usecases;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import app.domain.model.User;
import app.domain.model.emuns.Role;
import app.domain.services.CreateUser;
import app.domain.services.DeleteUser;
import app.domain.services.UpdateEmployee;

@Service
public class HumanUseCase {
    
    private final CreateUser createUser;
    private final DeleteUser deleteUser;
    private final UpdateEmployee updateEmployee;

    @Autowired
    public HumanUseCase(CreateUser createUser, DeleteUser deleteUser, UpdateEmployee updateEmployee) {
        this.createUser = createUser;
        this.deleteUser = deleteUser;
        this.updateEmployee = updateEmployee;
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

    public void updateUser(User user) throws Exception {
        updateEmployee.updateUser(user);
    }

    public void updatePersonalData(String username, String fullName, String birthDate, String address, String phone, String email) throws Exception {
        updateEmployee.updatePersonalData(username, fullName, birthDate, address, phone, email);
    }
}
