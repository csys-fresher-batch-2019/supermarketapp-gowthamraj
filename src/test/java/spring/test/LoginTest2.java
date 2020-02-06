package spring.test;
import java.util.Scanner;
import spring.dao.impl.LoginImple2;
import supermarket.Logger;
import project.model.Login;


public class LoginTest2 {
	private static final Logger log=Logger.getInstance();
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		log.getInput("\t\t Menu");
		log.getInput("\t\t**--**");
		log.getInput("1.Registration");
		log.getInput("2.Login");
		log.getInput("Enter u y choice");
		int choice=s.nextInt();
		switch (choice) {
		case 1:
		{
		LoginImple2 pi=new LoginImple2();
		Login log1=new Login();
		log.getInput("Enter the Username");
		log1.setUsername(s.next());
		log.getInput("Enter the password");
		log1.setPassword(s.next());
		pi.add(log1);
		s.close();
		}break;
		case 2:
		{
			LoginImple2 pi=new LoginImple2();
		log.getInput("Enter the username");
		String user=s.next();
		log.getInput("Enter the password");
		String pass=s.next();
			Login result = pi.login(user, pass);
			if ( result == null) {
				log.getInput("Invalid login");
			}
			else {
				log.getInput("Valid login");
			}
		}break;
		}
}
}