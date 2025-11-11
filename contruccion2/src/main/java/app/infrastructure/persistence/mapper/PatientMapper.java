package app.infrastructure.persistence.mapper;

import app.domain.model.Patient;
import app.infrastructure.persistence.entities.PatientEntity;

public class PatientMapper {

    // Dominio → Entidad
    public static PatientEntity toEntity(Patient domain) {
        if (domain == null) return null;

        PatientEntity entity = new PatientEntity();
        
        // Establecer document (requerido)
        entity.setDocument(domain.getId());
        
        entity.setFullName(domain.getFullName());
        entity.setAge(domain.getAge());
        entity.setAddress(domain.getAddress());
        entity.setPhone(domain.getPhone());
        entity.setEmail(domain.getEmail());
        entity.setBirthDate(domain.getBirthDate());
        entity.setGender(domain.getGender());

        // Contacto de emergencia
        if (domain.getEmergencyContact() != null) {
            entity.setEmergencyContact(domain.getEmergencyContact());
        }

        // Información de seguro
        if (domain.getInsurance() != null) {
            entity.setInsuranceCompany(domain.getInsurance().getCompany());
            entity.setPolicyNumber(domain.getInsurance().getPolicyNumber());
            entity.setPolicyStatus(domain.getInsurance().getValidity());
            entity.setPolicyEndDate(domain.getInsurance().getPolicyEndDate());
        }

        return entity;
    }

    // Entidad → Dominio
    public static Patient toDomain(PatientEntity entity) {
        if (entity == null) return null;

        Patient domain = new Patient();
        
        domain.setId(entity.getDocument()); // Usar document como ID
        domain.setFullName(entity.getFullName());
        domain.setAge(entity.getAge());
        domain.setAddress(entity.getAddress());
        domain.setPhone(entity.getPhone());
        domain.setEmail(entity.getEmail());
        domain.setBirthDate(entity.getBirthDate());
        
        // Gender
        if (entity.getGender() != null) {
            domain.setGender(entity.getGender().name(), entity.getGender());
        }

        // Contacto de emergencia
        if (entity.getEmergencyContact() != null) {
            domain.setEmergencyContact(entity.getEmergencyContact());
        }

        // Información de seguro
        if (entity.getInsuranceCompany() != null || entity.getPolicyNumber() != null) {
            domain.setInsuranceCompany(entity.getInsuranceCompany());
            if (entity.getPolicyNumber() != null) {
                try {
                    domain.setPolicyNumber(Integer.parseInt(entity.getPolicyNumber()));
                } catch (NumberFormatException e) {
                    // Ignorar si no se puede convertir
                }
            }
            domain.setPolicyEndDate(entity.getPolicyEndDate());
        }

        return domain;
    }
}
