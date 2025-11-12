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

        System.out.println("🔄 Mapeando RegistrationAttention a Entity...");

        RegistrationAttentionEntity entity = new RegistrationAttentionEntity();
        
        // NO establecer ID si es 0 - JPA lo generará
        if (domain.getId() > 0) {
            entity.setId(domain.getId());
        }
        
        // Mapear paciente (REQUERIDO)
        if (domain.getPatient() != null) {
            entity.setPatient(PatientMapper.toEntity(domain.getPatient()));
            System.out.println("✅ Patient mapeado en atención");
        } else {
            System.err.println("⚠️ WARNING: Patient es NULL en RegistrationAttention");
        }
        
        // Mapear doctor (OPCIONAL)
        if (domain.getDoctor() != null) {
            entity.setDoctor(UserMapper.toEntity(domain.getDoctor()));
            System.out.println("✅ Doctor mapeado en atención");
        }
        
        entity.setReason(domain.getReason());
        entity.setSymptoms(domain.getSymptoms());
        entity.setDiagnosis(domain.getDiagnosis());
        
        // Mapear datos vitales (OPCIONAL)
        if (domain.getVitalData() != null) {
            entity.setVitalData(VitalDataMapper.toEntity(domain.getVitalData()));
            System.out.println("✅ VitalData mapeado");
        }
        
        // El createdAt se establece automáticamente en el constructor

        // Mapear órdenes si existen
        if (domain.getOrders() != null && !domain.getOrders().isEmpty()) {
            List<ClinicalOrderEntity> orderEntities = new ArrayList<>();
            for (ClinicalOrder order : domain.getOrders()) {
                orderEntities.add(ClinicalOrderMapper.toEntity(order));
            }
            entity.setOrders(orderEntities);
            System.out.println("✅ " + orderEntities.size() + " órdenes mapeadas");
        }

        System.out.println("✅ RegistrationAttentionEntity mapeado completamente");

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

        // Mapear órdenes
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