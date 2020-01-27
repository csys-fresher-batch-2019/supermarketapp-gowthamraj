package project.dao.impl;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import project.dao.BillOrderDAO;
import project.model.Billorder;

public class BillOrderImple implements BillOrderDAO {
	public static Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
		System.out.println("connection");
		return con;
	}
	@Override
	public void addBillOrder(Billorder billorder) throws Exception {
		Connection con=getConnection();
		String sql="Insert into bill_order (p_id,product_id,customer_no,quantity,price)values(pr_idd_sq.nextval,?,?,?,?)";
		PreparedStatement pst =con.prepareStatement(sql);
		pst.setInt(1,billorder.productid);
		pst.setInt(2, billorder.customerno);
		pst.setInt(3,billorder.quantity);
		pst.setFloat(4,billorder.price);
		pst.executeUpdate();
		con.close();
	}

	
	@Override
	public void updateBillOrder(Billorder billorder) throws Exception {
		// TODO Auto-generated method stub
		Connection con=getConnection();
		String sql="update bill_order set quantity =? where customer_no=?";
		PreparedStatement pst =con.prepareStatement(sql);
		pst.setInt(2, billorder.customerno);
		pst.setInt(1,billorder.quantity);
		pst.executeUpdate();
		con.close();
	}

	@Override
	public void deleteBillOrder(Billorder billorder) throws Exception {
		// TODO Auto-generated method stub
		Connection con=getConnection();
		String sql="delete from bill_order where Customer_no=?";
		PreparedStatement pst =con.prepareStatement(sql);
		pst.setInt(1, billorder.customerno);
		pst.executeUpdate();
		con.close();
	}
	@Override
	public void displayBillOrder(Billorder billorder) throws Exception {
		Connection con=getConnection();
		String sql="select * from bill_order";//p_id,product_id,customer_no,quantity,price
		Statement stmt =con.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next())
		{
			int pid=rs.getInt("p_id");
			int id=rs.getInt("product_id");
			int cus_no=rs.getInt("Customer_no");
			int quan=rs.getInt("quantity");
			int cost=rs.getInt("price");
			
			System.out.println("prand_id = "+pid+"product id = "+id+"customer number = "+cus_no+"Quantity ="+quan+"price ="+cost);
			
		}
		con.close();
	}

	

}
