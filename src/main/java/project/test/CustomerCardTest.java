package project.test;

import java.util.Scanner;

import project.dao.impl.CustomerCardImpl;
import project.model.customerCard;

public class CustomerCardTest {

	public static void main(String[] args) throws Exception {
		int flag=1;
		Scanner s =new Scanner (System.in);
		do
		{
		System.out.println("\t Customer card details \n");
		System.out.println("\n 1.Add csutomer card details \n ");
		System.out.println("\n 2.Display customer card details \n");
		System.out.println("\n 3.Delete customer card details\n");
		System.out.println("\n 4.Update customer card details\n");
		System.out.println("Enter  u r choice");
		int choice =s.nextInt();
		switch (choice) {
		case 1:
		{
			System.out.println("Insert customer card details");
		CustomerCardImpl cci=new CustomerCardImpl();
		customerCard cc=new customerCard();
		System.out.println("Enter the customer name");
		cc.customername=s.next();
		System.out.println("Enter the Customer number");
		cc.contactnumber=s.nextLong();
		System.out.println("Enter the address");
		cc.address=s.next();
		cci.addCustomerCard(cc);
		}
		break;
		case 3:
		{
		CustomerCardImpl cci=new CustomerCardImpl();
		customerCard cc=new customerCard();
		System.out.println("Enter the customer name");
		cc.customername=s.next();
		cci.deleteCustomerCard(cc);
		}break;
		case 2:
		{

			CustomerCardImpl cci=new CustomerCardImpl();
			customerCard cc=new customerCard();
			System.out.println("Display customer card details");
			cci.displayCustomerCard(cc);
		
			
		}break;
		case 4:
		{
			CustomerCardImpl cci=new CustomerCardImpl();
			customerCard cc=new customerCard();
			System.out.println("update customer card details");
			System.out.println("Enter the customer name");
			cc.customername=s.next();
			System.out.println("Enter the customer address");
			cc.address=s.next();
			cci.updateCustomerCard(cc);
			
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