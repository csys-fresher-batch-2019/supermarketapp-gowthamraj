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

public class ProductImple implements ProductDAO {

	private static final boolean NULL = false;

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
		System.out.println("connection");
		return con;
	}
	@Override
	public void addproductDetails(Product product)throws Exception {
		String sql = "insert into product (product_id,product_name,price) values(pro_id.nextval,?,?)";
		System.out.println(sql);

		Connection con = getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1,product.productname );
		ps.setInt(2,product.price);
		ps.executeUpdate();
		// TODO Auto-generated method stub
		con.close();

	}
	@Override
	public void deleteproductDetails(Product product) throws Exception {
		// TODO Auto-generated method stub
		String sql="Delete from product where product_id=?";
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, product.pid);
		ps.executeUpdate();
		con.close();

		
	}
	@Override
	public List<Product> Displayproduct() throws Exception {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		String sql="select product_id,product_name,price from product";
		List<Product> list = new ArrayList<Product>();
		Statement st1 =con.createStatement();
		ResultSet rs=st1.executeQuery(sql);
		while(rs.next()!=NULL)
		{
			Product p=new Product();

			p.productname=rs.getString("product_name");
			p.price=rs.getInt("price");
			
			//System.out.println("Product_id =" +rs.getInt(1)+"product name = "+name+"Product price = "+cost);
			p.pid=rs.getInt("product_id");
			
			
			list.add(p);
		}
		
		
		
		con.close();
		return(list);
	
	}
	
	@Override
	public void updateproduct(Product product) throws Exception {
		// TODO Auto-generated method stub
		Connection con=getConnection();
		String sql="update product set product_name= ? where price= ? ";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1,product.productname);
		ps.setInt(2,product.price);
		ps.executeUpdate();
		con.close();

	}
	
	

}
