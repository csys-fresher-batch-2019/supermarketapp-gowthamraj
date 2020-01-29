package project.dao.impl;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import project.dao.EmployeeDAO2;
import project.model.Employee;
public class EmployeeImpl2 implements EmployeeDAO2 {
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
	public void addEmployeeDetails(Employee e) throws Exception {
		JdbcTemplate jdbctemplate=EmployeeImpl2.getJdbcTemplate();
		String sql="insert into employee(employee_id,employee_name,dob,doj,mobile_no,address)values( emp_idd.nextval,?,?,?,?,?)";
		Object[]params= {e.employeename,Date.valueOf(e.dob),Date.valueOf(e.doj),e.mobileno,e.address};
		int row=jdbctemplate.update(sql,params);
		System.out.println(row);
	}
	@Override
	public void deleteproductDetails(Employee e) throws Exception {
		JdbcTemplate jdbctemplate=EmployeeImpl2.getJdbcTemplate();
		String sql="Delete from employee where employee_id=?";
		int row=jdbctemplate.update(sql,e.employeeid);
		System.out.println(row);
	}
	@Override
	public List<Employee> DisplayEmployeeDetails() throws Exception {
		JdbcTemplate jdbctemplate=EmployeeImpl2.getJdbcTemplate();
		String sql= "select employee_id,employee_name,dob,doj,mobile_no,address from employee";
		List<Employee>list=jdbctemplate.query(sql, (rs,rowNo)->{
			Employee e=new Employee();
			e.employeeid=rs.getInt("employee_id");
			e.employeename=rs.getString("employee_name");
			Date ds =rs.getDate("dob");
			LocalDate pa=ds.toLocalDate();
			Date ds1 =rs.getDate("doj");
			LocalDate pa1=ds1.toLocalDate();
			e.mobileno=rs.getInt("mobile_no");
			e.address=rs.getString("Address");
			e.dob=pa;
			e.doj=pa1;
			return e;
		});
		return list;
	}
	@Override
	public void updateproduct(Employee e) throws Exception {
		JdbcTemplate jdbctemplate=EmployeeImpl2.getJdbcTemplate();
		String sql="update employee set mobile_no=? where employee_id =?";
		Object []params= {e.mobileno,e.employeeid};
		int row=jdbctemplate.update(sql,params);
		System.out.println(row);	
	}
}
