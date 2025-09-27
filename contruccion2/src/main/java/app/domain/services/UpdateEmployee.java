package app.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.domain.model.User;
import app.domain.ports.UserPort;

@Service
public class UpdateEmployee {

    @Autowired
    private UserPort userPort;

    public UpdateEmployee(UserPort userPort) {
        this.userPort = userPort;
    }

    public void updateUser(User user) throws Exception {
        if (user == null) {
            throw new Exception("El usuario no puede ser nulo");
        }


        User existingUser = userPort.findByUserName(user.getUsername());
        if (existingUser == null) {
            throw new Exception("No existe un usuario con este nombre de usuario");
        }

       
        if (!user.getPassword().equals(existingUser.getPassword())) {
            User userWithSamePassword = userPort.findByPassword(user.getPassword());
            if (userWithSamePassword != null && !userWithSamePassword.getUsername().equals(user.getUsername())) {
                throw new Exception("La nueva contraseña ya está en uso por otro usuario");
            }
        }
        userPort.save(user);
    }

    public void updatePersonalData(String username, String fullName, String birthDate, String address, String phone, String email) throws Exception {
        User existingUser = userPort.findByUserName(username);
        if (existingUser == null) {
            throw new Exception("No existe un usuario con este nombre de usuario");
        }

       
        existingUser.setFullName(fullName);
        existingUser.setBirthDate(birthDate);
        existingUser.setAddress(address);
        existingUser.setPhone(phone);
        existingUser.setEmail(email);

        userPort.save(existingUser);
    }
}