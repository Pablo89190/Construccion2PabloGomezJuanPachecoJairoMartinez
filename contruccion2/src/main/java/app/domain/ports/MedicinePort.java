package app.domain.ports;

import app.domain.model.Medicine;

public interface MedicinePort {
    
    Medicine findByMedicineId(String medicineId);
    
    Medicine findByName(String name);
    
    void save(Medicine medicine);
    
    void update(Medicine medicine);
    
    void delete(Medicine medicine);
}
