package project.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import exception.DbException;
import exception.ErrorConstants;

public class ConnectionUtil {

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
