package project.dao.impl;
import java.util.List;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import project.dao.CustomerCardDAO2;
import project.model.customerCard;

public class CustomerCardImple2 implements CustomerCardDAO2 {
	public static JdbcTemplate getJdbcTemplate()
	{
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		ds.setUsername("system");
		ds.setPassword("oracle");
		JdbcTemplate jdbctemplate=new JdbcTemplate();
		jdbctemplate.setDataSource(ds);
		System.out.println("connected");
		return jdbctemplate;
	}
		@Override
	public void deleteCustomerCardDetails(customerCard cc) throws Exception {
		JdbcTemplate jdbctemplate=ProductImple2.getJdbcTemplate();
		String sql="Delete from customer_card where mobile_number=?";
		int row=jdbctemplate.update(sql,cc.contactnumber);
		System.out.println(row);	
	}

	@Override
	public List<customerCard> DisplayCustomerCardDetails() throws Exception {
		JdbcTemplate jdbctemplate=ProductImple2.getJdbcTemplate();
		String sql= "select  customer_name,mobile_number,address from customer_card";
		List<customerCard>list=jdbctemplate.query(sql, (rs,rowNo)->{
			customerCard cc=new customerCard();
			cc.customername=rs.getString("customer_name");
			cc.contactnumber=rs.getLong("mobile_number");
			cc.address=rs.getString("address");
		   return cc;
		});
		return list;
		}

	@Override
	public void updateCustomerCard(customerCard cc) throws Exception {
		JdbcTemplate jdbctemplate=ProductImple2.getJdbcTemplate();
	String sql="update customer_card set  customer_name=? where mobile_number =?";
	Object []params= {cc.customername,cc.contactnumber};
	int row=jdbctemplate.update(sql,params);
	System.out.println(row);
}

	@Override
	public void addCustomerCardtDetails(customerCard cc) throws Exception {
		JdbcTemplate jdbctemplate=ProductImple2.getJdbcTemplate();
	String sql="insert into customer_card (customer_name,mobile_number,address) values(?,?,?)";
	Object[]params= {cc.customername,cc.contactnumber,cc.address};
	int row=jdbctemplate.update(sql,params);
	System.out.println(row);

		
	}

}
