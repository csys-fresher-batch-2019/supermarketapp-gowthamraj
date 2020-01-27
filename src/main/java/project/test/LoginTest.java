package project.test;

import java.util.Scanner;

import project.dao.impl.LoginImple;
import project.model.Login;

public class LoginTest {
	
	
	public static void main(String[] args) throws Exception {
		int flag=1;
		Scanner s=new Scanner(System.in);
		do
		{
		System.out.println("\t Menu");
		System.out.println("1.Insert login usersname");
		System.out.println("2.Check");
		System.out.println("Enter u r choice");
		int a=s.nextInt();
		switch (a)
		{
		case 1:
		{
			LoginImple in=new LoginImple();
			Login log=new Login();
			System.out.println("Insert login usersname");
			log.username=s.next();
			System.out.println("Insert login password");
			log.password=s.next();
			in.add(log);		
			
		}
		case 2:
		{
			LoginImple in=new LoginImple();
			Login log=new Login();
			System.out.println(" usersname");
			log.username=s.next();
			System.out.println(" password");
			log.password=s.next();
			Login lo=in.check(log);	
			
			System.out.println("Welcome "+lo.username);
			
	
		}
			
	}
		System.out.println("Do u want to continue(y/n):press(1/0)");
		int f=s.nextInt();
		s.close();
		if(f==1)
			flag=1;
		else
			flag=0;
	}while(flag==1);
	}
}
	
		

