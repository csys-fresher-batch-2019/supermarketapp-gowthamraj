package com.chainsys.supermarketapp.client;
//import citipe.servicelayer.*;

public class Payment {
	
	private static final Long COMPANY_MOBILE_NO = 6789012340L; //use your registered wallet mobileno
	public static boolean pay(Long mobileNo , int pin, int amount) {
	
		boolean status = true;
		try {
			//UserService userService = new UserService();
			//status = userService.walletTransfer(mobileNo, COMPANY_MOBILE_NO, pin, amount);
			System.out.println(status);
		} catch (Exception e) {
			e.printStackTrace();
			status = false;
		}
        return status;
	}
	
}
