package project.test;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import project.dao.impl.CaseImple2;
import project.model.Bills;
import project.model.CustomerBill;
import project.model.Employee;

public class CaseTest2 {
	public static void main(String[] args) throws Exception {
		int flag = 1;
		Scanner s = new Scanner(System.in);
		do {
			System.out.println("\t menu \n");
			System.out.println("\t*-*_* \n");
			System.out.println("1.Employee Count");
			System.out.println("2.customer card holder purchase");
			System.out.println("3.Today income");
			System.out.println("4.Total Income");
			System.out.println("5.Customer purchase by date");
			System.out.println("Enter u r choice");
			int choice = s.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("\t Employee count");
				CaseImple2 ci = new CaseImple2();
				Employee e=new Employee();
				ci.EmployeeCount(e);

			}
				break;
			case 2: {
				System.out.println("\tcustomer card holder purchase\"");
				CaseImple2 ci = new CaseImple2();
				Bills b=new Bills();
				List<Bills> list=ci.CustomerCount(b);
				for (Bills bills : list) {
					System.out.println(bills);
				}
			}
				break;
			case 3: {
				System.out.println("Today income");
				CaseImple2 ci = new CaseImple2();
				System.out.println("Enter the date");
				String date = s.next();
				LocalDate la = LocalDate.parse(date);
				int amount = ci.TodayIncome(la);
				System.out.println("Today's income =" + amount);

			}
				break;
			case 4: {
				System.out.println("Total Income ");
				CaseImple2 ci = new CaseImple2();
				Bills b = new Bills();
				int total=ci.TotalIncome(b);
				System.out.println("Total income ="+total);
			}
				break;
			case 5:
			{
				System.out.println("Number of customer purchase by date ");
				CaseImple2 ci = new CaseImple2();
				Bills b=new Bills();
				List<Bills>bills=ci.CustomerCount(b);
				for (Bills bills2 : bills) {
					System.out.println("Customer Count"+bills2.customerno+"\t Date"+bills2.billdate);
				}
				
			}
			}
			
			System.out.println("Do u want to continue(y/n):press(1/0)");
			int f = s.nextInt();
			if (f == 1)
				flag = 1;
			else {
				flag = 0;
				break;
			}
		} while (flag == 1);
		s.close();

	}
}



