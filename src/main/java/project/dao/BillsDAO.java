package project.dao;

import exception.DbException;
import project.model.OrderItem;

public interface BillsDAO {
	public void addBills(OrderItem bills) throws DbException;
	public void deleteBills(OrderItem bills)throws DbException;
	public void displayBills(OrderItem bills)throws DbException;
	public void updateBills(OrderItem bills)throws DbException;
	
}
