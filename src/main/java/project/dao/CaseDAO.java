package project.dao;

import java.time.LocalDate;
import java.util.List;

import project.model.Bills;
import project.model.Employee;
import project.model.Product;

public interface CaseDAO {
	public int EmployeeCount(Employee employee) throws Exception;
	
	public  List<Bills> FinalBills(Bills bills)throws Exception;
	public int TotalIncome(Bills bills)throws Exception;
	public int TodayIncome(LocalDate date)throws Exception;
	public List<Product> ProductPriceBetween(int min, int max) throws Exception;
	public List<Bills> CustomerCount(Bills bills) throws Exception;
}
