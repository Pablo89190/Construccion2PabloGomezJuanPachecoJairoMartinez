package app.adapter.in.rest.request;

public class NurseAttentionRequest {
    private String patientId;
    private String reason;
    private String symptoms;
    private String bloodPressure;
    private String temperature;
    private String pulserate;
    private String bloodOxygenLevel;
    
    public NurseAttentionRequest() {}
    
    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }
    
    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }
    
    public String getSymptoms() { return symptoms; }
    public void setSymptoms(String symptoms) { this.symptoms = symptoms; }
    
    public String getBloodPressure() { return bloodPressure; }
    public void setBloodPressure(String bloodPressure) { this.bloodPressure = bloodPressure; }
    
    public String getTemperature() { return temperature; }
    public void setTemperature(String temperature) { this.temperature = temperature; }
    
    public String getPulserate() { return pulserate; }
    public void setPulserate(String pulserate) { this.pulserate = pulserate; }
    
    public String getBloodOxygenLevel() { return bloodOxygenLevel; }
    public void setBloodOxygenLevel(String bloodOxygenLevel) { this.bloodOxygenLevel = bloodOxygenLevel; }
}