package app.infrastructure.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import app.infrastructure.persistence.entities.ClinicalRecordEntity;

@Repository
public interface ClinicalRecordRepository extends JpaRepository<ClinicalRecordEntity, Long> {
    
    @Query("SELECT cr FROM ClinicalRecordEntity cr WHERE cr.patient.id = :patientId")
    List<ClinicalRecordEntity> findByPatientId(@Param("patientId") long patientId);
    
    @Query("SELECT cr FROM ClinicalRecordEntity cr WHERE cr.doctor.id = :doctorId")
    List<ClinicalRecordEntity> findByDoctorId(@Param("doctorId") long doctorId);
    
    ClinicalRecordEntity findByPatientId(String patientId);
}