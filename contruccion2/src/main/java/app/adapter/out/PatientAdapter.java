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
        PatientEntity entity = patientRepository.findByDocument(id);
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
    public void save(User user) throws Exception {
        // Validar que el document no sea 0
        if (user.getId() == 0) {
            throw new Exception("El documento del paciente es requerido");
        }
        
        // Crear entidad con document
        PatientEntity entity = new PatientEntity();
        
        entity.setDocument(user.getId());  // ESTABLECER DOCUMENT
        entity.setFullName(user.getFullName());
        entity.setAge(user.getAge());
        entity.setEmail(user.getEmail());
        entity.setAddress(user.getAddress());
        entity.setPhone(user.getPhone());
        entity.setBirthDate(user.getBirthDate());
        
        // Guardar en la base de datos
        patientRepository.save(entity);
    }
}