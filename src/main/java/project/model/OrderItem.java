package project.model;

import java.time.LocalDate;

public class OrderItem {
	
	private int id;
	private String Customername;
	
	private int orderId;
	
	private int productId;
	
	private int quantity;
	
	private int Customerno;
	private 
	LocalDate Billdate;

	public String getCustomername() {
		return Customername;
	}

	public void setCustomername(String customername) {
		Customername = customername;
	}

	
	public LocalDate getBilldate() {
		return Billdate;
	}

	public void setBilldate(LocalDate billdate) {
		Billdate = billdate;
	}

	public int getCustomerno() {
		return Customerno;
	}

	public void setCustomerno(int customerno) {
		Customerno = customerno;
	}

	private String paymentStatus;
	
	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	private int price;
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	private int totalAmount;
	
	private String status;

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", Customername=" + Customername + ", orderId=" + orderId + ", productId="
				+ productId + ", quantity=" + quantity + ", Customerno=" + Customerno + ", Billdate=" + Billdate
				+ ", paymentStatus=" + paymentStatus + ", price=" + price + ", totalAmount=" + totalAmount + ", status="
				+ status + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
}
