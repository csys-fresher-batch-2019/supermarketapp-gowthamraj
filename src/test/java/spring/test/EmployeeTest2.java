package spring.test;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import spring.dao.impl.EmployeeImpl2;
import supermarket.Logger;
import project.model.Employee;

public class EmployeeTest2 {
	private static final Logger log=Logger.getInstance();
	public static void main(String[] args) throws Exception {
		int flag=1;
		Scanner s =new Scanner (System.in);
		do
		{
		log.getInput("\t Employee details \n");
		log.getInput("\n 1.Add employee details \n ");
		log.getInput("\n 2.Display employee details \n");
		log.getInput("\n 3.Delete employee details\n");
		log.getInput("\n 4.Update employee details\n");
		log.getInput("Enter  u r choice");
		int choice =s.nextInt();
		switch (choice) {
		case 1:
		{
			log.getInput("\t Insert \n");
			EmployeeImpl2 ei=new EmployeeImpl2();
			Employee em=new Employee();
			
			log.getInput("Enter the Employee Name");
			em.setEmployeename(s.next());
			log.getInput("Enter the Date Of birth");
			String dateofbirth=s.next();
			em.setDob(LocalDate.parse(dateofbirth));
			log.getInput("Enter the date of joining");
			String dateofjoining=s.next();
			em.setDoj(LocalDate.parse(dateofjoining));
			log.getInput("Enter the mobile number");
			em.setMobileno((int) s.nextLong());
			log.getInput("Enter the address");
			em.setAddress(s.next());
			ei.addEmployeeDetails(em);
			log.getInput("Insert successfully");
		}	
			break;
		case 2:
		{
		log.getInput("\n\t Display employee details \n");
		log.getInput("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
		log.getInput("\t select \n");
		EmployeeImpl2 ei=new EmployeeImpl2();
		List<Employee>list=ei.displayEmployeeDetails();
		for (Employee emp : list) {
			log.getInput(emp);
		}
		}break;
		case 3:
		{
			log.getInput("\n\t Delete employee details \n");
			log.getInput("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			EmployeeImpl2 ei=new EmployeeImpl2();
			Employee em=new Employee();
			log.getInput("Enter the Employee id");
			em.setEmployeeid(s.nextInt());
			ei.deleteproductDetails(em);
						
		}break;
		case 4:
		{
			log.getInput("\n\t Update employee details \n");
			log.getInput("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			EmployeeImpl2 ei=new EmployeeImpl2();
			Employee em=new Employee();
			log.getInput("Enter the Employee id");
			em.setEmployeeid(s.nextInt());
			log.getInput("Enter the Employee mobile number");
			em.setMobileno(s.nextInt());
			ei.updateproduct(em);
			}
		}	log.getInput("Do u want to continue(y/n):press(1/0)");
		int f=s.nextInt();
		
		if(f==1)
			flag=1;
		else
			flag=0;
	}while(flag==1);
		s.close();
	}
}
