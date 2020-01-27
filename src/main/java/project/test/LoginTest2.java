package project.test;


import java.util.Scanner;

import project.dao.impl.LoginImple2;
import project.model.Login;


public class LoginTest2 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("\t\t Menu");
		System.out.println("\t\t**--**");
		System.out.println("1.Registration");
		System.out.println("2.Login");
		System.out.println("Enter u y choice");
		int choice=s.nextInt();
		switch (choice) {
		case 1:
		{
		LoginImple2 pi=new LoginImple2();
		Login log=new Login();
		System.out.println("Enter the Username");
		log.username=s.next();
		System.out.println("Enter the password");
		log.password=s.next();
		pi.add(log);
		s.close();
		}break;
		case 2:
		{
			LoginImple2 pi=new LoginImple2();
		System.out.println("Enter the username");
		String user=s.next();
		System.out.println("Enter the password");
		String pass=s.next();
			Login result = pi.login(user, pass);
			if ( result == null) {
				System.out.println("Invalid login");
			}
			else {
				System.out.println("Valid login");
			}
		}break;
		}
}
}