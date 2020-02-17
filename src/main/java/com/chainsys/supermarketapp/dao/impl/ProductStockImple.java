package com.chainsys.supermarketapp.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.supermarketapp.dao.ProductStockDAO;
import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.exception.ErrorConstants;
import com.chainsys.supermarketapp.model.ProductStock;
import com.chainsys.supermarketapp.util.Logger;

public class ProductStockImple implements ProductStockDAO {
	private static final Logger log = Logger.getInstance();

	@Override
	public void addProductStock(ProductStock productstock) throws DbException {
		String sql = "insert into product_stock (stock_id,product_no,quantity,product_arrival,expery_date)\r\n"
				+ "values(pro_no.nextval,?,?,?,?)";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, productstock.getProductno());
			ps.setInt(2, productstock.getQuantity());
			ps.setDate(3, Date.valueOf(productstock.getProductarrival()));
			ps.setDate(4, Date.valueOf(productstock.getExperydate()));
			ps.executeUpdate();
		} catch (Exception e) {
			throw new DbException(ErrorConstants.INVALID_ADD);
		}
	}

	@Override
	public void deleteProductStock(ProductStock productstock) throws DbException {
		String sql = "delete from product_stock where product_no=?";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, productstock.getProductno());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new DbException(ErrorConstants.INVALID_DELETE);
		}
	}

	@Override
	public void updateProductStock(ProductStock productstock) throws DbException {

		String sql = "update product_stock set quantity= ? where product_no=?";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, productstock.getQuantity());
			ps.setInt(2, productstock.getProductno());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new DbException(ErrorConstants.INVALID_UPDATE);
		}
	}
	@Override
	public void updateProductStock1(ProductStock productstock) throws DbException {

		String sql = "update product_stock set quantity=quantity- ? where product_no=?";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, productstock.getQuantity());
			ps.setInt(2, productstock.getProductno());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new DbException(ErrorConstants.INVALID_UPDATE);
		}
	}

	@Override
	public List<ProductStock> displayProductStock() throws DbException {

		String sql = "select product_no,stock_id,quantity,product_arrival,expery_date from product_stock";
		List<ProductStock> list = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {
			while (rs.next()) {
				ProductStock ps=new ProductStock();
				ps.setStockid(rs.getInt("stock_id"));
				ps.setProductno(rs.getInt("product_no"));
				ps.setQuantity(rs.getInt("quantity"));
				Date ar = rs.getDate("product_arrival");
				LocalDate pa1 = ar.toLocalDate();
				ps.setProductarrival(pa1);
				Date ar1 = rs.getDate("expery_date");
				LocalDate ex = ar1.toLocalDate();
				ps.setExperydate(ex);
				list.add(ps);
			}
		} catch (Exception e) {
			throw new DbException(ErrorConstants.INVALID_SELECT);
		}
		return list;
	}
}
