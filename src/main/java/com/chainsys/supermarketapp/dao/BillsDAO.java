package com.chainsys.supermarketapp.dao;

import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.model.OrderItem;

public interface BillsDAO {
	public void addBills(OrderItem bills) throws DbException;
	public void deleteBills(OrderItem bills)throws DbException;
	public void displayBills(OrderItem bills)throws DbException;
	public void updateBills(OrderItem bills)throws DbException;
	
}
