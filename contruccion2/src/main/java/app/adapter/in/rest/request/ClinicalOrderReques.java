package app.adapter.in.rest.request;

	public class ClinicalOrderReques {
	    private String doctorId;
	    private String patientId;
	    private String orderType;
	    
	    public ClinicalOrderReques() {}
	    
	    public String getDoctorId() { return doctorId; }
	    public void setDoctorId(String doctorId) { this.doctorId = doctorId; }
	    
	    public String getPatientId() { return patientId; }
	    public void setPatientId(String patientId) { this.patientId = patientId; }
	    
	    public String getOrderType() { return orderType; }
	    public void setOrderType(String orderType) { this.orderType = orderType; }
	}

