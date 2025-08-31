package app.domain.model;

import java.util.List;

public class RegistrationAttention {
    private long id;
    private Patient patient;    
    private User doctor;        
    private String reason;
    private String symptoms;
    private String diagnosis;
    private VitalData vitalData;
    private List<ClinicalOrder> orders;

    public RegistrationAttention() {}

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public User getDoctor() {
        return doctor;
    }
    public void setDoctor(User doctor) {
        this.doctor = doctor;
    }

    public String getReason() {
        return reason;
    }
    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getSymptoms() {
        return symptoms;
    }
    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getDiagnosis() {
        return diagnosis;
    }
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public VitalData getVitalData() {
        return vitalData;
    }
    public void setVitalData(VitalData vitalData) {
        this.vitalData = vitalData;
    }

    public List<ClinicalOrder> getOrders() {
        return orders;
    }
    public void setOrders(List<ClinicalOrder> orders) {
        this.orders = orders;
    }
}