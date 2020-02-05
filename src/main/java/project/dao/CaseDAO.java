package project.dao;

import java.time.LocalDate;
import java.util.List;

import project.model.OrderItem;
import project.model.Employee;
import project.model.Product;

public interface CaseDAO {
	public int employeeCount(Employee employee) throws Exception;
	
	public  List<OrderItem> finalBills(OrderItem bills)throws Exception;
	public int totalIncome(OrderItem bills)throws Exception;
	public int todayIncome(LocalDate date)throws Exception;
	public List<Product> productPriceBetween(int min, int max) throws Exception;
	public List<OrderItem> customerCount(OrderItem bills) throws Exception;
}
