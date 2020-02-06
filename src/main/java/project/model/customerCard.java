package project.model;

public class CustomerCard {
	private String customerName;
	private long contactNumber;
	private String address;
	public String getCustomername() {
		return customerName;
	}
	public void setCustomername(String customername) {
		this.customerName = customername;
	}
	public long getContactnumber() {
		return contactNumber;
	}
	public void setContactnumber(long contactnumber) {
		this.contactNumber = contactnumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "customerCard [customername=" + customerName + ", contactnumber=" + contactNumber + ", address=" + address
				+ "]";
	}

}
