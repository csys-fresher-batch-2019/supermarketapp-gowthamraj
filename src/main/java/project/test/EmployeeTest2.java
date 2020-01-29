package project.test;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import project.dao.impl.EmployeeImpl2;
import project.model.Employee;

public class EmployeeTest2 {
	public static void main(String[] args) throws Exception {
		int flag=1;
		Scanner s =new Scanner (System.in);
		do
		{
		System.out.println("\t Employee details \n");
		System.out.println("\n 1.Add employee details \n ");
		System.out.println("\n 2.Display employee details \n");
		System.out.println("\n 3.Delete employee details\n");
		System.out.println("\n 4.Update employee details\n");
		System.out.println("Enter  u r choice");
		int choice =s.nextInt();
		switch (choice) {
		case 1:
		{
			System.out.println("\t Insert \n");
			EmployeeImpl2 ei=new EmployeeImpl2();
			Employee em=new Employee();
			
			System.out.println("Enter the Employee Name");
			em.employeename=s.next();
			System.out.println("Enter the Date Of birth");
			String dateofbirth=s.next();
			em.dob=LocalDate.parse(dateofbirth);
			System.out.println("Enter the date of joining");
			String dateofjoining=s.next();
			em.doj=LocalDate.parse(dateofjoining);
			System.out.println("Enter the mobile number");
			em.mobileno=(int) s.nextLong();
			System.out.println("Enter the address");
			em.address=s.next();
			ei.addEmployeeDetails(em);
			System.out.println("Insert successfully");
		}	
			break;
		case 2:
		{
		System.out.println("\n\t Display employee details \n");
		System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
		System.out.println("\t select \n");
		EmployeeImpl2 ei=new EmployeeImpl2();
		List<Employee>list=ei.DisplayEmployeeDetails();
		for (Employee emp : list) {
			System.out.println(emp);
		}
		}break;
		case 3:
		{
			System.out.println("\n\t Delete employee details \n");
			System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			EmployeeImpl2 ei=new EmployeeImpl2();
			Employee em=new Employee();
			System.out.println("Enter the Employee id");
			em.employeeid=s.nextInt();
			ei.deleteproductDetails(em);
						
		}break;
		case 4:
		{
			System.out.println("\n\t Update employee details \n");
			System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			EmployeeImpl2 ei=new EmployeeImpl2();
			Employee em=new Employee();
			System.out.println("Enter the Employee id");
			em.employeeid=s.nextInt();
			System.out.println("Enter the Employee mobile number");
			em.mobileno=s.nextInt();
			ei.updateproduct(em);
			}
		}	System.out.println("Do u want to continue(y/n):press(1/0)");
		int f=s.nextInt();
		
		if(f==1)
			flag=1;
		else
			flag=0;
	}while(flag==1);
		s.close();
	}
}
