package project.model;

import java.time.LocalDate;

public class ProductStock {
	public int productno;
	public int stockid;
	public int quantity;
	public LocalDate productarrival;
	public LocalDate experydate;
	@Override
	public String toString() {
		return "productStock [productno=" + productno + ", stockid=" + stockid + ", quantity=" + quantity
				+ ", productarrival=" + productarrival + ", experydate=" + experydate + "]";
	}

}
