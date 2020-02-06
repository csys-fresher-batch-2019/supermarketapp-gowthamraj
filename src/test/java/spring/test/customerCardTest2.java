package spring.test;

import java.util.List;
import java.util.Scanner;
import spring.dao.impl.CustomerCardImple2;
import supermarket.Logger;
import project.model.customerCard;

public class customerCardTest2 {
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
			CustomerCardImple2 cci=new CustomerCardImple2();
		customerCard cc=new customerCard();
		log.getInput("Enter the customer name");
		cc.setCustomername(s.next());
		log.getInput("Enter the Customer number");
		cc.setContactnumber(s.nextLong());
		log.getInput("Enter the address");
		cc.setAddress(s.next());
		cci.addCustomerCardtDetails(cc);
		}
		break;
		case 3:
		{
			CustomerCardImple2 cci=new CustomerCardImple2();
		customerCard cc=new customerCard();
		log.getInput("Enter the mobile number");
		cc.setContactnumber(s.nextLong());
		cci.deleteCustomerCardDetails(cc);
		}break;
		case 2:
		{
			CustomerCardImple2 cci=new CustomerCardImple2();
			log.getInput("Display customer card details");
			List<customerCard>list=cci.displayCustomerCardDetails();
			for (customerCard cc : list) {
				log.getInput(cc);
			}
		
			
		}break;
		case 4:
		{
			CustomerCardImple2 cci=new CustomerCardImple2();
			customerCard cc=new  customerCard();
			log.getInput("update customer card details");
			log.getInput("Enter the customer mobile number");
			cc.setContactnumber(s.nextLong());
			log.getInput("Enter the customer name");
			cc.setCustomername(s.next());
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