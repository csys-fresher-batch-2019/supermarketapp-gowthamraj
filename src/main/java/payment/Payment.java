package payment;

import citipe.servicelayer.UserService;
import supermarket.Logger;

public class Payment {
	
	private static final Long COMPANY_MOBILE_NO = 6789012340L; //use your registered wallet mobileno
	private static final Logger log = Logger.getInstance();
	public static boolean pay(Long mobileNo , int pin, int amount) {
		boolean status=true ;
	try {
			UserService userService = new UserService();

			status = userService.walletTransfer(mobileNo, COMPANY_MOBILE_NO, pin, amount);
			System.out.println(status);
		} catch (Exception e) 
	{
			log.error(e);			
			status = false;
		}
        return status;
	}
	
}
