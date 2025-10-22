package app.adapter.in.rest.request;

public class VitalDataRequest {
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