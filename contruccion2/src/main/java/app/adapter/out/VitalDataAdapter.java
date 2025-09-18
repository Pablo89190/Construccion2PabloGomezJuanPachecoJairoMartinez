package app.adapter.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.VitalData;
import app.domain.ports.VitalDataPort;
import app.infrastructure.persistence.entities.VitalDataEntity;
import app.infrastructure.persistence.mapper.VitalDataMapper;
import app.infrastructure.persistence.repository.VitalDataRepository;

@Service
public class VitalDataAdapter implements VitalDataPort {
    
    @Autowired
    private VitalDataRepository vitalDataRepository;

    @Override
    public VitalData save(VitalData vitalData) {
        VitalDataEntity entity = VitalDataMapper.toEntity(vitalData);
        entity.setRecordedAt(java.time.LocalDateTime.now());
        VitalDataEntity savedEntity = vitalDataRepository.save(entity);
        return VitalDataMapper.toDomain(savedEntity);
    }

    @Override
    public VitalData findById(String id) {
        try {
            long longId = Long.parseLong(id);
            VitalDataEntity entity = vitalDataRepository.findById(longId);
            return entity != null ? VitalDataMapper.toDomain(entity) : null;
        } catch (NumberFormatException e) {
            return null;
        }
    }
}