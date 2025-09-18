package app.adapter.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.Procedure;
import app.domain.ports.ProcedurePort;
import app.infrastructure.persistence.entities.ProcedureEntity;
import app.infrastructure.persistence.mapper.ProcedureMapper;
import app.infrastructure.persistence.repository.ProcedureRepository;

@Service
public class ProcedureAdapter implements ProcedurePort {
    
    @Autowired
    private ProcedureRepository procedureRepository;

    @Override
    public Procedure findById(String id) {
        try {
            long longId = Long.parseLong(id);
            ProcedureEntity entity = procedureRepository.findById(longId).orElse(null);
            return entity != null ? ProcedureMapper.toDomain(entity) : null;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Override
    public Procedure findByName(String name) {
        ProcedureEntity entity = procedureRepository.findByName(name);
        return entity != null ? ProcedureMapper.toDomain(entity) : null;
    }

    @Override
    public void save(Procedure procedure) {
        ProcedureEntity entity = ProcedureMapper.toEntity(procedure);
        procedureRepository.save(entity);
    }

    @Override
    public void update(Procedure procedure) {
        ProcedureEntity entity = ProcedureMapper.toEntity(procedure);
        procedureRepository.save(entity);
    }

    @Override
    public void delete(Procedure procedure) {
        ProcedureEntity entity = ProcedureMapper.toEntity(procedure);
        procedureRepository.delete(entity);
    }
}