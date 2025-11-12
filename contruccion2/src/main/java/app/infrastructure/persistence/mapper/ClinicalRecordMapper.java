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

        System.out.println("Mapeando ClinicalRecord a Entity...");
        System.out.println("  PatientId: " + domain.getPatientId());
        System.out.println("  Patient: " + (domain.getPatient() != null ? domain.getPatient().getFullName() : "NULL"));

        ClinicalRecordEntity entity = new ClinicalRecordEntity();
        entity.setPatientId(domain.getPatientId());
        
        // CRÍTICO: Convertir el Patient del dominio a PatientEntity
        if (domain.getPatient() != null) {
            entity.setPatient(PatientMapper.toEntity(domain.getPatient()));
            System.out.println("Patient mapeado correctamente");
        } else {
            System.err.println("WARNING: Patient es NULL en el dominio");
        }
        
        // Mapear doctor si existe
        if (domain.getDoctor() != null) {
            entity.setDoctor(UserMapper.toEntity(domain.getDoctor()));
            System.out.println("✅ Doctor mapeado");
        }
        
        // Mapear clinical order si existe
        if (domain.getClinicalOrder() != null) {
            entity.setClinicalOrder(ClinicalOrderMapper.toEntity(domain.getClinicalOrder()));
            System.out.println("✅ ClinicalOrder mapeado");
        }
        
        // El createdAt se establece automáticamente en el constructor de la entidad
        
        System.out.println("ClinicalRecordEntity mapeado completamente");

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

        // Mapear registros de atención
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