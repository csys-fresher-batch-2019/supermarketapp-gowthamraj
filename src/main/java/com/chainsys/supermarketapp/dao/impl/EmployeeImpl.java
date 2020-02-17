package com.chainsys.supermarketapp.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.supermarketapp.dao.EmployeeDAO;
import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.exception.ErrorConstants;
import com.chainsys.supermarketapp.model.Employee;
import com.chainsys.supermarketapp.util.Logger;

public class EmployeeImpl implements EmployeeDAO {
	private static final Logger log=Logger.getInstance();
	
	
	@Override
	public void addEmployeeDetils(Employee employee) throws DbException {
		String sql="insert into employee(employee_id,employee_name,dob,doj,address) values( emp_idd.nextval,?,?,?,?)";
		try(Connection con= ConnectionUtil.getConnection();PreparedStatement pst =con.prepareStatement(sql);){
		pst.setString(1,employee.getEmployeename());
		pst.setDate(2,Date.valueOf(employee.getDob()));
		pst.setDate(3, Date.valueOf(employee.getDoj()));
		pst.setString(4,employee.getAddress());
		pst.executeUpdate();
	}
	catch(Exception e) {
		throw new DbException(ErrorConstants.INVALID_ADD);
	}

	}

	@Override
	public List<Employee> displayEmployeeDetils() throws DbException {
		String sql="select employee_id,employee_name,dob,doj,address from employee";
		List<Employee> list = new ArrayList<>();
		try(Connection con=ConnectionUtil.getConnection();Statement stmt=con.createStatement();ResultSet rs=stmt.executeQuery(sql);){
		while(rs.next())
		{Employee e=new Employee();
			e.setEmployeeid(rs.getInt("employee_id"));
			e.setEmployeename(rs.getString("employee_name"));
			Date ar = rs.getDate("dob");
			LocalDate pa1=ar.toLocalDate();
			e.setDob(pa1);
			Date ar1 = rs.getDate("doj");
			LocalDate ex=ar1.toLocalDate();
			e.setDoj(ex);
				
			e.setAddress(rs.getString("address"));
			list.add(e);
			}
		}
		catch(Exception e) {
		throw new DbException(ErrorConstants.INVALID_SELECT);
		}
		return list;
		}

	@Override
	public void deleteEmployeeDetils(Employee employee) throws DbException {
		String ins="delete from employee where employee_name=?";
		try(Connection con=ConnectionUtil.getConnection();PreparedStatement pst=con.prepareStatement(ins);){
		pst.setString(1,employee.getEmployeename());
		pst.executeUpdate();
	}

	catch(Exception e) {
		throw new DbException(ErrorConstants.INVALID_DELETE);
	}
	}

	@Override
	public void updateEmployeeDetils(Employee employee) throws DbException {
		
		String sql= "update employee set address=? where  employee_name=?";
		
		try(Connection con=ConnectionUtil.getConnection();PreparedStatement pst=con.prepareStatement(sql);){
		pst.setString(2, employee.getEmployeename());
		pst.setString(1,employee.getAddress());
		pst.executeUpdate();
		}
	catch(Exception e) {
		throw new DbException(ErrorConstants.INVALID_UPDATE);
	}
	}

	
}	



