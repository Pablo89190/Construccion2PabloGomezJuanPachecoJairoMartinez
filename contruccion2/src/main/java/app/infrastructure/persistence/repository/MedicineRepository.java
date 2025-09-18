package app.infrastructure.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import app.infrastructure.persistence.entities.MedicineEntity;

@Repository
public interface MedicineRepository extends JpaRepository<MedicineEntity, String> {
    
    MedicineEntity findByMedicineId(String medicineId);
    
    MedicineEntity findByName(String name);
    
    @Query("SELECT m FROM MedicineEntity m WHERE m.cost BETWEEN :minCost AND :maxCost")
    List<MedicineEntity> findByCostRange(@Param("minCost") double minCost, @Param("maxCost") double maxCost);
}