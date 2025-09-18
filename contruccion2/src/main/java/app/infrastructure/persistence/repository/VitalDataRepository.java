package app.infrastructure.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import app.infrastructure.persistence.entities.VitalDataEntity;

@Repository
public interface VitalDataRepository extends JpaRepository<VitalDataEntity, Long> {
    
    VitalDataEntity findById(long id);
    
    @Query("SELECT v FROM VitalDataEntity v WHERE v.patient.id = :patientId")
    List<VitalDataEntity> findByPatientId(@Param("patientId") long patientId);
}
