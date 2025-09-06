package app.domain.model;

public class Insurance extends Patient {
    private String insuranceCompany;
    private String policyNumber;      
    private String validity;
    private String policyEndDate;
    
    
    public String getPolicyEndDate() {
		return policyEndDate;
	}

	public void setPolicyEndDate(String policyEndDate) {
		this.policyEndDate = policyEndDate;
	}

	public Insurance () {}
    
	public String getCompany() {
		return insuranceCompany;
	}
	public void setCompany(String company) {
		this.insuranceCompany = company;
	}
	public String getPolicyNumber() {
		return policyNumber;
	}
	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}
	public String getValidity() {
		return validity;
	}
	public void setValidity(String validity) {
		this.validity = validity;
	
	}
}

