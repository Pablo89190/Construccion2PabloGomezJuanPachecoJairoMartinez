package app.infrastructure.persistence.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "clinical_orders")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("CLINICAL_ORDER")
public class ClinicalOrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id", nullable = false)
    private PatientEntity patient;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doctor_id", nullable = false)
    private UserEntity doctor;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false, length = 50)
    private String orderType;

    @OneToMany(mappedBy = "clinicalOrder", fetch = FetchType.LAZY)
    private List<ItemOrderEntity> items;

    // ✅ CAMBIO: nullable=true (antes era false)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="registration_attention_id", nullable=true)
    private RegistrationAttentionEntity registrationAttention;

    // ✅ Campos para DiagnosticOrder
    @Column(nullable = true)
    private Double cost;

    @Column(nullable = true, length = 50)
    private String exam;

    @Column(nullable = true)
    private Integer quantity;

    // Constructors
    public ClinicalOrderEntity() {}

    // Getters y Setters
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public PatientEntity getPatient() { return patient; }
    public void setPatient(PatientEntity patient) { this.patient = patient; }

    public UserEntity getDoctor() { return doctor; }
    public void setDoctor(UserEntity doctor) { this.doctor = doctor; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public String getOrderType() { return orderType; }
    public void setOrderType(String orderType) { this.orderType = orderType; }

    public List<ItemOrderEntity> getItems() { return items; }
    public void setItems(List<ItemOrderEntity> items) { this.items = items; }

    public RegistrationAttentionEntity getRegistrationAttention() { return registrationAttention; }
    public void setRegistrationAttention(RegistrationAttentionEntity registrationAttention) {
        this.registrationAttention = registrationAttention;
    }

    public Double getCost() { return cost; }
    public void setCost(Double cost) { this.cost = cost; }

    public String getExam() { return exam; }
    public void setExam(String exam) { this.exam = exam; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
}