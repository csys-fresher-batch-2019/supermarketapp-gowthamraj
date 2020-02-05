package spring.test;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import spring.dao.impl.CaseImple2;
import supermarket.Logger;
import project.model.OrderItem;
import project.model.Employee;

public class CaseTest2 {
	private static final Logger log=Logger.getInstance();
	public static void main(String[] args) throws Exception {
		int flag = 1;
		Scanner s = new Scanner(System.in);
		do {
			log.getInput("\t menu \n");
			log.getInput("\t*-*_* \n");
			log.getInput("1.Employee Count");
			log.getInput("2.customer card holder purchase");
			log.getInput("3.Today income");
			log.getInput("4.Total Income");
			log.getInput("Enter u r choice");
			int choice = s.nextInt();
			switch (choice) {
			case 1: {
				log.getInput("\t Employee count");
				CaseImple2 ci = new CaseImple2();
				Employee e=new Employee();
				ci.employeeCount(e);

			}
				break;
			case 2: {
				log.getInput("\tcustomer card holder purchase\"");
				CaseImple2 ci = new CaseImple2();
				OrderItem b=new OrderItem();
				List<OrderItem> list=ci.customerCount(b);
				for (OrderItem bills : list) {
					log.getInput(bills);
				}
			}
				break;
			case 3: {
				log.getInput("Today income");
				CaseImple2 ci = new CaseImple2();
				log.getInput("Enter the date");
				String date = s.next();
				LocalDate la = LocalDate.parse(date);
				int amount = ci.todayIncome(la);
				log.getInput("Today's income =" + amount);

			}
				break;
			case 4: {
				log.getInput("Total Income ");
				CaseImple2 ci = new CaseImple2();
				OrderItem b = new OrderItem();
				int total=ci.totalIncome(b);
				log.getInput("Total income ="+total);
			}
				break;
			case 5:
			{
				log.getInput("Number of customer purchase by date ");
				CaseImple2 ci = new CaseImple2();
				OrderItem b=new OrderItem();
				List<OrderItem>bills=ci.customerCount(b);
				for (OrderItem bills2 : bills) {
					log.getInput("Customer Count"+bills2.getCustomerno()+"\t Date"+bills2.getBilldate());
				}
				
			}
			}
			
			log.getInput("Do u want to continue(y/n):press(1/0)");
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



