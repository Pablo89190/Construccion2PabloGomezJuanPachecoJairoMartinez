package app.adapter.out;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.ClinicalOrder;
import app.domain.model.Patient;
import app.domain.ports.ClinicalOrderPort;
import app.infrastructure.persistence.entities.ClinicalOrderEntity;
import app.infrastructure.persistence.mapper.ClinicalOrderMapper;
import app.infrastructure.persistence.repository.ClinicalOrderRepository;

@Service
public class ClinicalOrderAdapter implements ClinicalOrderPort {
    
    @Autowired
    private ClinicalOrderRepository clinicalOrderRepository;

    @Override
    public ClinicalOrder findById(long id) throws Exception {
        ClinicalOrderEntity entity = clinicalOrderRepository.findById(id);
        if (entity == null) {
            throw new Exception("No se encontró la orden clínica con ID: " + id);
        }
        return ClinicalOrderMapper.toDomain(entity);
    }

    @Override
    public List<ClinicalOrder> findByPatient(Patient patient) throws Exception {
        List<ClinicalOrder> clinicalOrders = new ArrayList<>();
        List<ClinicalOrderEntity> entities = clinicalOrderRepository.findByPatientId(patient.getId());
        
        for (ClinicalOrderEntity entity : entities) {
            clinicalOrders.add(ClinicalOrderMapper.toDomain(entity));
        }
        return clinicalOrders;
    }

    @Override
    public void save(ClinicalOrder clinicalOrder) throws Exception {
        ClinicalOrderEntity entity = ClinicalOrderMapper.toEntity(clinicalOrder);
        clinicalOrderRepository.save(entity);
    }
}