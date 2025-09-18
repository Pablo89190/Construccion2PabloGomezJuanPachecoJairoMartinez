package app.adapter.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.Medicine;
import app.domain.ports.MedicinePort;
import app.infrastructure.persistence.entities.MedicineEntity;
import app.infrastructure.persistence.mapper.MedicineMapper;
import app.infrastructure.persistence.repository.MedicineRepository;

@Service
public class MedicineAdapter implements MedicinePort {
    
    @Autowired
    private MedicineRepository medicineRepository;

    @Override
    public Medicine findByMedicineId(String medicineId) {
        MedicineEntity entity = medicineRepository.findByMedicineId(medicineId);
        return entity != null ? MedicineMapper.toDomain(entity) : null;
    }

    @Override
    public Medicine findByName(String name) {
        MedicineEntity entity = medicineRepository.findByName(name);
        return entity != null ? MedicineMapper.toDomain(entity) : null;
    }

    @Override
    public void save(Medicine medicine) {
        MedicineEntity entity = MedicineMapper.toEntity(medicine);
        medicineRepository.save(entity);
    }

    @Override
    public void update(Medicine medicine) {
        MedicineEntity entity = MedicineMapper.toEntity(medicine);
        medicineRepository.save(entity); // JPA save() actualiza si existe
    }

    @Override
    public void delete(Medicine medicine) {
        MedicineEntity entity = MedicineMapper.toEntity(medicine);
        medicineRepository.delete(entity);
    }
}