package project.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import project.dao.BillsDAO;
import project.model.Bills;

public class BillsImple implements BillsDAO {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
		System.out.println("connection");
		return con;
	}
	@Override
	public void addBills(Bills bills) throws Exception {
		// TODO Auto-generated method stub
		Connection con=getConnection();
		String sql="insert into bills(bill_no,bill_date,cus_no,customer_name,total,status) values(bill_no_sq.nextval,?,?,?,?,?)";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setDate(1, Date.valueOf(bills.billdate));
		pst.setInt(2,bills.customerno);
		pst.setString(3,bills.customername);
		pst.setInt(4,bills.total);
		pst.setString(5,bills.status);
		pst.executeUpdate();
	}

	@Override
	public void deleteBills(Bills bills) throws Exception {
		Connection con=getConnection();
		String sql="delete from bills where customer_name=?";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setString(1,bills.customername);
		pst.executeUpdate();
		con.close();
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayBills(Bills bills) throws Exception{
		Connection con=getConnection();
		String sql="select * from bills";//bill_no,bill_date,cus_no,customer_name,total,status
		Statement st1 =con.createStatement();
		ResultSet rs=st1.executeQuery(sql);
		while(rs.next())
		{
			int billno=rs.getInt("bill_no");
			Date ar = rs.getDate("bill_date");
			LocalDate pa1=ar.toLocalDate();
			int cusno=rs.getInt("cus_no");
			String name=rs.getString("customer_name");
			int cost=rs.getInt("total");
			String status=rs.getString("status");
			System.out.println("Bill Number ="+billno+"Bill date =" +pa1+"customer number = "+cusno+"cutomer name = "+name+"Total ="+cost+"Status ="+status);
		}
		con.close();
	}

	@Override
	public void updateBills(Bills bills) throws Exception {
		Connection con=getConnection();
		String sql="update bills set total=? where cus_no=?";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setInt(1,bills.total);
		pst.setInt(2,bills.customerno);
		pst.executeUpdate();
		con.close();
		// TODO Auto-generated method stub
		
	}

	
}
