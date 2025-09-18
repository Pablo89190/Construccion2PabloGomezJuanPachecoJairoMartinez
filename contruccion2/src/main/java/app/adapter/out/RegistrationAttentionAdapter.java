package app.adapter.out;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.Patient;
import app.domain.model.RegistrationAttention;
import app.domain.ports.RegistrationAttentionPort;
import app.infrastructure.persistence.entities.RegistrationAttentionEntity;
import app.infrastructure.persistence.mapper.RegistrationAttentionMapper;
import app.infrastructure.persistence.repository.RegistrationAttentionRepository;

@Service
public class RegistrationAttentionAdapter implements RegistrationAttentionPort {
    
    @Autowired
    private RegistrationAttentionRepository registrationAttentionRepository;

    @Override
    public RegistrationAttention findById(long id) throws Exception {
        RegistrationAttentionEntity entity = registrationAttentionRepository.findById(id);
        if (entity == null) {
            throw new Exception("No se encontró el registro de atención con ID: " + id);
        }
        return RegistrationAttentionMapper.toDomain(entity);
    }

    @Override
    public List<RegistrationAttention> findByPatient(Patient patient) throws Exception {
        List<RegistrationAttentionEntity> entities = registrationAttentionRepository.findByPatientId(patient.getId());
        List<RegistrationAttention> attentions = new ArrayList<>();
        
        for (RegistrationAttentionEntity entity : entities) {
            attentions.add(RegistrationAttentionMapper.toDomain(entity));
        }
        
        return attentions;
    }

    @Override
    public void save(RegistrationAttention attention) throws Exception {
        RegistrationAttentionEntity entity = RegistrationAttentionMapper.toEntity(attention);
        registrationAttentionRepository.save(entity);
    }
}