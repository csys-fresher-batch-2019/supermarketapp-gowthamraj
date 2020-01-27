package project.test;

import java.util.List;
import java.util.Scanner;

import project.dao.impl.ProductImple2;
import project.model.Product;

public class ProductTest2 {

	public static void main(String[] args) throws Exception {
		
	Scanner s=new Scanner (System.in);	
	 int flag=1;
		do
		{
	System.out.println("/t MENU");
	System.out.println("1.ADDING Product");
	System.out.println("2.UPDATE product");
	System.out.println("3.DISPLAY product");
	System.out.println("4.DELETE product");
	System.out.println("Enter  u r choice");
	int choice=s.nextInt();
	switch(choice)
	{
	case 1:
	{
		System.out.println("INSERTING PRODUCTS");
		ProductImple2 pi=new ProductImple2();
		Product p=new Product();
		System.out.println("Enter the product name");
		p.productname=s.next();
		System.out.println("Enter the price");
		p.price=s.nextInt();
		pi.addproductDetails(p);
	}break;
	case 2:
	{
		System.out.println("UPDATING PRODUCTS");
		ProductImple2 pi=new ProductImple2();
		Product p=new Product();
		System.out.println("Enter the product name");
		p.productname=s.next();
		System.out.println("Enter the price");
		p.price=s.nextInt();
		pi.updateproduct(p);
	}break;
	case 3:
	{
		System.out.println("DISPLAY PRODUCTS");
		ProductImple2 pi=new ProductImple2();
		List<Product> l=pi.Displayproduct();
		for (Product p : l) {
			System.out.println(p.toString());
		}
		break;
	}
	case 4:
	{

		System.out.println("DELETE PRODUCTS");
		ProductImple2 pi=new ProductImple2();
		Product p=new Product();
		System.out.println("Enter the product id");
		p.pid=s.nextInt();
		pi.deleteproductDetails(p);
	
	}
	}
	System.out.println("Do u want to continue 1/0 ");
	int f=s.nextInt();
	if(f==1)
		flag=1;
	else
		flag=0;
	}while(flag==1);
	
	s.close();
	}
}