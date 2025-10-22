package app.adapter.in.rest.request;

public class ProcedureRequest {
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
