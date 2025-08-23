package app.domain.model;


import java.util.List;

public class RegistrationAttention {
    private String doctorId;          
    private String reason;            
    private String symptoms;          
    private String diagnosis;         
    
    private List<ClinicalOrder> orders;  
    
    public RegistrationAttention() {}

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
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

    public List<ClinicalOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<ClinicalOrder> orders) {
        this.orders = orders;
    }
}
