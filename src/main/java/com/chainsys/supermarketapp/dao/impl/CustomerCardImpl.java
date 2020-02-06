package com.chainsys.supermarketapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.chainsys.supermarketapp.dao.CustomerCardDAO;
import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.exception.ErrorConstants;
import com.chainsys.supermarketapp.model.CustomerCard;
import com.chainsys.supermarketapp.util.Logger;

public class CustomerCardImpl implements CustomerCardDAO {
	private static final Logger log=Logger.getInstance();
	
	
	@Override
	public void addCustomerCard(CustomerCard customercard) throws DbException {
		
		String sql="insert into customer_card (customer_name,mobile_number,address) values(?,?,?)";
		try(Connection con=ConnectionUtil.getConnection();PreparedStatement pst=con.prepareStatement(sql);){
		pst.setString(1,customercard.getCustomername());
		pst.setLong(2,customercard.getContactnumber());
		pst.setString(3,customercard.getAddress());
		pst.executeUpdate();
		}
		catch(Exception e) {
			throw new DbException(ErrorConstants.INVALID_ADD);
		}
}

	@Override
	public void deleteCustomerCard(CustomerCard customercard) throws DbException {
	
		String sql="delete from customer_card where customer_name=?";
		try(	Connection con=ConnectionUtil.getConnection();PreparedStatement pst=con.prepareStatement(sql);){
		pst.setString(1,customercard.getCustomername());
		pst.executeUpdate();
	}
	catch(Exception e) {
		throw new DbException(ErrorConstants.INVALID_DELETE);
	}	}

	@Override
	public void displayCustomerCard(CustomerCard customercard) throws DbException {
		
		String sql="select customer_name,mobile_number,address from customer_card";
		try(Connection con=ConnectionUtil.getConnection();Statement st1 =con.createStatement();ResultSet rs=st1.executeQuery(sql);){
		while(rs.next())
		{
			
			String name=rs.getString("customer_name");
			long contact=rs.getLong("mobile_number");
			String address=rs.getString("address");
			
			log.getInput("customer name = "+name+"contact = "+contact+"Address ="+address);
		}
	}
	catch(Exception e) {
		throw new DbException(ErrorConstants.INVALID_SELECT);
	}
	}

	@Override
	public void updateCustomerCard(CustomerCard customercard) throws DbException {
		String sql="update customer_card set address=? where customer_name=?";
		try(Connection con=ConnectionUtil.getConnection();PreparedStatement pst=con.prepareStatement(sql);){
		pst.setString(1,customercard.getAddress());
		pst.setString(2,customercard.getCustomername());
		pst.executeUpdate();
		}
		catch(Exception e) {
			throw new DbException(ErrorConstants.INVALID_UPDATE);
		}
}

}
