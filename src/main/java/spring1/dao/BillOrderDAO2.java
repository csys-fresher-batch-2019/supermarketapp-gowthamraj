package spring1.dao;

import java.util.List;

import project.model.Order;

public interface BillOrderDAO2 {

	void addBillOrder(Order billorder)throws Exception;
	List<Order > Displaybills()throws Exception;
	void updateBillOrder(Order billorder)throws Exception;
	void deleteBillOrder(Order billorder)throws Exception;

}
