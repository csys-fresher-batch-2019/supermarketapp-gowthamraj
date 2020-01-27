package project.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class test {

	public static JdbcTemplate getJdbcTemplate()
	{
		DataSource ds = getDataSource();
		JdbcTemplate jt=new JdbcTemplate();
		jt.setDataSource(ds);
		return jt;
	}
	private static DataSource getDataSource() {
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		ds.setUsername("system");
		ds.setPassword("oracle");
		return ds;
	}
	public static void main(String[] args) throws Exception {

		//getDataSource().getConnection();
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
		System.out.println("connection" + con);
	
	}

}
