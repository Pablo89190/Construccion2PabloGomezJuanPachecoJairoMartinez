package app.domain.model;
import java.util.List;

public class Invoice {
    private String invoiceId;
    private Patient patient;
    private User Doctor;
    private Insurance insurance;
    private List<InvoiceDetail> details;
    private double total;
    
    public Invoice () {}

	public String getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public User getDoctor() {
		return Doctor;
	}

	public void setDoctor(User doctor) {
		Doctor = doctor;
	}

	public Insurance getInsurance() {
		return insurance;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}

	public List<InvoiceDetail> getDetails() {
		return details;
	}

	public void setDetails(List<InvoiceDetail> details) {
		this.details = details;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public void setOrder(ClinicalOrder clinicalOrder) {
		// TODO Auto-generated method stub
		
	}

	public ClinicalOrder getOrder() {
		// TODO Auto-generated method stub
		return null;
	}
    
	
    
}