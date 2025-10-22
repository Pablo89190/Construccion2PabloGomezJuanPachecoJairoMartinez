package app.adapter.in.rest.request;

public class NurseRequest {
class VitalDataRequest {
    private String bloodPressure;
    private String temperature;
    private String pulserate;
    private String bloodOxygenLevel;
    
    public VitalDataRequest() {}
    
    public String getBloodPressure() { return bloodPressure; }
    public void setBloodPressure(String bloodPressure) { this.bloodPressure = bloodPressure; }
    
    public String getTemperature() { return temperature; }
    public void setTemperature(String temperature) { this.temperature = temperature; }
    
    public String getPulserate() { return pulserate; }
    public void setPulserate(String pulserate) { this.pulserate = pulserate; }
    
    public String getBloodOxygenLevel() { return bloodOxygenLevel; }
    public void setBloodOxygenLevel(String bloodOxygenLevel) { this.bloodOxygenLevel = bloodOxygenLevel; }
}

class NurseAttentionRequest {
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

class ProcedureRequest {
    private String name;
    private String times;
    private String frequency;
    private String cost;
    
    public ProcedureRequest() {}
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getTimes() { return times; }
    public void setTimes(String times) { this.times = times; }
    
    public String getFrequency() { return frequency; }
    public void setFrequency(String frequency) { this.frequency = frequency; }
    
    public String getCost() { return cost; }
    public void setCost(String cost) { this.cost = cost; }
}
}