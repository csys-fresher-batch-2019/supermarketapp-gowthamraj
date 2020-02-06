package com.chainsys.supermarketapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.chainsys.supermarketapp.dao.LoginDAO;
import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.exception.ErrorConstants;
import com.chainsys.supermarketapp.model.Login;
import com.chainsys.supermarketapp.util.Logger;

public class LoginImple implements LoginDAO {
	private static final Logger log = Logger.getInstance();

	public Login check(Login login) throws DbException {
		String sql = "select user_name,passwords from login where user_name = ? and passwords = ?";
		Login log1 = new Login();
		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs1 = ps.executeQuery();) {
			ps.setString(1, login.getUsername());
			ps.setString(2, login.getPassword());
			if (rs1.next()) {
				log1.setUsername(rs1.getString("user_name"));
				log1.setPassword(rs1.getString("passwords"));
			}
		} catch (Exception e) {
			throw new DbException(ErrorConstants.INVALID_SELECT);
		}
		return log1;
	}

	public boolean isUsernameExists(String username) throws DbException {
		boolean exists = false;
		String sql1 = "select user_name from login where user_name=?";
		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement pst = con.prepareStatement(sql1);
				ResultSet rs = pst.executeQuery();) {
			pst.setString(1, username);
			if (rs.next()) {
				exists = true;
			}
		} catch (Exception e) {
			throw new DbException(ErrorConstants.INVALID_SELECT);
		}
		return exists;
	}
	
	@Override
	public void add(Login login) throws DbException {
		String sql = "insert into login (user_name,passwords) values(?,?)";
		log.getInput(sql);
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setString(1, login.getUsername());
			ps.setString(2, login.getPassword());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new DbException(ErrorConstants.INVALID_ADD);
		}
	}

}
