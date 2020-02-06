package project.dao.impl;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;

import exception.DbException;
import exception.ErrorConstants;
import project.dao.BillOrderDAO;
import project.model.Order;
import project.model.OrderItem;
import supermarket.Logger;

public class BillOrderImple implements BillOrderDAO {
	private static final Logger log = Logger.getInstance();
	

		public int getNextOrderId() throws DbException {
		int orderID = 0;
		String sql = "select pr_idd_sq.nextval as order_id from dual";
		try (Connection con =ConnectionUtil. getConnection();Statement stmt = con.createStatement();ResultSet rs = stmt.executeQuery(sql);) {
		if (rs.next()) {
			orderID = rs.getInt("order_id");
		}
		
		}
		catch(Exception e) {
			throw new DbException(ErrorConstants.INVALID_SELECT);
		}
		return orderID;
	}

	@Override
	public void addBillOrder(Order billorder) throws DbException {
		int orderId = getNextOrderId();
		String sql = "Insert into bill_order (p_id,customer_no,total_amount)values(?,?,?)";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setInt(1, orderId);
			pst.setInt(2, billorder.getCustomerno());
			pst.setInt(3, billorder.getTotalAmount());
			pst.executeUpdate();
			List<OrderItem> items = billorder.getItems();
			for (OrderItem orderItem : items) {
				String sql1 = "insert into bill_items (bill_item_id,bill_no,product_id,quantity,price,total_amount) values (bill_item_id_seq.nextval,?,?,?,?,?)";
				try(PreparedStatement pst1 = con.prepareStatement(sql1);){
				pst1.setInt(1, orderId);
				pst1.setInt(2, orderItem.getProductId());
				pst1.setInt(3, orderItem.getQuantity());
				pst1.setInt(4, orderItem.getPrice());
				pst1.setInt(5, orderItem.getTotalAmount());
				pst1.executeUpdate();
			}
			}
		}
		catch(Exception e) {
			throw new DbException(ErrorConstants.INVALID_ADD);
		}
	}

	@Override
	public void updateBillOrder(Order billorder) throws DbException {
		String sql = "update bill_order set total_amount =? where customer_no=?";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
		pst.setInt(2, billorder.getCustomerno());
		pst.setFloat(1, billorder.getTotalAmount());
		pst.executeUpdate();
		}
		catch(Exception e) {
			throw new DbException(ErrorConstants.INVALID_UPDATE);
		}

	}

	@Override
	public void deleteBillOrder(Order billorder) throws DbException {
		String sql = "delete from bill_order where Customer_no=?";
		try (Connection con =ConnectionUtil. getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
		pst.setInt(1, billorder.getCustomerno());
		pst.executeUpdate();
	}
	catch(Exception e) {
		throw new DbException(ErrorConstants.INVALID_DELETE);
	}

	}

	@Override
	public void displayBillOrder(Order billorder) throws DbException {
		String sql = "select * from bill_order";// p_id,product_id,customer_no,quantity,price
		try (Connection con = ConnectionUtil.getConnection();Statement stmt = con.createStatement();ResultSet rs = stmt.executeQuery(sql);) {
				while (rs.next()) {
			int pid = rs.getInt("p_id");
			int cusno = rs.getInt("Customer_no");
			int total = rs.getInt("total_amount");
			String status = rs.getString("status");
			Date ds = rs.getDate("ordered_date");
			LocalDate pa1 = ds.toLocalDate();
			log.getInput("product id = " + pid + "customer number = " + cusno + "Total = " + total + "Status ="
					+ status + "Ordered Date =" + pa1);
		}
		}
		catch(Exception e) {
			throw new DbException(ErrorConstants.INVALID_SELECT);
				}
	}
}
