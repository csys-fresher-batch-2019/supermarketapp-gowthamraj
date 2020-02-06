package project.dao;

import exception.DbException;
import project.model.Employee;

public interface EmployeeDAO {
	void addEmployeeDetils(Employee employee) throws DbException;
	void displayEmployeeDetils(Employee employee) throws DbException;
	void deleteEmployeeDetils(Employee employee) throws DbException;
	void updateEmployeeDetils(Employee employee) throws DbException;

}
