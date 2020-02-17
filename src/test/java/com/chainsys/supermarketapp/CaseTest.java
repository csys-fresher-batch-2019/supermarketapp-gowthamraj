package com.chainsys.supermarketapp;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.chainsys.supermarketapp.dao.impl.CaseImple;
import com.chainsys.supermarketapp.model.OrderItem;
import com.chainsys.supermarketapp.util.Logger;

public class CaseTest {
	private static final Logger log=Logger.getInstance();
	public static void main(String[] args) throws Exception {
		int flag = 1;
		Scanner s = new Scanner(System.in);
		do {
			log.getInput("\t menu \n");
			log.getInput("\t*-*_* \n");
			log.getInput("1.Employee Count");
			//log.getInput("2.Product Price Between");
			//log.getInput("2.customer card holder purchase");
			log.getInput("2.Today income");
			log.getInput("3.Total Income");
			log.getInput("5.Number of customer purchase by date");
			log.getInput("6");
			log.getInput("Enter u r choice");
			int choice = s.nextInt();
			switch (choice) {
			case 1: {
				log.getInput("\t Employee count");
				CaseImple ci = new CaseImple();
					ci.employeeCount();

			}
				break;/*
			case 2: {
				log.getInput("\t Product price choose this-to-this");
				CaseImple ci = new CaseImple();
				log.getInput("Enter the minimum price");
				int price = s.nextInt();
				log.getInput("Enter the max price");
				int price1 = s.nextInt();
				List<Product> products = ci.ProductPriceBetween(price, price1);
				for (Product product : products) {
					log.getInput(product);
				}
			}
				break;*/
			case 6: {
				log.getInput("\tcustomer card holder purchase\"");
				CaseImple ci = new CaseImple();
				OrderItem b=new OrderItem();
				log.getInput(b.getCustomerno());
				List<OrderItem>bil=ci.customerCount(b);
				for (OrderItem orderItem : bil) {
					
				
					log.getInput(orderItem.getCustomername() +""+orderItem.getTotalAmount());
				}

			}
				break;
			case 2: {
				CaseImple ci = new CaseImple();
				log.getInput("Enter the date");
				String date = s.next();
				LocalDate la = LocalDate.parse(date);
				int amount = ci.todayIncome(la);
				log.getInput("Today's income =" + amount);

			}
				break;
			case 3: {
				log.getInput("Total Income ");
				CaseImple ci = new CaseImple();
				OrderItem b = new OrderItem();
				int total=ci.totalIncome(b);
				log.getInput("Total income ="+total);
			}
				break;
			case 5:
			{
				log.getInput("Number of customer purchase by date ");
				CaseImple ci = new CaseImple();
				OrderItem b=new OrderItem();
				List<OrderItem>bills=ci.customerCount(b);
				for (OrderItem bills2 : bills) {
					log.getInput(bills2.getCustomerno()+""+bills2.getBilldate());
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
