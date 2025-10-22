package app.adapter.in.rest.request;


public class ClinicalRecordRequest {
    private String patientId;
    private String doctorId;
    private String clinicalOrderId;
    
    public ClinicalRecordRequest() {}
    
    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }
    
    public String getDoctorId() { return doctorId; }
    public void setDoctorId(String doctorId) { this.doctorId = doctorId; }
    
    public String getClinicalOrderId() { return clinicalOrderId; }
    public void setClinicalOrderId(String clinicalOrderId) { this.clinicalOrderId = clinicalOrderId; }
}

class ClinicalOrderRequest {
    private String doctorId;
    private String patientId;
    private String orderType; 
    
    public ClinicalOrderRequest() {}
    
    public String getDoctorId() { return doctorId; }
    public void setDoctorId(String doctorId) { this.doctorId = doctorId; }
    
    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }
    
    public String getOrderType() { return orderType; }
    public void setOrderType(String orderType) { this.orderType = orderType; }
}

class DiagnosticOrderRequest {
    private String doctorId;
    private String patientId;
    private String examType; 
    private String quantity;
    private String cost;
    
    public DiagnosticOrderRequest() {}
    
    public String getDoctorId() { return doctorId; }
    public void setDoctorId(String doctorId) { this.doctorId = doctorId; }
    
    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }
    
    public String getExamType() { return examType; }
    public void setExamType(String examType) { this.examType = examType; }
    
    public String getQuantity() { return quantity; }
    public void setQuantity(String quantity) { this.quantity = quantity; }
    
    public String getCost() { return cost; }
    public void setCost(String cost) { this.cost = cost; }
}


class RegistrationAttentionRequest {
    private String patientId;
    private String doctorId;
    private String reason;
    private String symptoms;
    private String diagnosis;
    
    public RegistrationAttentionRequest() {}
    
    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }
    
    public String getDoctorId() { return doctorId; }
    public void setDoctorId(String doctorId) { this.doctorId = doctorId; }
    
    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }
    
    public String getSymptoms() { return symptoms; }
    public void setSymptoms(String symptoms) { this.symptoms = symptoms; }
    
    public String getDiagnosis() { return diagnosis; }
    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }
}
