package project.dao;

import java.util.List;

import project.model.Bills;



public interface BillsDAO2 {
	void addbills(Bills bills) throws Exception;
	void deletebills(Bills bills) throws Exception;
	List<Bills > Displaybills()throws Exception;
	void updatebills(Bills bills) throws Exception;


}
