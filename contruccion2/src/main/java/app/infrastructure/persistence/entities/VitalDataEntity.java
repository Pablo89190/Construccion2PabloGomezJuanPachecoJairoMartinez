package app.infrastructure.persistence.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "vital_data")
public class VitalDataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id")
    private PatientEntity patient;

    @Column(length = 50)
    private String bloodPressure;

    @Column(length = 50)
    private String temperature;

    @Column(length = 50)
    private String pulserate;

    @Column(length = 50)
    private String bloodOxygenLevel;

    @Column(nullable = false)
    private LocalDateTime recordedAt;

    // Constructors
    public VitalDataEntity() {}

    // Getters and Setters
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public PatientEntity getPatient() { return patient; }
    public void setPatient(PatientEntity patient) { this.patient = patient; }

    public String getBloodPressure() { return bloodPressure; }
    public void setBloodPressure(String bloodPressure) { this.bloodPressure = bloodPressure; }

    public String getTemperature() { return temperature; }
    public void setTemperature(String temperature) { this.temperature = temperature; }

    public String getPulserate() { return pulserate; }
    public void setPulserate(String pulserate) { this.pulserate = pulserate; }

    public String getBloodOxygenLevel() { return bloodOxygenLevel; }
    public void setBloodOxygenLevel(String bloodOxygenLevel) { this.bloodOxygenLevel = bloodOxygenLevel; }

    public LocalDateTime getRecordedAt() { return recordedAt; }
    public void setRecordedAt(LocalDateTime recordedAt) { this.recordedAt = recordedAt; }
}