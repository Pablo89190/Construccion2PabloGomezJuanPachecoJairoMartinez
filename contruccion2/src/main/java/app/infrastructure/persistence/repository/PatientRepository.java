package app.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import app.infrastructure.persistence.entities.PatientEntity;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, Long> {
    
    PatientEntity findById(long id);
    
    @Query("SELECT p FROM PatientEntity p WHERE p.fullName = :fullName")
    PatientEntity findByFullName(@Param("fullName") String fullName);
    
    @Query("SELECT p FROM PatientEntity p WHERE p.document = :document")
    PatientEntity findByDocument(@Param("document") long document);
    
    @Query("SELECT p FROM PatientEntity p WHERE p.email = :email")
    PatientEntity findByEmail(@Param("email") String email);
}