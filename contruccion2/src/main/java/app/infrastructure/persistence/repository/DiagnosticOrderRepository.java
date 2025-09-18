package app.infrastructure.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import app.infrastructure.persistence.entities.DiagnosticOrderEntity;

@Repository
public interface DiagnosticOrderRepository extends JpaRepository<DiagnosticOrderEntity, Long> {
    
    @Query("SELECT do FROM DiagnosticOrderEntity do WHERE do.patient.id = :patientId")
    List<DiagnosticOrderEntity> findByPatientId(@Param("patientId") long patientId);
    
    @Query("SELECT do FROM DiagnosticOrderEntity do WHERE do.exam = :exam")
    List<DiagnosticOrderEntity> findByExam(@Param("exam") String exam);
}