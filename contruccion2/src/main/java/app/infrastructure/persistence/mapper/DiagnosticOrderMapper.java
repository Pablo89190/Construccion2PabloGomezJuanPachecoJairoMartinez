package app.infrastructure.persistence.mapper;

import app.domain.model.DiagnosticOrder;
import app.domain.model.emuns.DiagnosticExam;
import app.domain.model.emuns.OrderType;
import app.infrastructure.persistence.entities.DiagnosticOrderEntity;
import app.infrastructure.persistence.entities.PatientEntity;
import app.infrastructure.persistence.entities.UserEntity;
import app.infrastructure.persistence.repository.PatientRepository;
import app.infrastructure.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DiagnosticOrderMapper {
    
    private static PatientRepository patientRepository;
    private static UserRepository userRepository;
    
    @Autowired
    public void setPatientRepository(PatientRepository repo) {
        DiagnosticOrderMapper.patientRepository = repo;
    }
    
    @Autowired
    public void setUserRepository(UserRepository repo) {
        DiagnosticOrderMapper.userRepository = repo;
    }

    public static DiagnosticOrderEntity toEntity(DiagnosticOrder domain) {
        if (domain == null) return null;

        System.out.println("🔄 === Mapeando DiagnosticOrder a Entity ===");
        
        DiagnosticOrderEntity entity = new DiagnosticOrderEntity();

        if (domain.getId() > 0) {
            entity.setId(domain.getId());
        }

        if (domain.getPatient() != null) {
            Long patientDocument = domain.getPatient().getId();
            System.out.println("🔍 Buscando paciente por documento: " + patientDocument);
            
            PatientEntity patientEntity = patientRepository.findByDocument(patientDocument);
            
            if (patientEntity == null) {
                System.err.println("❌ ERROR: No se encontró paciente con documento: " + patientDocument);
                throw new RuntimeException("No se encontró el paciente con documento: " + patientDocument);
            }
            
            entity.setPatient(patientEntity);
            System.out.println("Paciente cargado desde BD: " + patientEntity.getFullName());
        } else {
            System.err.println("ERROR: Patient es NULL en domain");
            throw new RuntimeException("El paciente no puede ser null");
        }
        

        if (domain.getDoctor() != null) {
            Long doctorDocument = domain.getDoctor().getId();
            System.out.println("🔍 Buscando doctor por documento: " + doctorDocument);
            
            UserEntity doctorEntity = userRepository.findByDocument(doctorDocument);
            
            if (doctorEntity == null) {
                System.err.println("❌ ERROR: No se encontró doctor con documento: " + doctorDocument);
                throw new RuntimeException("No se encontró el doctor con documento: " + doctorDocument);
            }
            
            entity.setDoctor(doctorEntity);
            System.out.println("✅ Doctor cargado desde BD: " + doctorEntity.getName());
        } else {
            System.err.println("❌ ERROR: Doctor es NULL en domain");
            throw new RuntimeException("El doctor no puede ser null");
        }
        
        entity.setDate(domain.getDate());
        entity.setOrderType(domain.getOrderType().name());
        entity.setExam(domain.getExam().name());
        entity.setQuantity(domain.getQuantity());
        entity.setCost(domain.getCost());
        
        System.out.println(" DiagnosticOrderEntity mapeado completamente");
        System.out.println("   - Examen: " + entity.getExam());
        System.out.println("   - Cantidad: " + entity.getQuantity());
        System.out.println("   - Costo: " + entity.getCost());
        System.out.println(" Fin mapeo \n");

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