package app.infrastructure.persistence.mapper;

import java.util.ArrayList;
import java.util.List;

import app.domain.model.ClinicalOrder;
import app.domain.model.ItemOrder;
import app.domain.model.emuns.OrderType;
import app.infrastructure.persistence.entities.ClinicalOrderEntity;
import app.infrastructure.persistence.entities.ItemOrderEntity;
import app.infrastructure.persistence.entities.PatientEntity;
import app.infrastructure.persistence.entities.UserEntity;
import app.infrastructure.persistence.repository.PatientRepository;
import app.infrastructure.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClinicalOrderMapper {
    
    private static PatientRepository patientRepository;
    private static UserRepository userRepository;
    
    @Autowired
    public void setPatientRepository(PatientRepository repo) {
        ClinicalOrderMapper.patientRepository = repo;
    }
    
    @Autowired
    public void setUserRepository(UserRepository repo) {
        ClinicalOrderMapper.userRepository = repo;
    }

    // Dominio → Entidad
    public static ClinicalOrderEntity toEntity(ClinicalOrder domain) {
        if (domain == null) return null;

        System.out.println("Mapeando ClinicalOrder a Entity ");

        ClinicalOrderEntity entity = new ClinicalOrderEntity();
        
        // NO establecer ID si es 0 - JPA lo generará
        if (domain.getId() > 0) {
            entity.setId(domain.getId());
        }
        
        // ✅ CRÍTICO: Cargar PACIENTE desde BD
        if (domain.getPatient() != null) {
            Long patientDocument = domain.getPatient().getId();
            System.out.println(" Buscando paciente por documento: " + patientDocument);
            
            PatientEntity patientEntity = patientRepository.findByDocument(patientDocument);
            
            if (patientEntity == null) {
                System.err.println(" ERROR: No se encontró paciente con documento: " + patientDocument);
                throw new RuntimeException("No se encontró el paciente con documento: " + patientDocument);
            }
            
            entity.setPatient(patientEntity);
            System.out.println("Paciente cargado: " + patientEntity.getFullName());
        }
        
        // ✅ CRÍTICO: Cargar DOCTOR desde BD
        if (domain.getDoctor() != null) {
            Long doctorDocument = domain.getDoctor().getId();
            System.out.println("Buscando doctor por documento: " + doctorDocument);
            
            UserEntity doctorEntity = userRepository.findByDocument(doctorDocument);
            
            if (doctorEntity == null) {
                System.err.println("❌ ERROR: No se encontró doctor con documento: " + doctorDocument);
                throw new RuntimeException("No se encontró el doctor con documento: " + doctorDocument);
            }
            
            entity.setDoctor(doctorEntity);
            System.out.println("✅ Doctor cargado: " + doctorEntity.getName());
        }
        
        entity.setDate(domain.getDate());
        entity.setOrderType(domain.getOrderType().name());

        // Mapear items
        if (domain.getItems() != null && !domain.getItems().isEmpty()) {
            List<ItemOrderEntity> itemEntities = new ArrayList<>();
            for (ItemOrder item : domain.getItems()) {
                ItemOrderEntity itemEntity = ItemOrderMapper.toEntity(item);
                itemEntity.setClinicalOrder(entity);
                itemEntities.add(itemEntity);
            }
            entity.setItems(itemEntities);
            System.out.println("✅ " + itemEntities.size() + " items mapeados");
        }
        
        System.out.println("✅ ClinicalOrderEntity mapeado completamente");
        System.out.println("🔄 === Fin mapeo ===\n");

        return entity;
    }

    // Entidad → Dominio
    public static ClinicalOrder toDomain(ClinicalOrderEntity entity) {
        if (entity == null) return null;

        ClinicalOrder domain = new ClinicalOrder() {};
        
        domain.setId(entity.getId());
        domain.setPatient(PatientMapper.toDomain(entity.getPatient()));
        domain.setDoctor(UserMapper.toDomain(entity.getDoctor()));
        domain.setDate(entity.getDate());
        domain.setOrderType(OrderType.valueOf(entity.getOrderType()));

        // Mapear items
        if (entity.getItems() != null && !entity.getItems().isEmpty()) {
            List<ItemOrder> items = new ArrayList<>();
            for (ItemOrderEntity itemEntity : entity.getItems()) {
                items.add(ItemOrderMapper.toDomain(itemEntity));
            }
            domain.setItems(items);
        } else {
            domain.setItems(new ArrayList<>());
        }

        return domain;
    }
}