package project.dao;

import java.util.List;

import project.model.Billorder;

public interface BillOrderDAO2 {

	void addBillOrder(Billorder billorder)throws Exception;
	List<Billorder > Displaybills()throws Exception;
	void updateBillOrder(Billorder billorder)throws Exception;
	void deleteBillOrder(Billorder billorder)throws Exception;

}
