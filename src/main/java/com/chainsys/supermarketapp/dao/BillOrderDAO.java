package com.chainsys.supermarketapp.dao;

import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.model.Order;

public interface BillOrderDAO {
	int addBillOrder(Order billorder)throws DbException;
	void displayBillOrder(Order billorder)throws DbException;
	void updateBillOrder(Order billorder)throws DbException;
	void deleteBillOrder(Order billorder)throws DbException;

}
