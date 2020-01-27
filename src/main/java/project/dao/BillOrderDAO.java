package project.dao;

import project.model.Billorder;

public interface BillOrderDAO {
	void addBillOrder(Billorder billorder)throws Exception;
	void displayBillOrder(Billorder billorder)throws Exception;
	void updateBillOrder(Billorder billorder)throws Exception;
	void deleteBillOrder(Billorder billorder)throws Exception;

}
