package app.infrastructure.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import app.infrastructure.persistence.entities.ProcedureEntity;

@Repository
public interface ProcedureRepository extends JpaRepository<ProcedureEntity, Long> {
    
    ProcedureEntity findByName(String name);
    
    @Query("SELECT p FROM ProcedureEntity p WHERE p.requiresSpecialist = :requiresSpecialist")
    List<ProcedureEntity> findByRequiresSpecialist(@Param("requiresSpecialist") boolean requiresSpecialist);
    
    @Query("SELECT p FROM ProcedureEntity p WHERE p.specialty = :specialty")
    List<ProcedureEntity> findBySpecialty(@Param("specialty") String specialty);
}