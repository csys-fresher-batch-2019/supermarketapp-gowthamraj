package com.chainsys.supermarketapp.model;

import java.time.LocalDate;

public class Employee {
	private int employeeid;
	private String employeename;
	private LocalDate dob;
	private LocalDate doj;
	private int mobileno;
	private String address;
	
	public int getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public LocalDate getDoj() {
		return doj;
	}

	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}

	public int getMobileno() {
		return mobileno;
	}

	public void setMobileno(int mobileno) {
		this.mobileno = mobileno;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "employee [employeeid=" + employeeid + ", employeename=" + employeename + ", dob=" + dob + ", doj=" + doj
				+ ", mobileno=" + mobileno + ", address=" + address + "]";
	}
}

