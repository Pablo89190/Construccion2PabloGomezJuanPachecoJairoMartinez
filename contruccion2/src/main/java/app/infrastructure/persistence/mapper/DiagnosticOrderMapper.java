package app.infrastructure.persistence.mapper;

import app.domain.model.DiagnosticOrder;
import app.domain.model.emuns.DiagnosticExam;
import app.domain.model.emuns.OrderType;
import app.infrastructure.persistence.entities.DiagnosticOrderEntity;

public class DiagnosticOrderMapper {

    // Dominio → Entidad
    public static DiagnosticOrderEntity toEntity(DiagnosticOrder domain) {
        if (domain == null) return null;

        DiagnosticOrderEntity entity = new DiagnosticOrderEntity();
        entity.setId(domain.getId());
        entity.setPatient(PatientMapper.toEntity(domain.getPatient()));
        entity.setDoctor(UserMapper.toEntity(domain.getDoctor()));
        entity.setDate(domain.getDate());
        entity.setOrderType(domain.getOrderType().name());
        entity.setExam(domain.getExam().name());
        entity.setQuantity(domain.getQuantity());
        entity.setCost(domain.getCost());

        return entity;
    }

    // Entidad → Dominio
    public static DiagnosticOrder toDomain(DiagnosticOrderEntity entity) {
        if (entity == null) return null;

        DiagnosticOrder domain = new DiagnosticOrder();
        domain.setId(entity.getId());
        domain.setPatient(PatientMapper.toDomain(entity.getPatient()));
        domain.setDoctor(UserMapper.toDomain(entity.getDoctor()));
        domain.setDate(entity.getDate());
        domain.setOrderType(OrderType.valueOf(entity.getOrderType()));
        domain.setExam(DiagnosticExam.valueOf(entity.getExam()));
        domain.setQuantity(entity.getQuantity());
        domain.setCost(entity.getCost());

        return domain;
    }
}