package project.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import project.dao.LoginDAO;
import project.model.Login;
import supermarket.logger;

public class LoginImple implements LoginDAO {
	private static final logger log=logger.getInstance();
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
		log.getInput("connection");
		return con;
	}

		public Login check(Login login) throws Exception, SQLException {
		String sql = "select user_name,passwords from login where user_name = ? and passwords = ?";
		Connection con = getConnection();
		PreparedStatement ps =con.prepareStatement(sql);
		ps.setString(1,login.getUsername());
		ps.setString(2,login.getPassword());
		ResultSet rs1 = ps.executeQuery();
		//boolean b = true;
		
		Login log1 = new Login();
		if (rs1.next()) {
			//b = true;
			
			log1.setUsername(rs1.getString("user_name"));
			log1.setPassword(rs1.getString("passwords"));

		}/* else {
			b = false;
		}
		if (b) {
			log.getInput("login Success");

		} else {
			log.getInput("login failure");
		}*/
		
		con.close();
		ps.close();
		return log1;

	}
		
	public boolean isUsernameExists(String username) throws Exception {
		Connection con = getConnection();
		boolean exists = false;
		String Sql1="select user_name from login where user_name=?";
		PreparedStatement pst=con.prepareStatement(Sql1);
		pst.setString(1,username);
		ResultSet rs=pst.executeQuery();
		if(rs.next())
		{
			exists = true;
		}
		con.close();
		pst.close();
		rs.close();
		return exists;
		
	}

	@Override
	public void add(Login login) throws Exception {
		String sql = "insert into login (user_name,passwords) values(?,?)";
		log.getInput(sql);

		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, login.getUsername());
		ps.setString(2, login.getPassword());
		ps.executeUpdate();
		
		
		
		String name=login.getUsername();
		String Sql1="select user_name from login where user_name=?";
		PreparedStatement pst=con.prepareStatement(Sql1);
		pst.setString(1,name);
		ResultSet rs=pst.executeQuery();
		while(rs.next())
		{
			
		}
		con.close();
		ps.close();
		pst.close();
		rs.close();
	}

	

	
}
