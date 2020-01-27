package project.test;


import java.util.List;
import java.util.Scanner;

import project.dao.impl.ProductImple;
import project.model.Product;

public class ProductTest {


	
	public static void main(String[] args) throws Exception 
	{
		Scanner s=new Scanner (System.in);

	    int flag=1;
		do
		{
		
	    System.out.println("Menu");
		System.out.println("1.Insert product");
		System.out.println("2.Delete product");
		System.out.println("3.Display product");
		System.out.println("4.Update product");
		System.out.println("Enter your choice");
		int a=s.nextInt();
		
			
		switch (a)
		{
		   
		case 1:
		{
			ProductImple pi=new ProductImple();
			Product p=new Product();
			System.out.println("Enter the product Name");
			p.productname=s.next();
			System.out.println("Enter the price");
			p.price=s.nextInt();
			pi.addproductDetails(p);
			System.out.println("Inserted Succesfully");
			break;
			
			
		}
		case 2:
		{
			ProductImple pi=new ProductImple();
			Product p=new Product();
			System.out.println("Enter the product ID to Delete");
			p.pid=s.nextInt();
			pi.deleteproductDetails(p);
			System.out.println("deleted succesfully");
		    break;
		}
		case 3:
		{
			ProductImple pi=new ProductImple();
			System.out.println("display");
			List<Product> l=pi.Displayproduct();
			for (Product p : l) {
				System.out.println(p.toString());
			}
			break;
			
		}
		case 4:
		{
			ProductImple pi=new ProductImple();
			Product p=new Product();
			System.out.println("Enter the product name");
			p.productname=s.next();
			System.out.println("Enter the price");
			p.price=s.nextInt();
			pi.updateproduct(p);
			System.out.println("update succesfully");
			break;
		}
		}
		
		System.out.println("Do u want to continue(y/n):press(1/0)");
		int f=s.nextInt();
		if(f==1)
			flag=1;
		else
			flag=0;
		
			
		
		
		
		}while(flag==1);
		
		s.close();
		}
	}


		
	
	
	