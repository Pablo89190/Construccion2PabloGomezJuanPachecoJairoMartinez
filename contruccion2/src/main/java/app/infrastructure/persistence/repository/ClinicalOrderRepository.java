package app.infrastructure.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import app.infrastructure.persistence.entities.ClinicalOrderEntity;

@Repository
public interface ClinicalOrderRepository extends JpaRepository<ClinicalOrderEntity, Long> {
    
    ClinicalOrderEntity findById(long id);
    
    @Query("SELECT co FROM ClinicalOrderEntity co WHERE co.patient.id = :patientId")
    List<ClinicalOrderEntity> findByPatientId(@Param("patientId") long patientId);
    
    @Query("SELECT co FROM ClinicalOrderEntity co WHERE co.doctor.id = :doctorId")
    List<ClinicalOrderEntity> findByDoctorId(@Param("doctorId") long doctorId);
    
    @Query("SELECT co FROM ClinicalOrderEntity co WHERE co.orderType = :orderType")
    List<ClinicalOrderEntity> findByOrderType(@Param("orderType") String orderType);
}