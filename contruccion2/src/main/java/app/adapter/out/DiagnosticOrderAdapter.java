package app.adapter.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.DiagnosticOrder;
import app.domain.ports.DiagnosticOrderPort;
import app.infrastructure.persistence.entities.DiagnosticOrderEntity;
import app.infrastructure.persistence.mapper.DiagnosticOrderMapper;
import app.infrastructure.persistence.repository.DiagnosticOrderRepository;

@Service
public class DiagnosticOrderAdapter implements DiagnosticOrderPort {
    
    @Autowired
    private DiagnosticOrderRepository diagnosticOrderRepository;

    @Override
    public void save(DiagnosticOrder order) {
        DiagnosticOrderEntity entity = DiagnosticOrderMapper.toEntity(order);
        diagnosticOrderRepository.save(entity);
    }

    @Override
    public DiagnosticOrder findById(String id) {
        try {
            long longId = Long.parseLong(id);
            DiagnosticOrderEntity entity = diagnosticOrderRepository.findById(longId).orElse(null);
            return entity != null ? DiagnosticOrderMapper.toDomain(entity) : null;
        } catch (NumberFormatException e) {
            return null;
        }
    }
}