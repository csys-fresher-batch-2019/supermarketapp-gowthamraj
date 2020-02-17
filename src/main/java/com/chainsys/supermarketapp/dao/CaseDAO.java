package com.chainsys.supermarketapp.dao;

import java.time.LocalDate;
import java.util.List;

import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.model.Employee;
import com.chainsys.supermarketapp.model.OrderItem;
import com.chainsys.supermarketapp.model.Product;

public interface CaseDAO {
	public int employeeCount() throws DbException;
	public int totalIncome(OrderItem bills)throws DbException;
	public int todayIncome(LocalDate date)throws DbException;
	public List<Product> productPriceBetween(int min, int max) throws DbException;
	public List<OrderItem> customerCount(OrderItem bills) throws DbException;
	
}
