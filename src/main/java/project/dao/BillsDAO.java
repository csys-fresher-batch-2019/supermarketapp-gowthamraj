package project.dao;

import project.model.OrderItem;

public interface BillsDAO {
	public void addBills(OrderItem bills) throws Exception;
	public void deleteBills(OrderItem bills)throws Exception;
	public void displayBills(OrderItem bills)throws Exception;
	public void updateBills(OrderItem bills)throws Exception;
	
}
