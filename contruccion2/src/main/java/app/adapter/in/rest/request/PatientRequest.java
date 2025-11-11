package app.adapter.in.rest.request;

public class PatientRequest {
    private String document;  // AGREGAR ESTE CAMPO
    private String gender;
    private String fullName;
    private String address;
    private String phoneNumber;
    private String email;
    private String age;
    private String emergencyContactName;
    private String relationship;
    private String emergencyPhoneNumber;
    private String insuranceCompany;
    private String policyNumber;
    private String policyStatus;
    private String policyEndDate;
    
    public PatientRequest() {}
    
    // AGREGAR getter y setter para document
    public String getDocument() { return document; }
    public void setDocument(String document) { this.document = document; }
    
    // Resto de getters y setters...
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getAge() { return age; }
    public void setAge(String age) { this.age = age; }
    
    public String getEmergencyContactName() { return emergencyContactName; }
    public void setEmergencyContactName(String emergencyContactName) { 
        this.emergencyContactName = emergencyContactName; 
    }
    
    public String getRelationship() { return relationship; }
    public void setRelationship(String relationship) { this.relationship = relationship; }
    
    public String getEmergencyPhoneNumber() { return emergencyPhoneNumber; }
    public void setEmergencyPhoneNumber(String emergencyPhoneNumber) { 
        this.emergencyPhoneNumber = emergencyPhoneNumber; 
    }
    
    public String getInsuranceCompany() { return insuranceCompany; }
    public void setInsuranceCompany(String insuranceCompany) { 
        this.insuranceCompany = insuranceCompany; 
    }
    
    public String getPolicyNumber() { return policyNumber; }
    public void setPolicyNumber(String policyNumber) { this.policyNumber = policyNumber; }
    
    public String getPolicyStatus() { return policyStatus; }
    public void setPolicyStatus(String policyStatus) { this.policyStatus = policyStatus; }
    
    public String getPolicyEndDate() { return policyEndDate; }
    public void setPolicyEndDate(String policyEndDate) { this.policyEndDate = policyEndDate; }
}