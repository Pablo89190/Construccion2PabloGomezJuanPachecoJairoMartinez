package app.adapter.in.rest.request;

public class MedicineRequest {
    private String medicineId;
    private String name;
    private String doce;
    private String duration;
    private String cost;
    
    public MedicineRequest() {}
    
    public String getMedicineId() { return medicineId; }
    public void setMedicineId(String medicineId) { this.medicineId = medicineId; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getDoce() { return doce; }
    public void setDoce(String doce) { this.doce = doce; }
    
    public String getDuration() { return duration; }
    public void setDuration(String duration) { this.duration = duration; }
    
    public String getCost() { return cost; }
    public void setCost(String cost) { this.cost = cost; }
}