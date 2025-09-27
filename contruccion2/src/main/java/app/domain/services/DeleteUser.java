package app.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.User;
import app.domain.ports.UserPort;
@Service
public class DeleteUser {

	@Autowired
    private final UserPort userPort;

    public DeleteUser(UserPort userPort) {
        this.userPort = userPort;
    }

    public void delete(User user) throws Exception {
        if (user == null) {
            throw new Exception("Usuario inválido");
        }
        userPort.delete(user);
    }
}

