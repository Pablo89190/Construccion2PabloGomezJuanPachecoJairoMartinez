package app.adapter.in.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

import app.adapter.in.validators.PatientValidator;
import app.adapter.in.validators.UserValidator;
import app.domain.model.ClinicalRecord;
import app.domain.model.Patient;
import app.domain.model.User;
import app.domain.model.ClinicalOrder;
import app.domain.model.RegistrationAttention;

@Component
public class ClinicalRecordBuilder {
    
    @Autowired
    private PatientValidator patientValidator;
    
    @Autowired
    private UserValidator userValidator;


    public ClinicalRecord build(String patientId, String doctorId, String clinicalOrderId) throws Exception {
        ClinicalRecord clinicalRecord = new ClinicalRecord();
        
        
        clinicalRecord.setPatientId(patientValidator.idValidator(patientId) + "");
        
       
        User doctor = new User();
        doctor.setId(userValidator.idValidator(doctorId));
        clinicalRecord.setDoctor(doctor);
        
   
        Patient patient = new Patient();
        patient.setId(patientValidator.idValidator(patientId));
        clinicalRecord.setPatient(patient);
        
        
        ClinicalOrder clinicalOrder = new ClinicalOrder() {}; 
        clinicalOrder.setId(Long.parseLong(clinicalOrderId));
        clinicalRecord.setClinicalOrder(clinicalOrder);
        

        clinicalRecord.setRecords(new HashMap<String, RegistrationAttention>());
        
        return clinicalRecord;
    }
    
  
    public ClinicalRecord buildBasic(String patientId) throws Exception {
        ClinicalRecord clinicalRecord = new ClinicalRecord();
        
        clinicalRecord.setPatientId(patientValidator.idValidator(patientId) + "");
        
    
        Patient patient = new Patient();
        patient.setId(patientValidator.idValidator(patientId));
        clinicalRecord.setPatient(patient);
        

        clinicalRecord.setRecords(new HashMap<String, RegistrationAttention>());
        
        return clinicalRecord;
    }
    

    public ClinicalRecord buildWithRecords(String patientId, Map<String, RegistrationAttention> records) throws Exception {
        ClinicalRecord clinicalRecord = buildBasic(patientId);
        
        if (records != null) {
            clinicalRecord.setRecords(records);
        }
        
        return clinicalRecord;
    }
    
 
    public ClinicalRecord buildForSearch(String patientId) throws Exception {
        ClinicalRecord clinicalRecord = new ClinicalRecord();
        
        clinicalRecord.setPatientId(patientValidator.idValidator(patientId) + "");
        
        return clinicalRecord;
    }
    

    public ClinicalRecord buildWithNewAttention(String patientId, String attentionKey, 
                                               RegistrationAttention attention) throws Exception {
        ClinicalRecord clinicalRecord = buildBasic(patientId);
        
        Map<String, RegistrationAttention> records = new HashMap<>();
        records.put(attentionKey, attention);
        clinicalRecord.setRecords(records);
        
        return clinicalRecord;
    }
}
