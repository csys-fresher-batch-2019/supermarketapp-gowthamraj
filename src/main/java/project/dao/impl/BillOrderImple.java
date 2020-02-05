package project.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;

import project.dao.BillOrderDAO;
import project.model.Order;
import project.model.OrderItem;
import supermarket.logger;

public class BillOrderImple implements BillOrderDAO {
	private static final logger log = logger.getInstance();

	public static Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
		log.getInput("connection");
		return con;
	}

	public int getNextOrderId() throws Exception {
		Connection con = getConnection();
		String sql = "select pr_idd_sq.nextval as order_id from dual";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		int orderID = 0;
		if (rs.next()) {
			orderID = rs.getInt("order_id");
		}
		
		stmt.close();
		rs.close();
		return orderID;
		
}

	@Override
	public void addBillOrder(Order billorder) throws Exception {
		Connection con = getConnection();
		int orderId = getNextOrderId();
		String sql = "Insert into bill_order (p_id,customer_no,total_amount)values(?,?,?)";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, orderId);
		pst.setInt(2, billorder.getCustomerno());
		pst.setInt(3, billorder.getTotalAmount());
		pst.executeUpdate();
		List<OrderItem> items = billorder.getItems();
		for (OrderItem orderItem : items) 
		{
			String sql1 = "insert into bill_items (bill_item_id,bill_no,product_id,quantity,price,total_amount) values (bill_item_id_seq.nextval,?,?,?,?,?)";
			PreparedStatement pst1 = con.prepareStatement(sql1);
			pst1.setInt(1, orderId);
			pst1.setInt(2, orderItem.getProductId());
			pst1.setInt(3, orderItem.getQuantity());
			pst1.setInt(4, orderItem.getPrice());
			pst1.setInt(5, orderItem.getTotalAmount());
			pst1.executeUpdate();
		}
		con.close();
		pst.close();
	}

	@Override
	public void updateBillOrder(Order billorder) throws Exception {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		String sql = "update bill_order set total_amount =? where customer_no=?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(2, billorder.getCustomerno());
		pst.setFloat(1, billorder.getTotalAmount());
		pst.executeUpdate();
		con.close();
		pst.close();
	}

	@Override
	public void deleteBillOrder(Order billorder) throws Exception {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		String sql = "delete from bill_order where Customer_no=?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, billorder.getCustomerno());
		pst.executeUpdate();
		con.close();
		pst.close();
	}

	@Override
	public void displayBillOrder(Order billorder) throws Exception {
		Connection con = getConnection();
		String sql = "select * from bill_order";// p_id,product_id,customer_no,quantity,price
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			int pid = rs.getInt("p_id");
			int cus_no = rs.getInt("Customer_no");
			int total = rs.getInt("total_amount");
			String status = rs.getString("status");
			Date ds = rs.getDate("ordered_date");
			LocalDate pa1 = ds.toLocalDate();

			log.getInput("product id = " + pid + "customer number = " + cus_no + "Total = " + total + "Status ="
					+ status + "Ordered Date =" + pa1);

		}
		con.close();
		stmt.close();
		rs.close();
	}

}
