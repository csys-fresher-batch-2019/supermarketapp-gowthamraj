package project.dao.impl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import project.dao.ProductStockDAO2;
import project.model.ProductStock;

public class ProductStockImple2 implements ProductStockDAO2 {
	
	public static JdbcTemplate getjdbcTemplate()
	{
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		ds.setUsername("system");
		ds.setPassword("oracle");
		JdbcTemplate jt=new JdbcTemplate();
		jt.setDataSource(ds);
		return jt;
		
	}

	@Override
	public void addproductDetails(ProductStock product) throws Exception {
		JdbcTemplate jdbcTemplate =ProductStockImple2.getjdbcTemplate();
		String sql="insert into product_stock (product_no,stock_id,quantity,product_arrival,expery_date)values(pro_no.nextval,?,?,?,?)";
		Object[] params = {product.stockid,product.quantity,Date.valueOf(product.productarrival),Date.valueOf(product.experydate)};
		int row=jdbcTemplate.update(sql,params);
		System.out.println(row);

	}

	@Override
	public void deleteproductDetails(ProductStock product) throws Exception {
		JdbcTemplate jdbctemplate=ProductImple2.getJdbcTemplate();
		String sql="delete from product_stock where product_no=?";
		Object[] params= {product.productno};
		int row=jdbctemplate.update(sql,params);
		System.out.println(row);
	}

	@Override
	public List<ProductStock> Displayproduct() throws Exception {JdbcTemplate jdbctemplate=ProductImple2.getJdbcTemplate();
	String sql= "select  product_no,stock_id,quantity,product_arrival,expery_date from product_stock";
	List<ProductStock>list=jdbctemplate.query(sql,(rs,rowNo)->{
		ProductStock p = new ProductStock();
		p.productno=rs.getInt("product_no");
		p.stockid=rs.getInt("stock_id");
		p.quantity=rs.getInt("quantity");
		Date ds=rs.getDate("product_arrival");
		LocalDate pa1=ds.toLocalDate();
		p.productarrival=pa1;
		Date ds1=rs.getDate("product_arrival");
		LocalDate pa=ds1.toLocalDate();
		p.experydate=pa;
		return p;

	});
	return list;
	}

	@Override
	public void updateproduct(ProductStock product) throws Exception {
		JdbcTemplate jdbctemplate=ProductImple2.getJdbcTemplate();
		String sql="update product_stock set  quantity=? where product_no=?";
		Object[] params= {product.quantity,product.productno};
		int row=jdbctemplate.update(sql,params);
		System.out.println(row);
		// TODO Auto-generated method stub

	}

}
