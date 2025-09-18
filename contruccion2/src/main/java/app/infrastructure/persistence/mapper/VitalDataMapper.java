package app.infrastructure.persistence.mapper;

import app.domain.model.VitalData;
import app.infrastructure.persistence.entities.VitalDataEntity;

public class VitalDataMapper {

    // Dominio → Entidad
    public static VitalDataEntity toEntity(VitalData domain) {
        if (domain == null) return null;

        VitalDataEntity entity = new VitalDataEntity();
        entity.setBloodPressure(domain.getBloodPressure());
        entity.setTemperature(domain.getTemperature());
        entity.setPulserate(domain.getPulserate());
        entity.setBloodOxygenLevel(domain.getBloodOxygenLevel());

        return entity;
    }

    // Entidad → Dominio
    public static VitalData toDomain(VitalDataEntity entity) {
        if (entity == null) return null;

        VitalData domain = new VitalData();
        domain.setBloodPressure(entity.getBloodPressure());
        domain.setTemperature(entity.getTemperature());
        domain.setPulserate(entity.getPulserate());
        domain.setBloodOxygenLevel(entity.getBloodOxygenLevel());

        return domain;
    }
}