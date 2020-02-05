package project.test;
import java.util.Scanner;

import project.dao.impl.LoginImple;
import project.model.Login;
import supermarket.logger;

public class LoginTest {
	private static final logger log=logger.getInstance();	
	public static void main(String[] args) throws Exception {
		int flag=1;
		Scanner s=new Scanner(System.in);
		do
		{
		log.getInput("\t Menu");
		log.getInput("1.Insert login usersname");
		log.getInput("2.Check");
		log.getInput("Enter u r choice");
		int a=s.nextInt();
		switch (a)
		{
		case 1:
		{
			LoginImple in=new LoginImple();
			Login log1=new Login();
			log.getInput("Insert login usersname");
			log1.setUsername(s.next());
			log.getInput("Insert login password");
			log1.setPassword(s.next());
			in.add(log1);		
			
		}
		case 2:
		{
			LoginImple in=new LoginImple();
			Login log1=new Login();
			log.getInput(" usersname");
			log1.setUsername(s.next());
			log.getInput(" password");
			log1.setPassword(s.next());
			Login lo=in.check(log1);	
			
			log.getInput("Welcome "+lo.getUsername());
		}
			
	}
		log.getInput("Do u want to continue(y/n):press(1/0)");
		int f=s.nextInt();
		s.close();
		if(f==1)
			flag=1;
		else
			flag=0;
	}while(flag==1);
	}
}
	
		

