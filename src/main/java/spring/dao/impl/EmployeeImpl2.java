package spring.dao.impl;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import spring1.dao.EmployeeDAO2;
import supermarket.logger;
import project.model.Employee;
public class EmployeeImpl2 implements EmployeeDAO2 {
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
	public void addEmployeeDetails(Employee e) throws Exception {
		JdbcTemplate jdbctemplate=EmployeeImpl2.getJdbcTemplate();
		String sql="insert into employee(employee_id,employee_name,dob,doj,mobile_no,address)values( emp_idd.nextval,?,?,?,?,?)";
		Object[]params= {e.getEmployeename(),Date.valueOf(e.getDob()),Date.valueOf(e.getDoj()),e.getMobileno(),e.getAddress()};
		int row=jdbctemplate.update(sql,params);
		log.getInput(row);
	}
	@Override
	public void deleteproductDetails(Employee e) throws Exception {
		JdbcTemplate jdbctemplate=EmployeeImpl2.getJdbcTemplate();
		String sql="Delete from employee where employee_id=?";
		int row=jdbctemplate.update(sql,e.getEmployeeid());
		log.getInput(row);
	}
	@Override
	public List<Employee> displayEmployeeDetails() throws Exception {
		JdbcTemplate jdbctemplate=EmployeeImpl2.getJdbcTemplate();
		String sql= "select employee_id,employee_name,dob,doj,mobile_no,address from employee";
		List<Employee>list=jdbctemplate.query(sql, (rs,rowNo)->{
			Employee e=new Employee();
			e.setEmployeeid(rs.getInt("employee_id"));
			e.setEmployeename(rs.getString("employee_name"));
			Date ds =rs.getDate("dob");
			LocalDate pa=ds.toLocalDate();
			Date ds1 =rs.getDate("doj");
			LocalDate pa1=ds1.toLocalDate();
			e.setMobileno(rs.getInt("mobile_no"));
			e.setAddress(rs.getString("Address"));
			e.setDob(pa);
			e.setDoj(pa1);
			return e;
		});
		return list;
	}
	@Override
	public void updateproduct(Employee e) throws Exception {
		JdbcTemplate jdbctemplate=EmployeeImpl2.getJdbcTemplate();
		String sql="update employee set mobile_no=? where employee_id =?";
		Object []params= {e.getMobileno(),e.getEmployeeid()};
		int row=jdbctemplate.update(sql,params);
		log.getInput(row);	
	}
}
