package project.dao.impl;
import java.util.List;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import project.dao.BillOrderDAO2;
import project.model.Billorder;

public class BillOrderImple2 implements BillOrderDAO2 {
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
	public void addBillOrder(Billorder billorder) throws Exception {	
		JdbcTemplate jdbctemplate=BillOrderImple2.getJdbcTemplate();
	String sql="insert into bill_order(p_id,product_id,customer_no,quantity,price)values(pr_idd_sq.nextval,?,?,?,?)";
	Object[]params= {billorder.productid,billorder.customerno,billorder.quantity,billorder.price};
	int row=jdbctemplate.update(sql,params);
	System.out.println(row);

	String sql1="update bills set total=(select sum(price) from bill_order where customer_no=?) where cus_no=?";
	Object[]param= {billorder.customerno,billorder.customerno};
	int row1=jdbctemplate.update(sql1,param);



	}

	@Override
	public List<Billorder> Displaybills() throws Exception {
		JdbcTemplate jdbctemplate=BillOrderImple2.getJdbcTemplate();
		String sql= "select p_id,product_id,customer_no,quantity,price from bill_order";
		List<Billorder>list=jdbctemplate.query(sql, (rs,rowNo)->{
			Billorder b=new Billorder();
			b.proid=rs.getInt("p_id");
			b.productid=rs.getInt("product_id");
			b.customerno=rs.getInt("customer_no");
			b.quantity=rs.getInt("quantity");
			b.price=rs.getInt("price");
			return b;
		});
		return list;
	}

	@Override
	public void updateBillOrder(Billorder billorder) throws Exception {
		JdbcTemplate jdbctemplate=BillOrderImple2.getJdbcTemplate();
		String sql="update bill_order set price=? where p_id =?";
		Object []params= {billorder.price,billorder.proid};
		int row=jdbctemplate.update(sql,params);
		System.out.println(row);	
		}

	@Override
	public void deleteBillOrder(Billorder billorder) throws Exception {
		JdbcTemplate jdbctemplate=BillOrderImple2.getJdbcTemplate();
		String sql="delete from bill_order where p_id=?";
		int row=jdbctemplate.update(sql,billorder.proid);
		System.out.println(row);
	}

}
