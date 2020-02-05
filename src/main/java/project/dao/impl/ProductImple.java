package project.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import project.dao.ProductDAO;
import project.model.Product;
import supermarket.logger;

public class ProductImple implements ProductDAO {
	private static final logger log=logger.getInstance();
	private static final boolean NULL = false;

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
		log.getInput("connection");
		return con;
	}
	@Override
	public void addproductDetails(Product product)throws Exception {
		String sql = "insert into product (product_id,product_name,price) values(pro_id.nextval,?,?)";
		try (Connection con = getConnection();PreparedStatement ps=con.prepareStatement(sql);){
		log.getInput(sql);

		
		ps.setString(1,product.getProductname() );
		ps.setInt(2,product.getPrice());
		ps.executeUpdate();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	
	}
	@Override
	public void deleteproductDetails(Product product) throws Exception {
		// TODO Auto-generated method stub
		String sql="Delete from product where product_id=?";
		try (Connection con = getConnection();PreparedStatement ps=con.prepareStatement(sql);){
				
		//Connection con=getConnection();
		//
		ps.setInt(1, product.getPid());
		ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		

		
	}
	@Override
	public List<Product> displayproduct() throws Exception {
		// TODO Auto-generated method stub
//		Connection con = getConnection();
		String sql="select product_id,product_name,price from product";
		List<Product> list = new ArrayList<Product>();
		try (Connection con = getConnection();Statement st1 =con.createStatement();
				ResultSet rs=st1.executeQuery(sql);) {
		while(rs.next()!=NULL)
		{
			Product p=new Product();
			p.setProductname(rs.getString("product_name"));
			p.setPrice(rs.getInt("price"));

			//log.getInput("Product_id =" +rs.getInt(1)+"product name = "+name+"Product price = "+cost);
			p.setPid(rs.getInt("product_id"));
			list.add(p);
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return(list);
		
	}
	
	@Override
	public void updateproduct(Product product) throws Exception {
		// TODO Auto-generated method stub
	//	Connection con=getConnection();
		String sql="update product set product_name= ? where price= ? ";
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {
		//PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1,product.getProductname());
		ps.setInt(2,product.getPrice());
		ps.executeUpdate();
	}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int getProductPrice(int productId) throws Exception {
		//Connection con=getConnection();
		String sql="select price from product where product_id=? ";
		int price=0;
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql);ResultSet rs=ps.executeQuery();) {
		//PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1,productId );
		while (rs.next())
		{
			price=rs.getInt("price");
		}
		}
		catch(Exception e) {
		e.printStackTrace();
	}

		return(price);
	}
	}
