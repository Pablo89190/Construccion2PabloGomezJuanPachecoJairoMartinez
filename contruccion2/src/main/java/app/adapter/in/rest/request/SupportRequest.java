package app.adapter.in.rest.request;

public class SupportRequest {
	class MedicineRequest {
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

	
	class ProcedureDetailRequest {
	    private String name;
	    private String times;
	    private String frequency;
	    private String requiresSpecialist;
	    private String specialty; 
	    private String cost;
	    
	    public ProcedureDetailRequest() {}
	    
	    public String getName() { return name; }
	    public void setName(String name) { this.name = name; }
	    
	    public String getTimes() { return times; }
	    public void setTimes(String times) { this.times = times; }
	    
	    public String getFrequency() { return frequency; }
	    public void setFrequency(String frequency) { this.frequency = frequency; }
	    
	    public String getRequiresSpecialist() { return requiresSpecialist; }
	    public void setRequiresSpecialist(String requiresSpecialist) { 
	        this.requiresSpecialist = requiresSpecialist; 
	    }
	    
	    public String getSpecialty() { return specialty; }
	    public void setSpecialty(String specialty) { this.specialty = specialty; }
	    
	    public String getCost() { return cost; }
	    public void setCost(String cost) { this.cost = cost; }
	}

}
