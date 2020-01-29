package project.test;

import java.util.List;
import java.util.Scanner;
import project.dao.impl.CustomerCardImple2;
import project.model.customerCard;

public class customerCardTest2 {

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
			CustomerCardImple2 cci=new CustomerCardImple2();
		customerCard cc=new customerCard();
		System.out.println("Enter the customer name");
		cc.customername=s.next();
		System.out.println("Enter the Customer number");
		cc.contactnumber=s.nextLong();
		System.out.println("Enter the address");
		cc.address=s.next();
		cci.addCustomerCardtDetails(cc);
		}
		break;
		case 3:
		{
			CustomerCardImple2 cci=new CustomerCardImple2();
		customerCard cc=new customerCard();
		System.out.println("Enter the mobile number");
		cc.contactnumber=s.nextLong();
		cci.deleteCustomerCardDetails(cc);
		}break;
		case 2:
		{
			CustomerCardImple2 cci=new CustomerCardImple2();
			System.out.println("Display customer card details");
			List<customerCard>list=cci.DisplayCustomerCardDetails();
			for (customerCard cc : list) {
				System.out.println(cc);
			}
		
			
		}break;
		case 4:
		{
			CustomerCardImple2 cci=new CustomerCardImple2();
			customerCard cc=new  customerCard();
			System.out.println("update customer card details");
			System.out.println("Enter the customer mobile number");
			cc.contactnumber=s.nextLong();
			System.out.println("Enter the customer name");
			cc.customername=s.next();
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