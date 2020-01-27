package project.test;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import project.dao.impl.CaseImple;
import project.model.Bills;
import project.model.Employee;

public class CaseTest {

	public static void main(String[] args) throws Exception {
		int flag = 1;
		Scanner s = new Scanner(System.in);
		do {
			System.out.println("\t menu \n");
			System.out.println("\t*-*_* \n");
			System.out.println("1.Employee Count");
			//System.out.println("2.Product Price Between");
			System.out.println("2.customer card holder purchase");
			System.out.println("3.Today income");
			System.out.println("4.Total Income");
			System.out.println("5.Customer purchase by date");
			System.out.println("Enter u r choice");
			int choice = s.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("\t Employee count");
				CaseImple ci = new CaseImple();
				Employee e = new Employee();
				ci.EmployeeCount(e);

			}
				break;/*
			case 2: {
				System.out.println("\t Product price choose this-to-this");
				CaseImple ci = new CaseImple();
				System.out.println("Enter the minimum price");
				int price = s.nextInt();
				System.out.println("Enter the max price");
				int price1 = s.nextInt();
				List<Product> products = ci.ProductPriceBetween(price, price1);
				for (Product product : products) {
					System.out.println(product);
				}
			}
				break;*/
			case 2: {
				System.out.println("\tcustomer card holder purchase\"");
				CaseImple ci = new CaseImple();
				Bills b=new Bills();
				List<Bills>bills=ci.FinalBills(b );
				for (Bills bills2 : bills) {
					System.out.println(bills2.customername +""+bills2.total);
				}

			}
				break;
			case 3: {
				System.out.println("Today income");
				CaseImple ci = new CaseImple();
				System.out.println("Enter the date");
				String date = s.next();
				LocalDate la = LocalDate.parse(date);
				int amount = ci.TodayIncome(la);
				System.out.println("Today's income =" + amount);

			}
				break;
			case 4: {
				System.out.println("Total Income ");
				CaseImple ci = new CaseImple();
				Bills b = new Bills();
				int total=ci.TotalIncome(b);
				System.out.println("Total income ="+total);
			}
				break;
			case 5:
			{
				System.out.println("Number of customer purchase by date ");
				CaseImple ci = new CaseImple();
				Bills b=new Bills();
				List<Bills>bills=ci.CustomerCount(b);
				for (Bills bills2 : bills) {
					System.out.println(bills2.customerno+""+bills2.billdate);
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
