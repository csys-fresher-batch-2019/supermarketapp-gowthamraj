package project.model;

import java.time.LocalDate;

public class Bills {
	public int billno;
	public LocalDate billdate;
	public int customerno;
	public String customername;
	public int total;
	public String status;
	@Override
	public String toString() {
		return "bills [billno=" + billno + ", billdate=" + billdate + ", customerno=" + customerno + ", customername="
				+ customername + ", total=" + total + ", status=" + status + "]";
	}
}
