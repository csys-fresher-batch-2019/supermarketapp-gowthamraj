package project.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import exception.DbException;
import exception.ErrorConstants;
import project.dao.EmployeeDAO;
import project.model.Employee;
import supermarket.Logger;

public class EmployeeImpl implements EmployeeDAO {
	private static final Logger log=Logger.getInstance();
	
	
	@Override
	public void addEmployeeDetils(Employee employee) throws DbException {
		String sql="insert into employee(employee_id,employee_name,dob,doj,mobile_no,address) values( emp_idd.nextval,?,?,?,?,?)";
		try(Connection con= ConnectionUtil.getConnection();PreparedStatement pst =con.prepareStatement(sql);){
		pst.setString(1,employee.getEmployeename());
		pst.setDate(2,Date.valueOf(employee.getDob()));
		pst.setDate(3, Date.valueOf(employee.getDoj()));
		pst.setLong(4,employee.getMobileno());
		pst.setString(5,employee.getAddress());
		pst.executeUpdate();
	}

	catch(Exception e) {
		throw new DbException(ErrorConstants.INVALID_ADD);
	}

	}

	@Override
	public void displayEmployeeDetils(Employee employee) throws DbException {
		String sql="select * from employee";
		try(Connection con=ConnectionUtil.getConnection();Statement stmt=con.createStatement();ResultSet rs=stmt.executeQuery(sql);){
		while(rs.next())
		{
			int id=rs.getInt("employee_id");
			String name=rs.getString("employee_name");
			Date ar = rs.getDate("dob");
			LocalDate pa1=ar.toLocalDate();
			Date ar1 = rs.getDate("doj");
			LocalDate ex=ar1.toLocalDate();
			long mobile=rs.getLong("mobile_no");
			String add=rs.getString("address");
			log.getInput("Employee ID ="+id+"Employee name ="+name+"Date of Birth ="+pa1+"Date of Joining "+ex+"Mobile Number ="+mobile+"Address ="+add);
		}
		}
		catch(Exception e) {
		throw new DbException(ErrorConstants.INVALID_SELECT);
		}
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



