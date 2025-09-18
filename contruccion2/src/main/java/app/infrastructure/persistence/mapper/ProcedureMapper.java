package app.infrastructure.persistence.mapper;

import app.domain.model.Procedure;
import app.domain.model.emuns.Specialty;
import app.infrastructure.persistence.entities.ProcedureEntity;

public class ProcedureMapper {

    // Dominio → Entidad
    public static ProcedureEntity toEntity(Procedure domain) {
        if (domain == null) return null;

        ProcedureEntity entity = new ProcedureEntity();
        entity.setName(domain.getName());
        entity.setTimes(domain.getTimes());
        entity.setFrequency(domain.getFrequency());
        entity.setRequiresSpecialist(domain.isRequiresSpecialist());
        entity.setCost(domain.getCost());

        if (domain.getSpecialty() != null) {
            entity.setSpecialty(domain.getSpecialty().name());
        }

        return entity;
    }

    // Entidad → Dominio
    public static Procedure toDomain(ProcedureEntity entity) {
        if (entity == null) return null;

        Procedure domain = new Procedure();
        domain.setName(entity.getName());
        domain.setTimes(entity.getTimes());
        domain.setFrequency(entity.getFrequency());
        domain.setRequiresSpecialist(entity.isRequiresSpecialist());
        domain.setCost(entity.getCost());

        if (entity.getSpecialty() != null && !entity.getSpecialty().isEmpty()) {
            domain.setSpecialty(Specialty.valueOf(entity.getSpecialty()));
        }

        return domain;
    }
}