
// 12. RegistrationAttentionMapper.java
package app.infrastructure.persistence.mapper;

import java.util.ArrayList;
import java.util.List;

import app.domain.model.ClinicalOrder;
import app.domain.model.RegistrationAttention;
import app.infrastructure.persistence.entities.ClinicalOrderEntity;
import app.infrastructure.persistence.entities.RegistrationAttentionEntity;

public class RegistrationAttentionMapper {

    // Dominio → Entidad
    public static RegistrationAttentionEntity toEntity(RegistrationAttention domain) {
        if (domain == null) return null;

        RegistrationAttentionEntity entity = new RegistrationAttentionEntity();
        entity.setId(domain.getId());
        entity.setPatient(PatientMapper.toEntity(domain.getPatient()));
        entity.setDoctor(UserMapper.toEntity(domain.getDoctor()));
        entity.setReason(domain.getReason());
        entity.setSymptoms(domain.getSymptoms());
        entity.setDiagnosis(domain.getDiagnosis());
        entity.setVitalData(VitalDataMapper.toEntity(domain.getVitalData()));
        entity.setCreatedAt(java.time.LocalDateTime.now());

        if (domain.getOrders() != null && !domain.getOrders().isEmpty()) {
            List<ClinicalOrderEntity> orderEntities = new ArrayList<>();
            for (ClinicalOrder order : domain.getOrders()) {
                orderEntities.add(ClinicalOrderMapper.toEntity(order));
            }
            entity.setOrders(orderEntities);
        }

        return entity;
    }

    // Entidad → Dominio
    public static RegistrationAttention toDomain(RegistrationAttentionEntity entity) {
        if (entity == null) return null;

        RegistrationAttention domain = new RegistrationAttention();
        domain.setId(entity.getId());
        domain.setPatient(PatientMapper.toDomain(entity.getPatient()));
        domain.setDoctor(UserMapper.toDomain(entity.getDoctor()));
        domain.setReason(entity.getReason());
        domain.setSymptoms(entity.getSymptoms());
        domain.setDiagnosis(entity.getDiagnosis());
        domain.setVitalData(VitalDataMapper.toDomain(entity.getVitalData()));

  
        if (entity.getOrders() != null && !entity.getOrders().isEmpty()) {
            List<ClinicalOrder> orders = new ArrayList<>();
            for (ClinicalOrderEntity orderEntity : entity.getOrders()) {
                orders.add(ClinicalOrderMapper.toDomain(orderEntity));
            }
            domain.setOrders(orders);
        } else {
            domain.setOrders(new ArrayList<>());
        }

        return domain;
    }
}