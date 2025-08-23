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
		// TODO Auto-generated method stub
		
	}

	public void setClinicalOrder(ClinicalOrder clinicalOrder) {
		// TODO Auto-generated method stub
		
	}

	public void setPatient(Patient patient) {
		// TODO Auto-generated method stub
		
	}

	public User getDoctor() {
		// TODO Auto-generated method stub
		return null;
	}

	public Patient getPatient() {
		// TODO Auto-generated method stub
		return null;
	}

	public ClinicalOrder getClinicalOrder() {
		// TODO Auto-generated method stub
		return null;
	}
}


