package app.infrastructure.persistence.mapper;

import app.domain.model.Patient;
import app.domain.model.EmergencyContact;
import app.domain.model.Insurance;
import app.infrastructure.persistence.entities.PatientEntity;

public class PatientMapper {

    // Dominio → Entidad
    public static PatientEntity toEntity(Patient domain) {
        if (domain == null) return null;

        PatientEntity entity = new PatientEntity();
        entity.setId(domain.getId());
        entity.setFullName(domain.getFullName());
        entity.setDocument(domain.getId()); // 
        entity.setAge(domain.getAge());
        entity.setAddress(domain.getAddress());
        entity.setPhone(domain.getPhone());
        entity.setEmail(domain.getEmail());
        entity.setBirthDate(domain.getBirthDate());
        entity.setGender(domain.getGender());

   
        if (domain.getEmergencyContact() != null) {
            entity.setEmergencyContact(domain.getEmergencyContact());
        }

        if (domain.getInsurance() != null) {
            entity.setInsurance(domain.getInsurance());
        }

        return entity;
    }

    // Entidad → Dominio
    public static Patient toDomain(PatientEntity entity) {
        if (entity == null) return null;

        Patient domain = new Patient();
        domain.setId(entity.getId());
        domain.setFullName(entity.getFullName());
        domain.setAge(entity.getAge());
        domain.setAddress(entity.getAddress());
        domain.setPhone(entity.getPhone());
        domain.setEmail(entity.getEmail());
        domain.setBirthDate(entity.getBirthDate());
        domain.setGender(null, entity.getGender());

       
        if (entity.getEmergencyContact() != null) {
            domain.setEmergencyContact(entity.getEmergencyContact());
        }

        if (entity.getInsurance() != null) {
            domain.setInsurance(entity.getInsurance());
        }

        return domain;
    }
}

