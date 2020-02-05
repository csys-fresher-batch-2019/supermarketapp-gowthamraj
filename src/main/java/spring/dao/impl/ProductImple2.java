package spring.dao.impl;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import spring1.dao.productDAO2;
import supermarket.logger;
import project.model.Product;

public class ProductImple2 implements productDAO2 {
	private static final logger log=logger.getInstance();
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
	public void addproductDetails(Product product) throws Exception {
		JdbcTemplate jdbctemplate=ProductImple2.getJdbcTemplate();
		String sql="insert into product (product_id,product_name,price) values(pro_id.nextval,?,?)";
		int row=jdbctemplate.update(sql,product.getProductname(),product.getPrice());
		log.getInput(row);
	}
	@Override
	public List<Product> displayproduct() throws Exception {
		JdbcTemplate jdbctemplate=ProductImple2.getJdbcTemplate();
		String sql= "select  product_id,product_name,price from product";
		List<Product>list=new ArrayList<Product>();
		list=jdbctemplate.query(sql, (rs,rowNo)->{
			Product p = new Product();
			p.setPid(rs.getInt("product_id"));
			p.setProductname(rs.getString("product_name"));
			p.setPrice(rs.getInt("price"));
			return p;
		});
		return list;
	}

	@Override
	public void updateproduct(Product product) throws Exception {
		JdbcTemplate jdbctemplate=ProductImple2.getJdbcTemplate();
		String sql="update product set product_name= ? where price= ?";
		int row=jdbctemplate.update(sql,product.getProductname(),product.getPrice());
		log.getInput(row);
	}

	@Override
	public void deleteproductDetails(Product product) throws Exception {
		JdbcTemplate jdbctemplate=ProductImple2.getJdbcTemplate();
		String sql="Delete from product where product_id=?";
		int row=jdbctemplate.update(sql,product.getPid());
		log.getInput(row);	
	}
}
