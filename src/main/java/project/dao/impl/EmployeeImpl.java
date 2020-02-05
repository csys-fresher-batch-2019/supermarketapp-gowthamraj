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
import supermarket.logger;

public class EmployeeImpl implements EmployeeDAO {
	private static final logger log=logger.getInstance();
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system","oracle");
		
		return con;
	}
	
	@Override
	public void addEmployeeDetils(Employee employee) throws Exception {
		String sql="insert into employee(employee_id,employee_name,dob,doj,mobile_no,address) values( emp_idd.nextval,?,?,?,?,?)";
		try(Connection con= getConnection();PreparedStatement pst =con.prepareStatement(sql);){
		pst.setString(1,employee.getEmployeename());
		pst.setDate(2,Date.valueOf(employee.getDob()));
		pst.setDate(3, Date.valueOf(employee.getDoj()));
		pst.setLong(4,employee.getMobileno());
		pst.setString(5,employee.getAddress());
		pst.executeUpdate();
	}

	catch(Exception e) {
		e.printStackTrace();
	}

	}

	@Override
	public void displayEmployeeDetils(Employee employee) throws Exception {
		
		String sql="select * from employee";
		try(Connection con=getConnection();Statement stmt=con.createStatement();ResultSet rs=stmt.executeQuery(sql);){
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
			e.printStackTrace();
		}
		}
	@Override
	public void deleteEmployeeDetils(Employee employee) throws Exception {

		String ins="delete from employee where employee_name=?";
		try(Connection con=getConnection();PreparedStatement pst=con.prepareStatement(ins);){
		pst.setString(1,employee.getEmployeename());
		pst.executeUpdate();
	}

	catch(Exception e) {
		e.printStackTrace();
	}
	}

	@Override
	public void updateEmployeeDetils(Employee employee) throws Exception {
		
		String sql= "update employee set address=? where  employee_name=?";
		
		try(Connection con=getConnection();PreparedStatement pst=con.prepareStatement(sql);){
		pst.setString(2, employee.getEmployeename());
		pst.setString(1,employee.getAddress());
		pst.executeUpdate();
		}
	catch(Exception e) {
		e.printStackTrace();
	}
	}
}	



