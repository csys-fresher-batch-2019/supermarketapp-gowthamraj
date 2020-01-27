package project.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import project.dao.LoginDAO;
import project.model.Login;

public class LoginImple implements LoginDAO {

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
		System.out.println("connection");
		return con;
	}

		public Login check(Login login) throws Exception, SQLException {
		String sql = "select user_name,passwords from login where user_name = ? and passwords = ?";
		Connection con = getConnection();
		PreparedStatement ps =con.prepareStatement(sql);
		ps.setString(1,login.username);
		ps.setString(2,login.password);
		ResultSet rs1 = ps.executeQuery();
		boolean b = true;
		
		Login log = new Login();
		if (rs1.next()) {
			b = true;
			
			log.username=rs1.getString("user_name");
			log.password=rs1.getString("passwords");

		} else {
			b = false;
		}
		if (b) {
			System.out.println("login Success");

		} else {
			System.out.println("login failure");
		}
		
		con.close();
		return log;

	}

	@Override
	public void add(Login login) throws Exception {
		String sql = "insert into login (user_name,passwords) values(?,?)";
		System.out.println(sql);

		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, login.username);
		ps.setString(2, login.password);
		ps.executeUpdate();
		// TODO Auto-generated method stub
		con.close();
	}

	

	
}
