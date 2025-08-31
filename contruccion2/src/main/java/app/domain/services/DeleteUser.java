package app.domain.services;

import app.domain.model.User;
import app.domain.ports.UserPort;

public class DeleteUser {

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