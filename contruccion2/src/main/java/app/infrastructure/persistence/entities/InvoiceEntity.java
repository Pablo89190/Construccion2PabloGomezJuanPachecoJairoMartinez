package app.infrastructure.persistence.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "invoices")
public class InvoiceEntity {

    @Id
    @Column(length = 50)
    private String invoiceId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id", nullable = false)
    private PatientEntity patient;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doctor_id")
    private UserEntity doctor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "clinical_order_id")
    private ClinicalOrderEntity clinicalOrder;

    @OneToMany(mappedBy = "invoice", fetch = FetchType.LAZY)
    private List<InvoiceDetailEntity> details;

    @Column(nullable = false)
    private double total;

    @Column(nullable = false)
    private boolean isMedicine;

    // Constructors
    public InvoiceEntity() {}

    // Getters and Setters
    public String getInvoiceId() { return invoiceId; }
    public void setInvoiceId(String invoiceId) { this.invoiceId = invoiceId; }

    public PatientEntity getPatient() { return patient; }
    public void setPatient(PatientEntity patient) { this.patient = patient; }

    public UserEntity getDoctor() { return doctor; }
    public void setDoctor(UserEntity doctor) { this.doctor = doctor; }

    public ClinicalOrderEntity getClinicalOrder() { return clinicalOrder; }
    public void setClinicalOrder(ClinicalOrderEntity clinicalOrder) { this.clinicalOrder = clinicalOrder; }

    public List<InvoiceDetailEntity> getDetails() { return details; }
    public void setDetails(List<InvoiceDetailEntity> details) { this.details = details; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    public boolean isMedicine() { return isMedicine; }
    public void setMedicine(boolean medicine) { isMedicine = medicine; }
}