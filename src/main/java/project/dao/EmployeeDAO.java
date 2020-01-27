package project.dao;

import project.model.Employee;

public interface EmployeeDAO {
	void addEmployeeDetils(Employee employee) throws Exception;
	void DisplayEmployeeDetils(Employee employee) throws Exception;
	void DeleteEmployeeDetils(Employee employee) throws Exception;
	void UpdateEmployeeDetils(Employee employee) throws Exception;

}
