package app.domain.model;

import java.sql.Date;
import java.util.List;

import app.domain.model.emuns.OrderType;

public abstract class ClinicalOrder {
    private long id;                
    private Patient patient;       
    private User doctor;            
    private Date date;              
    private OrderType orderType;    
    
    private List<ItemOrder> items;
    
    public ClinicalOrder() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public User getDoctor() {
		return doctor;
	}

	public void setDoctor(User doctor) {
		this.doctor = doctor;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public OrderType getOrderType() {
		return orderType;
	}

	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
	}

	public List<ItemOrder> getItems() {
		return items;
	}

	public void setItems(List<ItemOrder> items) {
		this.items = items;
	}
    


   
}

