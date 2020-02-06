package spring.dao.impl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import spring1.dao.caseDAO2;
import supermarket.Logger;
import project.model.OrderItem;
import project.model.Employee;

public class CaseImple2 implements caseDAO2 {
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
	public int todayIncome(LocalDate date) throws Exception {
		JdbcTemplate jdbctemplate=CaseImple2.getJdbcTemplate();
		String sql="select GET_TOTAL_AMOUNT(?)as total_amount from dual";
		Object[] params = { Date.valueOf(date) };
		int totalamount=jdbctemplate.queryForObject(sql, params , Integer.class);
		return totalamount;
	}
	@Override
	public List<OrderItem> customerCount(OrderItem bills) throws Exception {
		JdbcTemplate jdbctemplate=CaseImple2.getJdbcTemplate();
		String sql="select count(*) as number_of_customer,ordered_date from bill_order group by ordered_date";
		List<OrderItem>list=jdbctemplate.query(sql, (rs,rowNo)->{
			OrderItem b=new OrderItem();
			b.setCustomerno(rs.getInt("number_of_customer"));
			Date ds=rs.getDate("ordered_date");
			LocalDate pa1=ds.toLocalDate();
			b.setBilldate(pa1);
			return b;	
		});
		return list;
		}
	@Override
	public int employeeCount(Employee employee) throws Exception {
		JdbcTemplate jdbctemplate=CaseImple2.getJdbcTemplate();
		String sql="select count(*)  from employee";
		int totalemployee=jdbctemplate.queryForObject(sql, Integer.class);
		log.getInput(totalemployee);
		return totalemployee;
		}
	@Override
	public int totalIncome(OrderItem bills) throws Exception {
		JdbcTemplate jdbctemplate=CaseImple2.getJdbcTemplate();
		String sql="select sum(total)as daily_income from bills";
		int row=jdbctemplate.queryForObject(sql,  Integer.class);
		log.getInput(row);
		return row;
	}
}
