package project.test;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import project.dao.impl.ProductStockImple2;
import project.model.ProductStock;

public class ProductStocktest2 {

	public static void main(String[] args) throws Exception {
		Scanner s =new Scanner(System.in);
		 int flag=1;
			do
			{
		System.out.println("\t MENU");
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
			System.out.println("\t INSERTING PRODUCTS");
			ProductStockImple2 pst=new ProductStockImple2();
			ProductStock ps=new ProductStock();
			System.out.println("Enter the Stock_id");
			ps.stockid=s.nextInt();
			System.out.println("Enter the Quantity");
			ps.quantity=s.nextInt();
			System.out.println("Enter the product Arrival date");
			String arrival=s.next();
			ps.productarrival=LocalDate.parse(arrival);
			System.out.println("Enter the expiry date");
			String expery=s.next();
			ps.experydate=LocalDate.parse(expery);
			pst.addproductDetails(ps);
		}break;
		case 2:
		{
			System.out.println("\t UPDATE PRODUCTS");
			ProductStockImple2 pst=new ProductStockImple2();
			ProductStock product=new ProductStock();
			System.out.println("Enter the Product Number");
			product.productno=s.nextInt();
			System.out.println("Enter the Quantity");
			product.quantity=s.nextInt();
			pst.updateproduct(product);
		}break;
		case 3:
		{
			System.out.println("\t DISPLAY PRODUCTS");
			ProductStockImple2 pst=new ProductStockImple2();
			List<ProductStock>list=pst.Displayproduct();
			for ( ProductStock  p: list) {
				System.out.println(p.toString());
			}
			
		}break;
		case 4:
		{
			System.out.println("\t DELETE PRODUCT");
			ProductStockImple2 psi=new ProductStockImple2();
			ProductStock product=new ProductStock();
			System.out.println("Enter the Product Number");
			product.productno=s.nextInt();
			psi.deleteproductDetails(product);
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
		