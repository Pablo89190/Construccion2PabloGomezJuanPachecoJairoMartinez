package app.infrastructure.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "medicines")
public class MedicineEntity {

    @Id
    @Column(length = 50)
    private String medicineId;

    @Column(nullable = false, length = 200)
    private String name;

    @Column(nullable = false, length = 100)
    private String doce;

    @Column(nullable = false, length = 100)
    private String duration;

    @Column(nullable = false)
    private double cost;

    // Constructors
    public MedicineEntity() {}

    // Getters and Setters
    public String getMedicineId() { return medicineId; }
    public void setMedicineId(String medicineId) { this.medicineId = medicineId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDoce() { return doce; }
    public void setDoce(String doce) { this.doce = doce; }

    public String getDuration() { return duration; }
    public void setDuration(String duration) { this.duration = duration; }

    public double getCost() { return cost; }
    public void setCost(double cost) { this.cost = cost; }
}
