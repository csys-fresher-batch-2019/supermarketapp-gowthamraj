package project.dao;

import project.model.Order;

public interface BillOrderDAO {
	void addBillOrder(Order billorder)throws Exception;
	void displayBillOrder(Order billorder)throws Exception;
	void updateBillOrder(Order billorder)throws Exception;
	void deleteBillOrder(Order billorder)throws Exception;

}
