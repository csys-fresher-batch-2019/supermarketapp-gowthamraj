package project.dao.impl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import project.dao.BillsDAO2;
import project.model.Bills;
public class BillsImple2 implements BillsDAO2 {
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
	public void addbills(Bills bills) throws Exception {
		JdbcTemplate jdbctemplate=BillsImple2.getJdbcTemplate();
		String sql="insert into bills(bill_no,bill_date,cus_no,customer_name,status)values(bill_no_sq.nextval,?,cus_no_sq.nextval,?,?)";
		Object[]params= {Date.valueOf(bills.billdate),bills.customername,bills.status};
		int row=jdbctemplate.update(sql,params);
		System.out.println(row);
}

	@Override
	public void deletebills(Bills bills) throws Exception {
		JdbcTemplate jdbctemplate=BillsImple2.getJdbcTemplate();
	String sql="Delete from bills where cus_no=?";
	int row=jdbctemplate.update(sql,bills.customerno);
	System.out.println(row);
}

	@Override
	public List<Bills> Displaybills() throws Exception {
		JdbcTemplate jdbctemplate=BillsImple2.getJdbcTemplate();
		String sql= "select bill_no,bill_date,cus_no,customer_name,total,status from bills";
		List<Bills>list=jdbctemplate.query(sql, (rs,rowNo)->{
			Bills b=new Bills();
			b.billno=rs.getInt("bill_no");
			Date ds =rs.getDate("bill_date");
			LocalDate pa=ds.toLocalDate();
			
			b.customerno=rs.getInt("cus_no");
			b.customername=rs.getString("customer_name");
			b.total=rs.getInt("total");
			b.status=rs.getString("status");
			b.billdate = pa;
			return b;
		});
		return list;
		}
	@Override
	public void updatebills(Bills bills) throws Exception {
		JdbcTemplate jdbctemplate=BillsImple2.getJdbcTemplate();
		String sql="update bills set total=? where cus_no =?";
		Object []params= {bills.total,bills.customerno};
		int row=jdbctemplate.update(sql,params);
		System.out.println(row);	
		}
}
