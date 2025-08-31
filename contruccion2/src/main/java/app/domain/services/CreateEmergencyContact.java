package app.domain.services;

import app.domain.model.EmergencyContact;
import app.domain.ports.EmergencyContactPort;

public class CreateEmergencyContact {

    private final EmergencyContactPort emergencyContactPort;


    public CreateEmergencyContact(EmergencyContactPort emergencyContactPort) {
        this.emergencyContactPort = emergencyContactPort;
    }
    
    public void registerEmergencyContact (String patientId, String firstName, String lastName, String relationship, String phone) {
        EmergencyContact contact = new EmergencyContact();
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setRelationship(relationship);
        contact.setPhone(phone);

   
        emergencyContactPort.saveEmergencyContact(patientId, contact);
    }
}