package app.infrastructure.persistence.entities;

import app.domain.model.EmergencyContact;
import app.domain.model.emuns.Gender;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "patients")
public class PatientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String fullName;

    @Column(unique = true, nullable = false)  // NO NULLABLE - REQUERIDO
    private Long document;

    @Column(nullable = false)
    private int age;

    @Column(length = 200)
    private String address;

    @Column(length = 20)
    private String phone;

    @Column(length = 100)
    private String email;

    @Column(length = 20)
    private String birthDate;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Gender gender;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "firstName", column = @Column(name = "emergency_first_name", length = 50)),
        @AttributeOverride(name = "lastName", column = @Column(name = "emergency_last_name", length = 50)),
        @AttributeOverride(name = "relationship", column = @Column(name = "emergency_relationship", length = 50)),
        @AttributeOverride(name = "phone", column = @Column(name = "emergency_phone", length = 20))
    })
    private EmergencyContact emergencyContact;

    @Column(name = "insurance_company", length = 100)
    private String insuranceCompany;

    @Column(name = "policy_number", length = 50)
    private String policyNumber;

    @Column(name = "policy_status", length = 20)
    private String policyStatus;

    @Column(name = "policy_end_date", length = 20)
    private String policyEndDate;

    // Constructores
    public PatientEntity() {}

    // Getters y Setters
    public Long getId() { 
        return id; 
    }
    
    public void setId(Long id) { 
        this.id = id; 
    }

    public String getFullName() { 
        return fullName; 
    }
    
    public void setFullName(String fullName) { 
        this.fullName = fullName; 
    }

    public Long getDocument() { 
        return document; 
    }
    
    public void setDocument(Long document) { 
        this.document = document; 
    }

    public int getAge() { 
        return age; 
    }
    
    public void setAge(int age) { 
        this.age = age; 
    }

    public String getAddress() { 
        return address; 
    }
    
    public void setAddress(String address) { 
        this.address = address; 
    }

    public String getPhone() { 
        return phone; 
    }
    
    public void setPhone(String phone) { 
        this.phone = phone; 
    }

    public String getEmail() { 
        return email; 
    }
    
    public void setEmail(String email) { 
        this.email = email; 
    }

    public String getBirthDate() { 
        return birthDate; 
    }
    
    public void setBirthDate(String birthDate) { 
        this.birthDate = birthDate; 
    }

    public Gender getGender() { 
        return gender; 
    }
    
    public void setGender(Gender gender) { 
        this.gender = gender; 
    }

    public EmergencyContact getEmergencyContact() { 
        return emergencyContact; 
    }
    
    public void setEmergencyContact(EmergencyContact emergencyContact) {
        this.emergencyContact = emergencyContact;
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

    public String getPolicyStatus() {
        return policyStatus;
    }

    public void setPolicyStatus(String policyStatus) {
        this.policyStatus = policyStatus;
    }

    public String getPolicyEndDate() {
        return policyEndDate;
    }

    public void setPolicyEndDate(String policyEndDate) {
        this.policyEndDate = policyEndDate;
    }
}