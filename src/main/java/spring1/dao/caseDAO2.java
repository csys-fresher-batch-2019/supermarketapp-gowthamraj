package spring1.dao;

import java.time.LocalDate;
import java.util.List;
import project.model.OrderItem;
import project.model.Employee;
public interface caseDAO2 {
	public int employeeCount(Employee employee) throws Exception;
	public int totalIncome(OrderItem bills)throws Exception;
	public int todayIncome(LocalDate date)throws Exception;
	
	public List<OrderItem> customerCount(OrderItem bills) throws Exception;
}