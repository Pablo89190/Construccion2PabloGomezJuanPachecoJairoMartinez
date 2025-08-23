package app.domain.model;

import java.util.Map;

public class ClinicalRecord {
    private String patientId;
    private Map<String, RegistrationAttention> records; 
    
    public ClinicalRecord() {}
    
    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public Map<String, RegistrationAttention> getRecords() {
        return records;
    }

    public void setRecords(Map<String, RegistrationAttention> records) {
        this.records = records;
    }

	public void setDoctor(User doctor) {	
	}

	public void setClinicalOrder(ClinicalOrder clinicalOrder) {	
	}

	public void setPatient(Patient patient) {	
	}

	public User getDoctor() {
		return null;
	}

	public Patient getPatient() {
		return null;
	}

	public ClinicalOrder getClinicalOrder() {
		return null;
	}
}


