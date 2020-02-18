package com.chainsys.supermarketapp.model;

public class Product {
	private int pid;
	private String productname;
	private int price;
	
	 
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [productid=" + pid + ", productname=" + productname + ", price=" + price + "]";
	}
}
