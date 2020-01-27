package project.test;


import java.time.LocalDate;
import java.util.Scanner;

import project.dao.impl.ProductStockImple;
import project.model.ProductStock;

public class ProductStockTest {
 	
	public static void main(String[] args) throws Exception 
	{
		int flag=1;
		Scanner s=new Scanner(System.in);
		do
		{
		System.out.println("/t Menu");
		System.out.println("1.Insert");
		System.out.println("2.Delete");
		System.out.println("3.Update");
		System.out.println("4.Display");
		System.out.println("Enter u r choice");
		int a=s.nextInt();
		switch(a)
		{
		case 1:
		{

			ProductStockImple psi=new ProductStockImple();
			ProductStock ps = new ProductStock();
			System.out.println("Enter the stock id");
			ps.stockid=s.nextInt();
			System.out.println("Enter the quantity of product");
			ps.quantity=s.nextInt();
			System.out.println("Enter the product arrival Date");
			String arrivalDate = s.next(); ///2020-01-02
			ps.productarrival=LocalDate.parse(arrivalDate);
			System.out.println("Enter the product Expiry Date");
			String experyDate = s.next(); ///2020-01-02
			ps.experydate=LocalDate.parse(experyDate);
			psi.addProductStock(ps);
			System.out.println("Insert Succesfully");
			
		}
		break;
		case 2:
		{
			ProductStockImple psi=new ProductStockImple();
			ProductStock ps = new ProductStock();
			System.out.println("Enter the product number");
			ps.productno=s.nextInt();
			psi.deleteProductStock(ps);
			System.out.println("Delete Succesfully");
		}
		break;
		case 3:
		{
			ProductStockImple psi=new ProductStockImple();
			ProductStock ps = new ProductStock();
			System.out.println("Enter the product number");
			ps.productno=s.nextInt();
			System.out.println("Enter the product Quantity");
			ps.quantity=s.nextInt();
			psi.updateProductStock(ps);
			
		}break;
		case 4:
		{
			ProductStockImple psi=new ProductStockImple();
			ProductStock ps = new ProductStock();
			psi.displayProductStock(ps);
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
	