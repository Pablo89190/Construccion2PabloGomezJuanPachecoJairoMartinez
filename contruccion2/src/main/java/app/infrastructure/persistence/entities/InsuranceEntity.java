package app.infrastructure.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "insurance")
public class InsuranceEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "patient_id", nullable = false)
    private String patientId;
    
    @Column(name = "insurance_company", nullable = false, length = 100)
    private String insuranceCompany;
    
    @Column(name = "policy_number", nullable = false, length = 50)
    private String policyNumber;
    
    @Column(name = "validity", length = 20)
    private String validity;
    
    @Column(name = "policy_end_date", length = 20)
    private String policyEndDate;
    
    // Constructores
    public InsuranceEntity() {}
    
    public InsuranceEntity(String patientId, String insuranceCompany, String policyNumber, 
                          String validity, String policyEndDate) {
        this.patientId = patientId;
        this.insuranceCompany = insuranceCompany;
        this.policyNumber = policyNumber;
        this.validity = validity;
        this.policyEndDate = policyEndDate;
    }
    
    // Getters y Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getPatientId() {
        return patientId;
    }
    
    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }
    
    public String getInsuranceCompany() {
        return insuranceCompany;
    }
    
    public void setInsuranceCompany(String insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
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
    
    public String getPolicyEndDate() {
        return policyEndDate;
    }
    
    public void setPolicyEndDate(String policyEndDate) {
        this.policyEndDate = policyEndDate;
    }
    
    @Override
    public String toString() {
        return "InsuranceEntity{" +
                "id=" + id +
                ", patientId='" + patientId + '\'' +
                ", insuranceCompany='" + insuranceCompany + '\'' +
                ", policyNumber='" + policyNumber + '\'' +
                ", validity='" + validity + '\'' +
                ", policyEndDate='" + policyEndDate + '\'' +
                '}';
    }
}