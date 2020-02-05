package project.model;

public class CustomerBill {

	private String customerName;
	
	private int totalAmount;

	@Override
	public String toString() {
		return "CustomerBill [customerName=" + customerName + ", totalAmount=" + totalAmount + "]";
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
}
