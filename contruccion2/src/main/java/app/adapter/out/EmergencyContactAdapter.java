package app.adapter.out;

import org.springframework.stereotype.Service;

import app.domain.model.EmergencyContact;
import app.domain.ports.EmergencyContactPort;

@Service
public class EmergencyContactAdapter implements EmergencyContactPort {

    @Override
    public void saveEmergencyContact(String patientId, EmergencyContact contact) {
        // Implementación básica - normalmente se integraría con PatientAdapter
        System.out.println("Guardando contacto de emergencia para paciente: " + patientId);
    }

    @Override
    public EmergencyContact findEmergencyContactByPatient(String patientId) {
        // Implementación básica
        return new EmergencyContact();
    }

    @Override
    public void updateEmergencyContact(String patientId, EmergencyContact updatedContact) {
        System.out.println("Actualizando contacto de emergencia para paciente: " + patientId);
    }

    @Override
    public void deleteEmergencyContact(String patientId) {
        System.out.println("Eliminando contacto de emergencia para paciente: " + patientId);
    }
}