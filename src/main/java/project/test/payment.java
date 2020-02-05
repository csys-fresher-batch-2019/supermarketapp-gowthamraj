package project.test;
import java.util.Scanner;
import supermarket.logger;
import citipe.servicelayer.*;
import project.model.OrderItem;
public class payment 
{
	private static final logger log=logger.getInstance();
	public static void main(String[] args) 
		{
		Scanner s=new Scanner(System.in);
		int flag=1;
		do
		{
		log.error("\t PAYMENT OPTIONS");
		log.getInput("1.Payment by ATM card");
		log.getInput("2.Online payment");
		log.getInput("3.Cash on delivery");
		log.getInput("4.citipi Wallet payment");
		log.getInput("Enter u r choice");
		int  ch=s.nextInt();
		switch(ch)
		{/*
		case 1:
		{
			try{
			log.getInput("Enter the card number");
			long cn=s.nextLong();
			log.getInput("Enter the pin number");
			int pin=s.nextInt();
			
			boolean result = CreditCardService.pay(cn,pin);
			String status;
			if(result)
			{		status = "PAID";
				}
				else {
					status = "FAILED";
				}
			
			
			}
		catch (Exception e) {
			e.printStackTrace();
		}
	}break;
		case 2:
		{

			CreditCard card = new CreditCard();
			Bills b=new Bills();
			log.getInput("Enter the card number ");
			card.setCreditCardNo( s.nextLong());
			log.getInput("Enter the Expiry date");
			LocalDate ld=LocalDate.parse(s.next());
			card.setExpiryDate(ld);
			log.getInput("Enter the CVV number");
		}
			--------------card.setC
			try {
				boolean result = CreditCardService.validateCreditCard(card);
				if(result)
				{ 
					boolean payment = CreditCardService.payAmount(card,b.total,"Gk SuperMarket");
					
					if(payment)
					{
						log.getInput("Payment success");
					}
					else
					{
						log.getInput("payment failure \n");
						log.getInput("Try again !..");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
				
		break;*/
		
		case 3:
		{
			log.getInput("CASH ON DELIVERY");
			log.getInput("Enter the amount");
			int  a=s.nextInt();
			log.getInput("thanks for puchasing !..");
		}break;
		
		case 4:
		{
			OrderItem b=new OrderItem();
			log.getInput("\t WALLET PAYMENT");
			UserService userService = new UserService();
			log.getInput("Enter the mobile number");
			long mobileNumber = s.nextLong();//9999999999L;
			long originator = 6789012340L;
			log.getInput("Enter the  mpin");
			int pinNumber = s.nextInt();//1234;
			log.getInput("Enter the amount");
			float amount = s.nextFloat();
			try {
				boolean status = userService.walletTransfer(mobileNumber, originator, pinNumber, amount);
				log.getInput(status);
				if(status)
				{
					b.setStatus("DELIVERED");
				}
				else
				{
					b.setStatus("PAYMENT_PENDING");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}
}log.getInput("Do u want to continue(y/n):press(1/0)");
int f=s.nextInt();
if(f==1)
	flag=1;
else
	flag=0;
}while(flag==1);
s.close();
}
}

