package project.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import project.dao.CustomerCardDAO;
import project.model.customerCard;

public class CustomerCardImpl implements CustomerCardDAO {
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system","oracle");
		
		return con;
	}

	
	@Override
	public void addCustomerCard(customerCard customercard) throws Exception {
		Connection con=getConnection();
		String sql="insert into customer_card (customer_name,mobile_number,address) values(?,?,?)";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setString(1,customercard.customername);
		pst.setLong(2,customercard.contactnumber);
		pst.setString(3,customercard.address);
		pst.executeUpdate();
		// TODO Auto-generated method stub
		con.close();
	}

	@Override
	public void deleteCustomerCard(customerCard customercard) throws Exception {
		// TODO Auto-generated method stub
		Connection con=getConnection();
		String sql="delete from customer_card where customer_name=?";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setString(1,customercard.customername);
		pst.executeUpdate();
		con.close();
	}

	@Override
	public void displayCustomerCard(customerCard customercard) throws Exception, Exception {
		// TODO Auto-generated method stub
		Connection con=getConnection();
		String sql="select customer_name,mobile_number,address from customer_card";
		Statement st1 =con.createStatement();
		ResultSet rs=st1.executeQuery(sql);
		while(rs.next())
		{
			
			String name=rs.getString("customer_name");
			long contact=rs.getLong("mobile_number");
			String address=rs.getString("address");
			
			System.out.println("customer name = "+name+"contact = "+contact+"Address ="+address);
		}
		con.close();
	}

	@Override
	public void updateCustomerCard(customerCard customercard) throws Exception {
		// TODO Auto-generated method stub

		Connection con=getConnection();
		String sql="update customer_card set address=? where customer_name=?";
		PreparedStatement pst=con.prepareStatement(sql);
		pst.setString(1,customercard.address);
		pst.setString(2,customercard.customername);
		pst.executeUpdate();
		con.close();
	}

}
