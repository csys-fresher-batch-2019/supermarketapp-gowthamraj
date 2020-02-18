package com.chainsys.supermarketapp.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.supermarketapp.dao.CaseDAO;
import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.exception.ErrorConstants;
import com.chainsys.supermarketapp.model.OrderItem;
import com.chainsys.supermarketapp.model.Product;
import com.chainsys.supermarketapp.util.Logger;

public class CaseImple implements CaseDAO {
	private static final Logger log=Logger.getInstance();

	@Override
	public int employeeCount() throws DbException {
		String sql = "select count(*)  as employee_count from employee";
		int employeeCount = 0;
		try(Connection con = ConnectionUtil.getConnection();Statement st1 = con.createStatement();ResultSet rs = st1.executeQuery(sql);){
		if (rs.next()) {
			 employeeCount = rs.getInt("employee_count");
			log.getInput("Total number of employee in the market  =" + employeeCount);
			
		}
		}
	catch(SQLException e) {
		throw new DbException(ErrorConstants.INVALID_SELECT);
	}
		return employeeCount;
		
		
	}
	@Override
	public int todayIncome(LocalDate date) throws DbException {
		String sql = "select GET_TOTAL_AMOUNT(?) as total_amount from dual ";
		int amount = 0;
		try(Connection con = ConnectionUtil.getConnection();PreparedStatement st = con.prepareStatement(sql);){
					st.setDate(1, Date.valueOf(date));
					try(ResultSet rs = st.executeQuery();){
		while(rs.next()) {
			amount = rs.getInt("total_amount");
			System.out.println(amount);
		}
					}
		}catch(SQLException e)
		{
			e.printStackTrace();
			throw new DbException(ErrorConstants.INVALID_SELECT);
		}
		return amount;
	}

	@Override
	public int totalIncome(OrderItem bills) throws DbException {
			String sql = "select sum(total_amount)as daily_income from bill_order where status='paid'";
		int total=0;
		try(Connection con = ConnectionUtil.getConnection();Statement st = con.createStatement();ResultSet rs = st.executeQuery(sql);){
		while (rs.next()) {
			total = rs.getInt("daily_income");
		}
	}catch(SQLException e)
	{
		
		throw new DbException(ErrorConstants.INVALID_SELECT);
	}
		return total;
	}

	@Override
			public List<Product> productPriceBetween(int min, int max) throws DbException {
					String sql = "select * from product where price  between ? and ?";
				List<Product> list = new ArrayList<>();
				try(Connection con = ConnectionUtil.getConnection();PreparedStatement ps = con.prepareStatement(sql);ResultSet rs = ps.executeQuery();){
				ps.setInt(1, min);
				ps.setInt(2, max);
				try(ResultSet rss = ps.executeQuery();){
				while (rss.next()) {
					int id = rss.getInt("product_id");
					String name = rss.getString("product_name");
					int cost = rss.getInt("price");
					log.getInput("product_id =" + id + "\t Product name =" + name + "\t price =" + cost);
					Product p = new Product();
					p.setPid(id);
					p.setProductname(name);
					p.setPrice(cost);
					list.add(p);
				}
				}
				}catch(SQLException e)
				{
					throw new DbException(ErrorConstants.INVALID_SELECT);
				}				
				return list;
			}
			
		@Override
		public List<OrderItem> customerCount(OrderItem bills) throws DbException {
			
			String sql="select sum(*) as number_of_customer,ordered_date from bill_order group by ordered_date";
			List<OrderItem> list = new ArrayList<>();
			try(Connection con=ConnectionUtil.getConnection();Statement st=con.createStatement();ResultSet rs=st.executeQuery(sql);){
			while (rs.next())
			{
				int customercount=rs.getInt("number_of_customer");
				Date ar = rs.getDate("ordered_date");
				LocalDate pa1=ar.toLocalDate();
				log.getInput("Number of customer ="+customercount+"\t Date ="+pa1);
				OrderItem b=new OrderItem();
				b.setCustomerno(customercount);
				b.setBilldate(pa1);
				list.add(b);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
			throw new DbException(ErrorConstants.INVALID_SELECT);
		}

			return list;
		}
	}

