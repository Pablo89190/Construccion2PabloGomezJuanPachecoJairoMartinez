package app.adapter.out;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.ClinicalRecord;
import app.domain.model.Patient;
import app.domain.model.RegistrationAttention;
import app.domain.ports.ClinicalRecordPort;
import app.infrastructure.persistence.entities.ClinicalRecordEntity;
import app.infrastructure.persistence.entities.RegistrationAttentionEntity;
import app.infrastructure.persistence.mapper.ClinicalRecordMapper;
import app.infrastructure.persistence.mapper.RegistrationAttentionMapper;
import app.infrastructure.persistence.repository.ClinicalRecordRepository;
import app.infrastructure.persistence.repository.RegistrationAttentionRepository;

@Service
public class ClinicalRecordAdapter implements ClinicalRecordPort {
    
    @Autowired
    private ClinicalRecordRepository clinicalRecordRepository;
    
    @Autowired
    private RegistrationAttentionRepository registrationAttentionRepository;

    @Override
    public void save(ClinicalRecord clinicalRecord) throws Exception {
        ClinicalRecordEntity entity = ClinicalRecordMapper.toEntity(clinicalRecord);
        clinicalRecordRepository.save(entity);
    }

    @Override
    public List<ClinicalRecord> findByPatient(Patient patient) throws Exception {
        List<ClinicalRecordEntity> entities = clinicalRecordRepository.findByPatientId(patient.getId());
        List<ClinicalRecord> records = new ArrayList<>();
        
        for (ClinicalRecordEntity entity : entities) {
            records.add(ClinicalRecordMapper.toDomain(entity));
        }
        
        return records;
    }

    @Override
    public void addAttention(String patientId, RegistrationAttention attention) throws Exception {
        RegistrationAttentionEntity entity = RegistrationAttentionMapper.toEntity(attention);
        registrationAttentionRepository.save(entity);
    }
}