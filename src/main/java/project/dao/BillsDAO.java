package project.dao;

import project.model.Bills;

public interface BillsDAO {
	public void addBills(Bills bills) throws Exception;
	public void deleteBills(Bills bills)throws Exception;
	public void displayBills(Bills bills)throws Exception;
	public void updateBills(Bills bills)throws Exception;
	
}
