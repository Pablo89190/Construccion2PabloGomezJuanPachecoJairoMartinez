package app.infrastructure.persistence.mapper;

import app.domain.model.User;
import app.domain.model.emuns.Role;
import app.infrastructure.persistence.entities.UserEntity;

public class UserMapper {

   
    public static UserEntity toEntity(User domain) {
        if (domain == null) return null;

        UserEntity entity = new UserEntity();
        entity.setName(domain.getFullName());
        entity.setDocument(domain.getId());
        entity.setAge(domain.getAge());
        entity.setAddress(domain.getAddress());
        entity.setPhone(domain.getPhone());
        entity.setEmail(domain.getEmail());
        entity.setBirthDate(domain.getBirthDate());
        entity.setRole(domain.getRole() != null ? domain.getRole().name() : "");
        entity.setUserName(domain.getUsername());
        entity.setPassword(domain.getPassword());

        return entity;
    }

    public static User toDomain(UserEntity entity) {
        if (entity == null) return null;

        User domain = new User();
        domain.setId(entity.getDocument()); 
        domain.setFullName(entity.getName());
        domain.setAge(entity.getAge());
        domain.setAddress(entity.getAddress());
        domain.setPhone(entity.getPhone());
        domain.setEmail(entity.getEmail());
        domain.setBirthDate(entity.getBirthDate());
        domain.setUsername(entity.getUserName());
        domain.setPassword(entity.getPassword());
        
        if (entity.getRole() != null && !entity.getRole().isEmpty()) {
            domain.setRole(Role.valueOf(entity.getRole()));
        }

        return domain;
    }
}
