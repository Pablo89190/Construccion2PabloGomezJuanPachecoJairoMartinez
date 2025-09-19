package app.infrastructure.persistence.entities;

import java.time.LocalDateTime;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "clinical_records")
public class ClinicalRecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 50)
    private String patientId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_entity_id", nullable = false)
    private PatientEntity patient;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doctor_id")
    private UserEntity doctor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "clinical_order_id")
    private ClinicalOrderEntity clinicalOrder;

    @OneToMany(mappedBy = "clinicalRecord", fetch = FetchType.LAZY)
    private List<RegistrationAttentionEntity> registrations;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    // Constructors
    public ClinicalRecordEntity() {}

    // Getters and Setters
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }

    public PatientEntity getPatient() { return patient; }
    public void setPatient(PatientEntity patient) { this.patient = patient; }

    public UserEntity getDoctor() { return doctor; }
    public void setDoctor(UserEntity doctor) { this.doctor = doctor; }

    public ClinicalOrderEntity getClinicalOrder() { return clinicalOrder; }
    public void setClinicalOrder(ClinicalOrderEntity clinicalOrder) { this.clinicalOrder = clinicalOrder; }

    public List<RegistrationAttentionEntity> getRegistrations() { return registrations; }
    public void setRegistrations(List<RegistrationAttentionEntity> registrations) { this.registrations = registrations; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}