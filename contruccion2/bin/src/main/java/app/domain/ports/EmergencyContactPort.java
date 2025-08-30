package app.domain.ports;

import app.domain.model.EmergencyContact;

public interface EmergencyContactPort {

  
    void saveEmergencyContact(String patientId, EmergencyContact contact);

    EmergencyContact findEmergencyContactByPatient(String patientId);

    void updateEmergencyContact(String patientId, EmergencyContact updatedContact);

    void deleteEmergencyContact(String patientId);
}
