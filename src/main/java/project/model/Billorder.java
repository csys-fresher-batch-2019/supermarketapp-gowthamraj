package project.model;

public class Billorder {
	public int proid;
	public int productid;
	public int customerno;
	public float price;
	public int quantity;
	@Override
	public String toString() {
		return "billorder [proid=" + proid + ", productid=" + productid + ", customerno=" + customerno + ", price="
				+ price + ", quantity=" + quantity + "]";
	}
		

}
