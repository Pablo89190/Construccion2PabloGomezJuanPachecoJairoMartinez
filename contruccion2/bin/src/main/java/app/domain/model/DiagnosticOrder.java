package app.domain.model;

import app.domain.model.emuns.DiagnosticExam;

public class DiagnosticOrder extends ClinicalOrder {
    private DiagnosticExam exam;  
    private int quantity;        
    private double cost;          

   
    public DiagnosticExam getExam() {
        return exam;
    }

    public void setExam(DiagnosticExam exam) {
        this.exam = exam;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
