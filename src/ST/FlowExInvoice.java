package ST;

public class FlowExInvoice {
	private String partNumber = new String();
	private String partDescription = new String();
	private int quantity = 0;
	private double price = 0;
	
	public FlowExInvoice(String partNumber, String partDescription,
			int quantity, double price) {
		this.partNumber = partNumber;
		this.partDescription = partDescription;
		this.quantity = quantity;
		this.price = price;
	}

	public String getPartNumber() {
		return partNumber;
	}
	
	public double getInvoiceAmount(){
		return price * quantity;
	}

	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}

	public String getPartDescription() {
		return partDescription;
	}

	public void setPartDescription(String partDescription) {
		this.partDescription = partDescription;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price > 0 ? price : 0;
	}
}
