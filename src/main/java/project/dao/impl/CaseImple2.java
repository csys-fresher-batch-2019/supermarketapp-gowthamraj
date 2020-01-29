package project.dao.impl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import project.dao.caseDAO2;
import project.model.Bills;
import project.model.CustomerBill;
import project.model.Employee;
import project.model.Product;

public class CaseImple2 implements caseDAO2 {
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
	public List<CustomerBill> FinalBills(Bills bills) throws Exception {
		JdbcTemplate jdbctemplate=CaseImple2.getJdbcTemplate();
		String sql="select c.customer_name,b.total from customer_card c,bills b where c.customer_name=b.customer_name";
		List<CustomerBill>list=jdbctemplate.query(sql, (rs,rowNo)->{
			CustomerBill cb = new CustomerBill();
		cb.customerName=rs.getString("customer_name");
		cb.totalAmount=rs.getInt("total");
		return cb;	
		});
		return list;
		}
	
	@Override
	public int TodayIncome(LocalDate date) throws Exception {
		JdbcTemplate jdbctemplate=CaseImple2.getJdbcTemplate();
		String sql="select GET_TOTAL_AMOUNT(?)as total_amount from dual";
		Object[] params = { Date.valueOf(date) };
		int totalamount=jdbctemplate.queryForObject(sql, params , Integer.class);
		return totalamount;
	}
	@Override
	public List<Bills> CustomerCount(Bills bills) throws Exception {
		JdbcTemplate jdbctemplate=CaseImple2.getJdbcTemplate();
		String sql="select count(*) as number_of_customer,bill_date from bills group by bill_date";
		List<Bills>list=jdbctemplate.query(sql, (rs,rowNo)->{
			Bills b=new Bills();
			b.customerno=rs.getInt("number_of_customer");
			Date ds=rs.getDate("bill_date");
			LocalDate pa1=ds.toLocalDate();
			b.billdate=pa1;
			return b;	
		});
		return list;
		}
	@Override
	public int EmployeeCount(Employee employee) throws Exception {
		JdbcTemplate jdbctemplate=CaseImple2.getJdbcTemplate();
		String sql="select count(*)  from employee";
		int totalemployee=jdbctemplate.queryForObject(sql, Integer.class);
		System.out.println(totalemployee);
		return totalemployee;
		}
	@Override
	public int TotalIncome(Bills bills) throws Exception {
		JdbcTemplate jdbctemplate=CaseImple2.getJdbcTemplate();
		String sql="select sum(total)as daily_income from bills";
		int row=jdbctemplate.queryForObject(sql,  Integer.class);
		System.out.println(row);
		return row;
	}
	@Override
	public List<Product> ProductPriceBetween(int min, int max) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
