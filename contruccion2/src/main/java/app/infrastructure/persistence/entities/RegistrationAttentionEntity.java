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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "registration_attentions")
public class RegistrationAttentionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id", nullable = false)
    private PatientEntity patient;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doctor_id")
    private UserEntity doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clinical_record_id")
    private ClinicalRecordEntity clinicalRecord;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String reason;

    @Column(columnDefinition = "TEXT")
    private String symptoms;

    @Column(columnDefinition = "TEXT")
    private String diagnosis;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vital_data_id")
    private VitalDataEntity vitalData;

    @OneToMany(mappedBy = "registrationAttention", fetch = FetchType.LAZY)
    private List<ClinicalOrderEntity> orders;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    // Constructors
    public RegistrationAttentionEntity() {}

    // Getters and Setters
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public PatientEntity getPatient() { return patient; }
    public void setPatient(PatientEntity patient) { this.patient = patient; }

    public UserEntity getDoctor() { return doctor; }
    public void setDoctor(UserEntity doctor) { this.doctor = doctor; }

    public ClinicalRecordEntity getClinicalRecord() { return clinicalRecord; }
    public void setClinicalRecord(ClinicalRecordEntity clinicalRecord) { this.clinicalRecord = clinicalRecord; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }

    public String getSymptoms() { return symptoms; }
    public void setSymptoms(String symptoms) { this.symptoms = symptoms; }

    public String getDiagnosis() { return diagnosis; }
    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }

    public VitalDataEntity getVitalData() { return vitalData; }
    public void setVitalData(VitalDataEntity vitalData) { this.vitalData = vitalData; }

    public List<ClinicalOrderEntity> getOrders() { return orders; }
    public void setOrders(List<ClinicalOrderEntity> orders) { this.orders = orders; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}