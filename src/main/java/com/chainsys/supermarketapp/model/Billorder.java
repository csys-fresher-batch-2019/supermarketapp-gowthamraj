package com.chainsys.supermarketapp.model;

public class Billorder {
	private int proid;
	private int productid;
	private int customerno;
	private float price;
	private int quantity;
	private int billItemId;
	private int billNo;
	public int getProid() {
		return proid;
	}
	public void setProid(int proid) {
		this.proid = proid;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public int getCustomerno() {
		return customerno;
	}
	public void setCustomerno(int customerno) {
		this.customerno = customerno;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getBillItemId() {
		return billItemId;
	}
	public void setBillItemId(int billItemId) {
		this.billItemId = billItemId;
	}
	public int getBillNo() {
		return billNo;
	}
	public void setBillNo(int billNo) {
		this.billNo = billNo;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	@Override
	public String toString() {
		return "Billorder [proid=" + proid + ", productid=" + productid + ", customerno=" + customerno + ", price="
				+ price + ", quantity=" + quantity + ", billItemId=" + billItemId + ", billNo=" + billNo
				+ ", totalAmount=" + totalAmount + "]";
	}
	private int totalAmount;
}