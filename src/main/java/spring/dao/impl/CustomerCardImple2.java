package spring.dao.impl;
import java.util.List;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import spring1.dao.CustomerCardDAO2;
import supermarket.Logger;
import spring.dao.impl.ProductImple2;
import project.model.CustomerCard;

public class CustomerCardImple2 implements CustomerCardDAO2 {
	private static final Logger log=Logger.getInstance();
	public static JdbcTemplate getJdbcTemplate()
	{
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		ds.setUsername("system");
		ds.setPassword("oracle");
		JdbcTemplate jdbctemplate=new JdbcTemplate();
		jdbctemplate.setDataSource(ds);
		log.getInput("connected");
		return jdbctemplate;
	}
		@Override
	public void deleteCustomerCardDetails(CustomerCard cc) throws Exception {
		JdbcTemplate jdbctemplate=ProductImple2.getJdbcTemplate();
		String sql="Delete from customer_card where mobile_number=?";
		int row=jdbctemplate.update(sql,cc.getContactnumber());
		log.getInput(row);	
	}

	@Override
	public List<CustomerCard> displayCustomerCardDetails() throws Exception {
		JdbcTemplate jdbctemplate=ProductImple2.getJdbcTemplate();
		String sql= "select  customer_name,mobile_number,address from customer_card";
		List<CustomerCard>list=jdbctemplate.query(sql, (rs,rowNo)->{
			CustomerCard cc=new CustomerCard();
			cc.setCustomername(rs.getString("customer_name"));
			cc.setContactnumber(rs.getLong("mobile_number"));
			cc.setAddress(rs.getString("address"));
		   return cc;
		});
		return list;
		}

	@Override
	public void updateCustomerCard(CustomerCard cc) throws Exception {
		JdbcTemplate jdbctemplate=ProductImple2.getJdbcTemplate();
	String sql="update customer_card set  customer_name=? where mobile_number =?";
	Object []params= {cc.getCustomername(),cc.getContactnumber()};
	int row=jdbctemplate.update(sql,params);
	log.getInput(row);
}

	@Override
	public void addCustomerCardtDetails(CustomerCard cc) throws Exception {
		JdbcTemplate jdbctemplate=ProductImple2.getJdbcTemplate();
	String sql="insert into customer_card (customer_name,mobile_number,address) values(?,?,?)";
	Object[]params= {cc.getCustomername(),cc.getContactnumber(),cc.getAddress()};
	int row=jdbctemplate.update(sql,params);
	log.getInput(row);

		
	}

}
