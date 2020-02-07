package com.chainsys.supermarketapp.client;
//import citipe.servicelayer.*;

import com.chainsys.supermarketapp.util.Logger;

public class Payment {
	private static final Logger log = Logger.getInstance();
	private static final Long COMPANY_MOBILE_NO = 6789012340L; //use your registered wallet mobileno
	public static boolean pay(Long mobileNo , int pin, int amount) {
	
		boolean status = true;
		try {
			//UserService userService = new UserService();
			//status = userService.walletTransfer(mobileNo, COMPANY_MOBILE_NO, pin, amount);
			System.out.println(status);
		} catch (Exception e) {
			log.error(e);
			status = false;
		}
        return status;
	}
	
}
