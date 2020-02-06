package project.dao;

import java.time.LocalDate;
import java.util.List;

import exception.DbException;
import project.model.OrderItem;
import project.model.Employee;
import project.model.Product;

public interface CaseDAO {
	public int employeeCount(Employee employee) throws DbException;
	public int totalIncome(OrderItem bills)throws DbException;
	public int todayIncome(LocalDate date)throws DbException;
	public List<Product> productPriceBetween(int min, int max) throws DbException;
	public List<OrderItem> customerCount(OrderItem bills) throws DbException;
	
}
