package project.dao;
import java.util.List;
import project.model.Employee;

public interface EmployeeDAO2 {
	void addEmployeeDetails(Employee e) throws Exception;
	void deleteproductDetails(Employee e) throws Exception;
	List<Employee> DisplayEmployeeDetails()throws Exception;
	void updateproduct(Employee e) throws Exception;


}
