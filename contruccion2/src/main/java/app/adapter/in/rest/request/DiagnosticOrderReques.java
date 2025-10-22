package app.adapter.in.rest.request;

public class DiagnosticOrderReques {
	private String doctorId;
    private String patientId;
    private String examType;
    private String quantity;
    private String cost;
    
    public DiagnosticOrderReques() {}
    
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
