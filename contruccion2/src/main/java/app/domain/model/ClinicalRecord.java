package app.domain.model;

import java.util.Map;

public class ClinicalRecord {
    private String patientId;
    private Map<String, RegistrationAttention> records; 
    
    public ClinicalRecord() {}
    
    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public Map<String, RegistrationAttention> getRecords() {
        return records;
    }

    public void setRecords(Map<String, RegistrationAttention> records) {
        this.records = records;
    }
}


