package app.infrastructure.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "diagnostic_orders")
public class DiagnosticOrderEntity extends ClinicalOrderEntity {

    @Column(nullable = false, length = 50)
    private String exam;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private double cost;

    // Constructors
    public DiagnosticOrderEntity() {
        super();
    }

    // Getters and Setters
    public String getExam() { return exam; }
    public void setExam(String exam) { this.exam = exam; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getCost() { return cost; }
    public void setCost(double cost) { this.cost = cost; }
}