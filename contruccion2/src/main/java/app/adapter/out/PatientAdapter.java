package app.adapter.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.Patient;
import app.domain.model.User;
import app.domain.ports.PatientPort;
import app.infrastructure.persistence.entities.PatientEntity;
import app.infrastructure.persistence.mapper.PatientMapper;
import app.infrastructure.persistence.repository.PatientRepository;

@Service
public class PatientAdapter implements PatientPort {
    
    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Patient findById(String patientId) throws Exception {
        try {
            long id = Long.parseLong(patientId);
            return findById(id);
        } catch (NumberFormatException e) {
            throw new Exception("ID de paciente inválido: " + patientId);
        }
    }

    @Override
    public Patient findById(long id) throws Exception {
        PatientEntity entity = patientRepository.findById(id);
        if (entity == null) {
            return null;
        }
        return PatientMapper.toDomain(entity);
    }

    @Override
    public Patient findByFullName(String fullName) throws Exception {
        PatientEntity entity = patientRepository.findByFullName(fullName);
        if (entity == null) {
            return null;
        }
        return PatientMapper.toDomain(entity);
    }

    @Override
    public void save(User patient) throws Exception {
        // Convertir User a Patient si es necesario
        Patient patientDomain = new Patient();
        patientDomain.setId(patient.getId());
        patientDomain.setFullName(patient.getFullName());
        patientDomain.setAge(patient.getAge());
        patientDomain.setEmail(patient.getEmail());
        patientDomain.setAddress(patient.getAddress());
        patientDomain.setPhone(patient.getPhone());
        
        PatientEntity entity = PatientMapper.toEntity(patientDomain);
        patientRepository.save(entity);
    }
}