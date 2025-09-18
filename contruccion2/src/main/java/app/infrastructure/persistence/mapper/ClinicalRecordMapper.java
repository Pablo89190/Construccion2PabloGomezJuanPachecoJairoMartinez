package app.infrastructure.persistence.mapper;

import java.util.HashMap;
import java.util.Map;

import app.domain.model.ClinicalRecord;
import app.domain.model.RegistrationAttention;
import app.infrastructure.persistence.entities.ClinicalRecordEntity;
import app.infrastructure.persistence.entities.RegistrationAttentionEntity;

public class ClinicalRecordMapper {

    // Dominio → Entidad
    public static ClinicalRecordEntity toEntity(ClinicalRecord domain) {
        if (domain == null) return null;

        ClinicalRecordEntity entity = new ClinicalRecordEntity();
        entity.setPatientId(domain.getPatientId());
        entity.setPatient(PatientMapper.toEntity(domain.getPatient()));
        entity.setDoctor(UserMapper.toEntity(domain.getDoctor()));
        entity.setClinicalOrder(ClinicalOrderMapper.toEntity(domain.getClinicalOrder()));
        entity.setCreatedAt(java.time.LocalDateTime.now());

        return entity;
    }

    // Entidad → Dominio
    public static ClinicalRecord toDomain(ClinicalRecordEntity entity) {
        if (entity == null) return null;

        ClinicalRecord domain = new ClinicalRecord();
        domain.setPatientId(entity.getPatientId());
        domain.setPatient(PatientMapper.toDomain(entity.getPatient()));
        domain.setDoctor(UserMapper.toDomain(entity.getDoctor()));
        domain.setClinicalOrder(ClinicalOrderMapper.toDomain(entity.getClinicalOrder()));


        Map<String, RegistrationAttention> records = new HashMap<>();
        if (entity.getRegistrations() != null) {
            for (RegistrationAttentionEntity regEntity : entity.getRegistrations()) {
                RegistrationAttention attention = RegistrationAttentionMapper.toDomain(regEntity);
                records.put(String.valueOf(attention.getId()), attention);
            }
        }
        domain.setRecords(records);

        return domain;
    }
}