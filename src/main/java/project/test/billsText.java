package project.test;

import java.time.LocalDate;
import java.util.Scanner;

import project.dao.impl.BillsImple;
import project.model.Bills;

public class billsText {

	public static void main(String[] args) throws Exception {
		int flag=1;
		Scanner s =new Scanner (System.in);
		do
		{
		System.out.println("\t bills details \n");
		System.out.println("\n 1.Add bills details \n ");
		System.out.println("\n 2.Display bills details \n");
		System.out.println("\n 3.Delete bills details\n");
		System.out.println("\n 4.Update bills details\n");
		System.out.println("Enter  u r choice");
		int choice =s.nextInt();
		switch (choice) {
		case 1:
		{
			System.out.println("Insert bill items");
		BillsImple bi=new BillsImple();
		Bills b=new Bills();//bill_date,cus_no,customer_name,total,status
		System.out.println("Enter the bill date");
		String d=s.next();
		b.billdate=LocalDate.parse(d);
		System.out.println("Enter the customer number");
		b.customerno=s.nextInt();
		System.out.println("Enter the Customer name");
		b.customername=s.next();
		System.out.println("Enter the total amount");
		b.total=s.nextInt();
		System.out.println("Enter the status");
		b.status=s.next();
		bi.addBills(b);
		}break;
		case 2:
		{
			System.out.println("display bills ");
			BillsImple bi=new BillsImple();
			Bills b=new Bills();//bill_date,cus_no,customer_name,total,status
			bi.displayBills(b);
		}break;
		case 3:
		{
			System.out.println("Delete bills ");
			BillsImple bi=new BillsImple();
			Bills b=new Bills();//bill_date,cus_no,customer_name,total,status
			System.out.println("Enter the customer name");
			b.customername=s.next();
			bi.deleteBills(b);
			
		}break;
		case 4:
		{
			System.out.println("update bills ");
			BillsImple bi=new BillsImple();
			Bills b=new Bills();//bill_date,cus_no,customer_name,total,status
			System.out.println("Enter the customer number");
			b.customerno=s.nextInt();
			System.out.println("Enter the total amount");
			b.total=s.nextInt();
			bi.updateBills(b);
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
