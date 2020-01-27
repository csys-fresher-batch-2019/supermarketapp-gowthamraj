package project.model;

import java.time.LocalDate;

public class Employee {
	public int employeeid;
	public String employeename;
	public LocalDate dob;
	public LocalDate doj;
	public int mobileno;
	public String address;
	
	@Override
	public String toString() {
		return "employee [employeeid=" + employeeid + ", employeename=" + employeename + ", dob=" + dob + ", doj=" + doj
				+ ", mobileno=" + mobileno + ", address=" + address + "]";
	}
}

