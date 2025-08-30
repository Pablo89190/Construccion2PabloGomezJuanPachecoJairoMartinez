package app.domain.model;

public class ItemOrder {
	
	private String itemNumber;
	private String description;
	
	public ItemOrder() {}
	
	public String getItemNumber() {
		return itemNumber;
	}
	public void setItemNumber(String itemNumber) {
		this.itemNumber = itemNumber;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
