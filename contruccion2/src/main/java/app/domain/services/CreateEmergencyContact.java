package app.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.EmergencyContact;
import app.domain.ports.EmergencyContactPort;

@Service
public class CreateEmergencyContact {

	@Autowired
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

