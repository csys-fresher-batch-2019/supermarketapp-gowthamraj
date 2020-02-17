package com.chainsys.supermarketapp.dao.impl;
import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.supermarketapp.dao.BillOrderDAO;
import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.exception.ErrorConstants;
import com.chainsys.supermarketapp.model.Order;
import com.chainsys.supermarketapp.model.OrderItem;

import com.chainsys.supermarketapp.model.ProductStock;

public class BillOrderImple implements BillOrderDAO {
	//private static final Logger log = Logger.getInstance();
	

		public int getNextOrderId() throws DbException {
		int orderID = 0;
		String sql = "select pr_idd_sq.nextval as order_id from dual";
		try (Connection con =ConnectionUtil. getConnection();Statement stmt = con.createStatement();ResultSet rs = stmt.executeQuery(sql);) {
		while (rs.next()) {
			orderID = rs.getInt("order_id");
		}
		
		}
		catch(SQLException e) {
			
			throw new DbException(ErrorConstants.INVALID_SELECT);
		}
		return orderID;
	}

	@Override
	public int addBillOrder(Order billorder) throws DbException {
		int orderId = getNextOrderId();
		ProductStockImple psi = new ProductStockImple();
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
				
				ProductStock ps = new ProductStock();
				ps.setProductno(orderItem.getProductId());
				ps.setQuantity(orderItem.getQuantity());
				psi.updateProductStock1(ps);
			}
			}
		}
		catch(SQLException e) {
			
			throw new DbException(ErrorConstants.INVALID_ADD);
		}
		return orderId;
	}

	@Override
	public void updateBillOrder(Order billorder) throws DbException {
		String sql = "update bill_order set total_amount =? where customer_no=?";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
		pst.setInt(2, billorder.getCustomerno());
		pst.setFloat(1, billorder.getTotalAmount());
		pst.executeUpdate();
		}
		catch(SQLException e) {
			throw new DbException(ErrorConstants.INVALID_UPDATE);
		}
	}
	@Override
	public void deleteBillOrder(Order billorder) throws DbException {
		try (Connection con =ConnectionUtil. getConnection(); 	CallableStatement stmt=con.prepareCall("{call cancel_order(?)}");) {
	
			stmt.setInt(1, billorder.getOrderId());
		stmt.executeUpdate();
	}
	catch(SQLException e) {
		e.printStackTrace();

		throw new DbException(ErrorConstants.INVALID_DELETE);
	}
}
	@Override
	public List<Order> displayBillOrder() throws DbException {
		String sql = "select * from bill_order";
		List<Order> list = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnection();Statement stmt = con.createStatement();ResultSet rs = stmt.executeQuery(sql);) {
				

			
		
		while (rs.next()) {
			Order or=new Order();
			or.setOrderId(rs.getInt("p_id"));
			or.setCustomerno(rs.getInt("Customer_no"));
			or.setTotalAmount( rs.getInt("total_amount"));
			or.setStatus(rs.getString("status"));
					Timestamp ds = rs.getTimestamp("ordered_date");
			
			

			or.setOrderedDate(ds.toLocalDateTime());
	list.add(or);
		}
		}
		catch(SQLException e) {
			throw new DbException(ErrorConstants.INVALID_SELECT);
				}
		return list;
		}


	
}
