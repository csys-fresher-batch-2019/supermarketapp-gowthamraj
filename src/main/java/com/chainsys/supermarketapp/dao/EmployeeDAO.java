package com.chainsys.supermarketapp.dao;

import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.model.Employee;

public interface EmployeeDAO {
	void addEmployeeDetils(Employee employee) throws DbException;
	void displayEmployeeDetils(Employee employee) throws DbException;
	void deleteEmployeeDetils(Employee employee) throws DbException;
	void updateEmployeeDetils(Employee employee) throws DbException;

}
