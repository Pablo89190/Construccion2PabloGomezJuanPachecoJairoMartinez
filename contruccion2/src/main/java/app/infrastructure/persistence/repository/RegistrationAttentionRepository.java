package app.infrastructure.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import app.infrastructure.persistence.entities.RegistrationAttentionEntity;

@Repository
public interface RegistrationAttentionRepository extends JpaRepository<RegistrationAttentionEntity, Long> {
    
    RegistrationAttentionEntity findById(long id);
    
    @Query("SELECT ra FROM RegistrationAttentionEntity ra WHERE ra.patient.id = :patientId")
    List<RegistrationAttentionEntity> findByPatientId(@Param("patientId") long patientId);
    
    @Query("SELECT ra FROM RegistrationAttentionEntity ra WHERE ra.doctor.id = :doctorId")
    List<RegistrationAttentionEntity> findByDoctorId(@Param("doctorId") long doctorId);
}