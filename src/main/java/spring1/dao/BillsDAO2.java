package spring1.dao;

import java.util.List;

import project.model.OrderItem;



public interface BillsDAO2 {
	void addbills(OrderItem bills) throws Exception;
	void deletebills(OrderItem bills) throws Exception;
	List<OrderItem > displaybills()throws Exception;
	void updatebills(OrderItem bills) throws Exception;


}
