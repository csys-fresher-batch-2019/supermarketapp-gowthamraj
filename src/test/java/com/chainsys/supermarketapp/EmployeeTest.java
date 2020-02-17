package com.chainsys.supermarketapp;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.chainsys.supermarketapp.dao.impl.EmployeeImpl;
import com.chainsys.supermarketapp.model.Employee;
import com.chainsys.supermarketapp.util.Logger;

public class EmployeeTest {

	
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
			EmployeeImpl ei=new EmployeeImpl();
			Employee em=new Employee();
			log.getInput("Enter the EmployeeId ");
			em.setEmployeeid(s.nextInt());
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
			ei.addEmployeeDetils(em);
			log.getInput("Insert successfully");
		}	
			break;
		case 2:
		{
		log.getInput("\n\t Display employee details \n");
		log.getInput("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
		log.getInput("\t select \n");
		EmployeeImpl ei=new EmployeeImpl();
	
		List <Employee>ee=ei.displayEmployeeDetils();
		for (Employee employee : ee) {
			log.getInput(employee.toString());
		}
		}break;
		case 3:
		{
			log.getInput("\n\t Delete employee details \n");
			log.getInput("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			EmployeeImpl ei=new EmployeeImpl();
			Employee em=new Employee();
			log.getInput("Enter the Employee name");
			em.setEmployeename(s.next());
			ei.deleteEmployeeDetils(em);
						
		}break;
		case 4:
		{
			log.getInput("\n\t Update employee details \n");
			log.getInput("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			EmployeeImpl ei=new EmployeeImpl();
			Employee em=new Employee();
			log.getInput("Enter the Employee name");
			em.setEmployeename(s.next());
			log.getInput("Enter the Employee Address");
			em.setAddress(s.next());
			ei.updateEmployeeDetils(em);
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
