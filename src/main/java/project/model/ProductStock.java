package project.model;

import java.time.LocalDate;

public class ProductStock {
	private int productno;
	private int stockid;
	private int quantity;
	private LocalDate productarrival;
	private LocalDate experydate;
	public int getProductno() {
		return productno;
	}
	public void setProductno(int productno) {
		this.productno = productno;
	}
	public int getStockid() {
		return stockid;
	}
	public void setStockid(int stockid) {
		this.stockid = stockid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public LocalDate getProductarrival() {
		return productarrival;
	}
	public void setProductarrival(LocalDate productarrival) {
		this.productarrival = productarrival;
	}
	public LocalDate getExperydate() {
		return experydate;
	}
	public void setExperydate(LocalDate experydate) {
		this.experydate = experydate;
	}
	@Override
	public String toString() {
		return "productStock [productno=" + productno + ", stockid=" + stockid + ", quantity=" + quantity
				+ ", productarrival=" + productarrival + ", experydate=" + experydate + "]";
	}

}
