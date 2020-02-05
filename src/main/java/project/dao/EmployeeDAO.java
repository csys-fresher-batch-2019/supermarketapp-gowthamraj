package project.dao;

import project.model.Employee;

public interface EmployeeDAO {
	void addEmployeeDetils(Employee employee) throws Exception;
	void displayEmployeeDetils(Employee employee) throws Exception;
	void deleteEmployeeDetils(Employee employee) throws Exception;
	void updateEmployeeDetils(Employee employee) throws Exception;

}
