package project.model;

public class customerCard {
	private String customername;
	private long contactnumber;
	private String address;
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public long getContactnumber() {
		return contactnumber;
	}
	public void setContactnumber(long contactnumber) {
		this.contactnumber = contactnumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "customerCard [customername=" + customername + ", contactnumber=" + contactnumber + ", address=" + address
				+ "]";
	}

}
