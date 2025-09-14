package app.infrastructure.persistence.entities;

import app.domain.model.EmergencyContact;
import app.domain.model.Insurance;
import app.domain.model.emuns.Gender;
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
    private String name;

    @Column(unique = true, nullable = false)
    private Long document;

    @Column(nullable = false)
    private int age;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private Gender gender;

    @Embedded
    private EmergencyContact emergencyContact;

    @Embedded
    private Insurance insurance;

    // Getters y Setters

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Long getDocument() { return document; }

    public void setDocument(Long document) { this.document = document; }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }

    public Gender getGender() { return gender; }

    public void setGender(Gender gender) { this.gender = gender; }

    public EmergencyContact getEmergencyContact() { return emergencyContact; }

    public void setEmergencyContact(EmergencyContact emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public Insurance getInsurance() { return insurance; }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }
}

