package com.chainsys.supermarketapp.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.exception.ErrorConstants;

public class ConnectionUtil {

	private ConnectionUtil() {
		//default constructor
	}
	public static Connection getConnection() throws DbException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new DbException(ErrorConstants.INVALID_CON);
		}
		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
		} catch (SQLException e) {
			throw new DbException(ErrorConstants.INVALID_CON);
		}
		return con;
	}
}
