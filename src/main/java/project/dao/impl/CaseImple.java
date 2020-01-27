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
import project.model.Bills;
import project.model.Employee;
import project.model.Product;

public class CaseImple implements CaseDAO {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "oracle");

		return con;
	}

	@Override
	public int EmployeeCount(Employee employee) throws Exception {
		Connection con = getConnection();
		String sql = "select count(*)  as employee_count from employee";
		Statement st1 = con.createStatement();
		ResultSet rs = st1.executeQuery(sql);
		while (rs.next()) {
			int EmployeeCount = rs.getInt("employee_count");

			System.out.println("Total number of employee in the market  =" + EmployeeCount);
		}
		con.close();

		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int TodayIncome(LocalDate date) throws Exception {
		Connection con = getConnection();
		String sql = "select GET_TOTAL_AMOUNT(?)as total_amount from dual";
		PreparedStatement st = con.prepareStatement(sql);
		st.setDate(1, Date.valueOf(date));
		ResultSet rs = st.executeQuery();
		int amount = 0;
		while (rs.next()) {
			amount = rs.getInt("total_amount");

		}

		con.close();

		return amount;
	}



	@Override
	public int TotalIncome(Bills bills) throws Exception {
		Connection con = getConnection();
		String sql = "select sum(total)as daily_income from bills";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		int total=0;
		while (rs.next()) {
			total = rs.getInt("daily_income");
		}

		con.close();

		return total;
	}

	
			@Override
			public List<Product> ProductPriceBetween(int min, int max) throws Exception {
				Connection con = getConnection();
				String sql = "select * from product where price  between ? and ?";
				List<Product> list = new ArrayList<Product>();
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, min);
				ps.setInt(2, max);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					int id = rs.getInt("product_id");
					String name = rs.getString("product_name");
					int cost = rs.getInt("price");
					System.out.println("product_id =" + id + "\t Product name =" + name + "\t price =" + cost);
					Product p = new Product();
					p.pid = id;
					p.productname = name;
					p.price = cost;
					list.add(p);
				}

				con.close();

				return list;
			}
			
		@Override
		public List<Bills> CustomerCount(Bills bills) throws Exception {
			Connection con=getConnection();
			String sql="select count(*) as number_of_customer,bill_date from bills group by bill_date";
			List<Bills> list = new ArrayList<Bills>();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while (rs.next())
			{
				int customercount=rs.getInt("number_of_customer");
				Date ar = rs.getDate("bill_date");
				LocalDate pa1=ar.toLocalDate();
				System.out.println("Number of customer ="+customercount+"\t Date ="+pa1);
				Bills b=new Bills();
				b.customerno=customercount;
				b.billdate=pa1;
				list.add(b);
			}
			con.close();

			return list;
		}

		@Override
	public List<Bills> FinalBills(Bills bills) throws Exception {
		Connection con = getConnection();
		String sql = "select customer_name,(select total from bills where customer_name=c.customer_name)as customer_card_holder_purchase from customer_card c";
		List<Bills> list = new ArrayList<Bills>();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(sql);
		while(rs.next())
		{
			String cname=rs.getString("customer_name");
			int cost=rs.getInt("customer_card_holder_purchase");
			System.out.println("Customer name ="+cname+"\t customer card holder purchase = "+cost);
			Bills b=new Bills();
			b.customername=cname;
			b.total=cost;
			list.add(b);

		}
		con.close();

		return list;
		
	}

	}

