package app.adapter.in.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;

import app.adapter.in.validators.PatientValidator;
import app.adapter.in.validators.UserValidator;
import app.domain.model.Patient;
import app.domain.model.RegistrationAttention;
import app.domain.model.User;
import app.domain.model.VitalData;
import app.domain.model.ClinicalOrder;

@Component
public class RegistrationAttentionBuilder {
    
    @Autowired
    private PatientValidator patientValidator;
    
    @Autowired
    private UserValidator userValidator;

    public RegistrationAttention build(String patientId, String doctorId, String reason, 
                                     String symptoms, String diagnosis) throws Exception {
        RegistrationAttention attention = new RegistrationAttention();
        
  
        Patient patient = new Patient();
        patient.setId(patientValidator.idValidator(patientId));
        attention.setPatient(patient);
        
  
        User doctor = new User();
        doctor.setId(userValidator.idValidator(doctorId));
        attention.setDoctor(doctor);
        
        
        attention.setReason(userValidator.nameValidator(reason));
        attention.setSymptoms(userValidator.nameValidator(symptoms));
        attention.setDiagnosis(userValidator.nameValidator(diagnosis));
        
        attention.setId(System.currentTimeMillis());
        attention.setOrders(new ArrayList<ClinicalOrder>());
        
        return attention;
    }
    
    public RegistrationAttention buildNurseAttention(String patientId, String reason, String symptoms) throws Exception {
        RegistrationAttention attention = new RegistrationAttention();
        
        Patient patient = new Patient();
        patient.setId(patientValidator.idValidator(patientId));
        attention.setPatient(patient);
        
        attention.setReason(userValidator.nameValidator(reason));
        attention.setSymptoms(userValidator.nameValidator(symptoms));
        attention.setDiagnosis("PENDIENTE EVALUACIÓN MÉDICA");
        
        attention.setId(System.currentTimeMillis());
        attention.setOrders(new ArrayList<ClinicalOrder>());
        
        return attention;
    }
}
