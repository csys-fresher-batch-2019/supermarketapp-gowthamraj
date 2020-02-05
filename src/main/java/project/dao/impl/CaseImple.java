package project.dao.impl;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import project.dao.CaseDAO;
import project.model.OrderItem;
import project.model.Employee;
import project.model.Product;
import supermarket.Logger;

public class CaseImple implements CaseDAO {
	private static final Logger log=Logger.getInstance();
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");
		return con;
	}

	@Override
	public int employeeCount(Employee employee) throws Exception {
		String sql = "select count(*)  as employee_count from employee";
		try(Connection con = getConnection();Statement st1 = con.createStatement();ResultSet rs = st1.executeQuery(sql);){
		while (rs.next()) {
			int employeeCount = rs.getInt("employee_count");
			log.getInput("Total number of employee in the market  =" + employeeCount);
		}
	}
	catch(Exception e) {
		e.printStackTrace();
	}
		return 0;
	}
	@Override
	public int todayIncome(LocalDate date) throws Exception {
		String sql = "select GET_TOTAL_AMOUNT(?)as total_amount from dual";
		int amount = 0;
		try(Connection con = getConnection();PreparedStatement st = con.prepareStatement(sql);
				ResultSet rs = st.executeQuery();){
		st.setDate(1, Date.valueOf(date));
		while (rs.next()) {
			amount = rs.getInt("total_amount");
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return amount;
	}

	@Override
	public int totalIncome(OrderItem bills) throws Exception {
			String sql = "select sum(total)as daily_income from bills";
		int total=0;
		try(Connection con = getConnection();Statement st = con.createStatement();ResultSet rs = st.executeQuery(sql);){
		while (rs.next()) {
			total = rs.getInt("daily_income");
		}
	}catch(Exception e)
	{
		e.printStackTrace();
	}
		return total;
	}

	@Override
			public List<Product> productPriceBetween(int min, int max) throws Exception {
					String sql = "select * from product where price  between ? and ?";
				List<Product> list = new ArrayList<Product>();
				try(Connection con = getConnection();PreparedStatement ps = con.prepareStatement(sql);ResultSet rs = ps.executeQuery();){
				ps.setInt(1, min);
				ps.setInt(2, max);
				while (rs.next()) {
					int id = rs.getInt("product_id");
					String name = rs.getString("product_name");
					int cost = rs.getInt("price");
					log.getInput("product_id =" + id + "\t Product name =" + name + "\t price =" + cost);
					Product p = new Product();
					p.setPid(id);
					p.setProductname(name);
					p.setPrice(cost);
					list.add(p);
				}
				}catch(Exception e)
				{
					e.printStackTrace();
				}				
				return list;
			}
			
		@Override
		public List<OrderItem> customerCount(OrderItem bills) throws Exception {
			
			String sql="select count(*) as number_of_customer,ordered_date from bill_order group by ordered_date";
			List<OrderItem> list = new ArrayList<OrderItem>();
			try(Connection con=getConnection();Statement st=con.createStatement();ResultSet rs=st.executeQuery(sql);){
			while (rs.next())
			{
				int customercount=rs.getInt("number_of_customer");
				Date ar = rs.getDate("ordered_date");
				LocalDate pa1=ar.toLocalDate();
				log.getInput("Number of customer ="+customercount+"\t Date ="+pa1);
				OrderItem b=new OrderItem();
				b.setCustomerno(customercount);
				b.setBilldate(pa1);
				list.add(b);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}

			return list;
		}

		@Override
	public List<OrderItem> finalBills(OrderItem bills) throws Exception {
		return null;
		
		}

	}

