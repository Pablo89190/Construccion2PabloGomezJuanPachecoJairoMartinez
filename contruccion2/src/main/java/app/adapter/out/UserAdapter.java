package app.adapter.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.User;
import app.domain.ports.UserPort;
import app.infrastructure.persistence.entities.UserEntity;
import app.infrastructure.persistence.mapper.UserMapper;
import app.infrastructure.persistence.repository.UserRepository;

@Service
public class UserAdapter implements UserPort {
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUserName(String username) throws Exception {
        UserEntity entity = userRepository.findByUserName(username);
        if (entity == null) {
            return null;
        }
        return UserMapper.toDomain(entity);
    }

    @Override
    public User findByPassword(String password) throws Exception {
        return null;
    }

    @Override
    public void save(User user) throws Exception {
        UserEntity entity = UserMapper.toEntity(user);
        userRepository.save(entity);
    }

    @Override
    public void delete(User user) {
        UserEntity entity = UserMapper.toEntity(user);
        userRepository.delete(entity);
    }
}