package app.infrastructure.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import app.infrastructure.persistence.entities.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByDocument(long document);

    UserEntity findByUserName(String userName);
    
    @Query("SELECT u FROM UserEntity u WHERE u.role = :role")
    List<UserEntity> findByRole(@Param("role") String role);
    
    @Query("SELECT u FROM UserEntity u WHERE u.userName = :userName AND u.password = :password")
    UserEntity findByUserNameAndPassword(@Param("userName") String userName, @Param("password") String password);
}