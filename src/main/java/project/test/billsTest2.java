package project.test;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import project.dao.impl.BillsImple;
import project.dao.impl.BillsImple2;
import project.model.Bills;
public class billsTest2 {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		Scanner s =new Scanner(System.in);
		 int flag=1;
			do
			{
		System.out.println("\t MENU");
		System.out.println("1.ADDING bills");
		System.out.println("2.UPDATE bills");
		System.out.println("3.DISPLAY bills");
		System.out.println("4.DELETE bills");
		System.out.println("Enter  u r choice");
		int choice=s.nextInt();
		switch(choice)
		{
		case 1:
		{
			System.out.println("\t INSERTING bills");
			BillsImple2 bi=new BillsImple2();
			Bills b=new Bills();
			System.out.println("Enter the bill date");
			String d=s.next();
			b.billdate=LocalDate.parse(d);
			System.out.println("Enter the Customer name");
			b.customername=s.next();
			System.out.println("Enter the status");
			b.status=s.next();
			bi.addbills(b);
			}break;
		case 2:
		{
			System.out.println("\t UPDATE bills");
			BillsImple bi=new BillsImple();
			Bills b=new Bills();//bill_date,cus_no,customer_name,total,status
			System.out.println("Enter the customer number");
			b.customerno=s.nextInt();
			System.out.println("Enter the total amount");
			b.total=s.nextInt();
			bi.updateBills(b);
		}break;
		case 3:
		{
			System.out.println("\t DISPLAY bills");
			BillsImple2 bi=new BillsImple2();
			List<Bills> list=bi.Displaybills();
			for (Bills b : list) {
				System.out.println(b.toString());
				}
			
			
		}break;
		case 4:
		{
			System.out.println("\t DELETE bills");
			BillsImple2 bi=new BillsImple2();
			Bills b=new Bills();
			System.out.println("Enter the customer number");
			b.customerno=s.nextInt();
			bi.deletebills(b);
		}
		}
		System.out.println("Do u want to continue 1/0 ");
		int f=s.nextInt();
		if(f==1)
			flag=1;
		else
			flag=0;
		}while(flag==1);
		
		s.close();
		}
	}
		