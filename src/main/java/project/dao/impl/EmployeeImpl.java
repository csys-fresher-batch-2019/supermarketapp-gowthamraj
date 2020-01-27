package project.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import project.dao.EmployeeDAO;
import project.model.Employee;

public class EmployeeImpl implements EmployeeDAO {
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system","oracle");
		
		return con;
	}
	
	@Override
	public void addEmployeeDetils(Employee employee) throws Exception {
		// TODO Auto-generated method stub
		Connection con= getConnection();
		String sql="insert into employee(employee_id,employee_name,dob,doj,mobile_no,address) values( emp_idd.nextval,?,?,?,?,?)";
		PreparedStatement pst =con.prepareStatement(sql);
		pst.setString(1,employee.employeename);
		pst.setDate(2,Date.valueOf(employee.dob));
		pst.setDate(3, Date.valueOf(employee.doj));
		pst.setLong(4,employee.mobileno);
		pst.setString(5,employee.address);
		pst.executeUpdate();
		con.close();
	}

	@Override
	public void DisplayEmployeeDetils(Employee employee) throws Exception {
		Connection con=getConnection();
		String sql="select * from employee";
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
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
			System.out.println("Employee ID ="+id+"Employee name ="+name+"Date of Birth ="+pa1+"Date of Joining "+ex+"Mobile Number ="+mobile+"Address ="+add);
		}
		con.close();
		}
	@Override
	public void DeleteEmployeeDetils(Employee employee) throws Exception {
		Connection con=getConnection();
		String ins="delete from employee where employee_name=?";
		PreparedStatement pst=con.prepareStatement(ins);
		pst.setString(1,employee.employeename);
		pst.executeUpdate();
		// TODO Auto-generated method stub
		con.close();
	}

	@Override
	public void UpdateEmployeeDetils(Employee employee) throws Exception {
		Connection con=getConnection();
		String sql= "update employee set address=? where  employee_name=?";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setString(2, employee.employeename);
		pst.setString(1,employee.address);
		pst.executeUpdate();
		// TODO Auto-generated method stub
		con.close();
	}
		
	}


