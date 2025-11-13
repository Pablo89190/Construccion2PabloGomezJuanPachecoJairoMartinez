package app.domain.model;

import java.util.Map;

public class ClinicalRecord {
    private String patientId;
    private Patient patient;
    private User doctor;
    private ClinicalOrder clinicalOrder;
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

    public void setDoctor(User doctor) {
        this.doctor = doctor;
    }

    public void setClinicalOrder(ClinicalOrder clinicalOrder) {
        this.clinicalOrder = clinicalOrder;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public User getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public ClinicalOrder getClinicalOrder() {
        return clinicalOrder;
    }
}