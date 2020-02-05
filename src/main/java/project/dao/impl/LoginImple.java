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
		Login log1 = new Login();
		try(Connection con = getConnection();PreparedStatement ps =con.prepareStatement(sql);ResultSet rs1 = ps.executeQuery();){
		ps.setString(1,login.getUsername());
		ps.setString(2,login.getPassword());
		if (rs1.next()) {
			log1.setUsername(rs1.getString("user_name"));
			log1.setPassword(rs1.getString("passwords"));
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}	return log1;
	}
		
	public boolean isUsernameExists(String username) throws Exception {
		boolean exists = false;
		String Sql1="select user_name from login where user_name=?";
		try(Connection con = getConnection();PreparedStatement pst=con.prepareStatement(Sql1);ResultSet rs=pst.executeQuery();){
		pst.setString(1,username);
		if(rs.next())
		{
			exists = true;
		}
	}
	catch(Exception e) {
		e.printStackTrace();
	}
		return exists;
	}

	@Override
	public void add(Login login) throws Exception {
		String sql = "insert into login (user_name,passwords) values(?,?)";
		log.getInput(sql);
		try (Connection con = getConnection();PreparedStatement ps=con.prepareStatement(sql);){
		ps.setString(1, login.getUsername());
		ps.setString(2, login.getPassword());
		ps.executeUpdate();
		String name=login.getUsername();
		String Sql1="select user_name from login where user_name=?";
		try(PreparedStatement pst=con.prepareStatement(Sql1);ResultSet rs=pst.executeQuery();){
		pst.setString(1,name);
		while(rs.next())
		{
	}
}
}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
