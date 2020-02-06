package project.dao;

import exception.DbException;
import project.model.Order;

public interface BillOrderDAO {
	void addBillOrder(Order billorder)throws DbException;
	void displayBillOrder(Order billorder)throws DbException;
	void updateBillOrder(Order billorder)throws DbException;
	void deleteBillOrder(Order billorder)throws DbException;

}
