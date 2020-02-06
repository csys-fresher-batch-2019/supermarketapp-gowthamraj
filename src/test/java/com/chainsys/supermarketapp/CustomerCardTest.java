package com.chainsys.supermarketapp;

import java.util.Scanner;

import com.chainsys.supermarketapp.dao.impl.CustomerCardImpl;
import com.chainsys.supermarketapp.model.CustomerCard;
import com.chainsys.supermarketapp.util.Logger;

public class CustomerCardTest {
	private static final Logger log=Logger.getInstance();
	public static void main(String[] args) throws Exception {
		int flag=1;
		Scanner s =new Scanner (System.in);
		do
		{
		log.getInput("\t Customer card details \n");
		log.getInput("\n 1.Add csutomer card details \n ");
		log.getInput("\n 2.Display customer card details \n");
		log.getInput("\n 3.Delete customer card details\n");
		log.getInput("\n 4.Update customer card details\n");
		log.getInput("Enter  u r choice");
		int choice =s.nextInt();
		switch (choice) {
		case 1:
		{
			log.getInput("Insert customer card details");
		CustomerCardImpl cci=new CustomerCardImpl();
		CustomerCard cc=new CustomerCard();
		log.getInput("Enter the customer name");
		cc.setCustomername(s.next());
		log.getInput("Enter the Customer number");
		cc.setContactnumber(s.nextLong());
		log.getInput("Enter the address");
		cc.setAddress(s.next());
		cci.addCustomerCard(cc);
		}
		break;
		case 3:
		{
		CustomerCardImpl cci=new CustomerCardImpl();
		CustomerCard cc=new CustomerCard();
		log.getInput("Enter the customer name");
		cc.setCustomername(s.next());
		cci.deleteCustomerCard(cc);
		}break;
		case 2:
		{

			CustomerCardImpl cci=new CustomerCardImpl();
			CustomerCard cc=new CustomerCard();
			log.getInput("Display customer card details");
			cci.displayCustomerCard(cc);
		
			
		}break;
		case 4:
		{
			CustomerCardImpl cci=new CustomerCardImpl();
			CustomerCard cc=new CustomerCard();
			log.getInput("update customer card details");
			log.getInput("Enter the customer name");
			cc.setCustomername(s.next());
			log.getInput("Enter the customer address");
			cc.setAddress(s.next());
			cci.updateCustomerCard(cc);
			
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