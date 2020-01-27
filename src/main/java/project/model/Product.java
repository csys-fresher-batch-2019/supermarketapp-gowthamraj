package project.model;

public class Product {
	public int pid;
	public String productname;
	public int price;
	@Override
	public String toString() {
		return "Product [productid=" + pid + ", productname=" + productname + ", price=" + price + "]";
	}
}
