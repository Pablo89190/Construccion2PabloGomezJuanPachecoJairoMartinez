package app.infrastructure.persistence.mapper;

import app.domain.model.Medicine;
import app.infrastructure.persistence.entities.MedicineEntity;

public class MedicineMapper {

    // Dominio → Entidad
    public static MedicineEntity toEntity(Medicine domain) {
        if (domain == null) return null;

        MedicineEntity entity = new MedicineEntity();
        entity.setMedicineId(domain.getMedicineId());
        entity.setName(domain.getName());
        entity.setDoce(domain.getDoce());
        entity.setDuration(domain.getDuration());
        entity.setCost(domain.getCost());

        return entity;
    }

    // Entidad → Dominio
    public static Medicine toDomain(MedicineEntity entity) {
        if (entity == null) return null;

        Medicine domain = new Medicine();
        domain.setMedicineId(entity.getMedicineId());
        domain.setName(entity.getName());
        domain.setDoce(entity.getDoce());
        domain.setDuration(entity.getDuration());
        domain.setCost(entity.getCost());

        return domain;
    }
}