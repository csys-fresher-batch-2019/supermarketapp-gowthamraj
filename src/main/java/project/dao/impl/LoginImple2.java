package project.dao.impl;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import project.dao.LoginDAO2;
import project.model.Login;

public class LoginImple2 implements LoginDAO2 {
	   
   

   public static JdbcTemplate getJdbcTemplate() {
       BasicDataSource ds = new BasicDataSource();
       ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
       ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
       ds.setUsername("system");
       ds.setPassword("oracle");
       JdbcTemplate jdbcTemplate = new JdbcTemplate();
       jdbcTemplate.setDataSource(ds);
       return jdbcTemplate;
}
   
	  
@Override
public void add(Login l) {
	 JdbcTemplate jdbcTemplate = LoginImple2.getJdbcTemplate();
	 
     String sql = "INSERT INTO login (username,password) VALUES (?,?)";
     int rows = jdbcTemplate.update(sql, l.username,l.password);
     System.out.println(rows);
 }

	@Override
	public Login login(String username, String password) {
		String sql="select user_name,passwords from login where user_name = ? and passwords = ?";
		JdbcTemplate jdbcTemplate = LoginImple2.getJdbcTemplate();
		Object[] params = { username, password};
		Login result = null;
		try {
			result = jdbcTemplate.queryForObject(sql,params, (rs,rowNo)->{
				Login ll = new Login();
				ll.username = rs.getString("user_name");
				return ll;
			});
		} catch (DataAccessException e) {
			e.printStackTrace();
		}

		return result;
		}


}