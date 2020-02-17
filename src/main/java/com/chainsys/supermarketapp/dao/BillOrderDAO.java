package com.chainsys.supermarketapp.dao;

import java.util.List;

import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.model.Order;

public interface BillOrderDAO {
	int addBillOrder(Order billorder)throws DbException;
	 List<Order>displayBillOrder() throws DbException;
	void updateBillOrder(Order billorder)throws DbException;
	void deleteBillOrder(Order billorder)throws DbException;

}
