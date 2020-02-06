package com.chainsys.supermarketapp;
import java.time.LocalDate;
import java.util.Scanner;

import com.chainsys.supermarketapp.dao.impl.ProductStockImple;
import com.chainsys.supermarketapp.model.ProductStock;
import com.chainsys.supermarketapp.util.Logger;
public class ProductStockTest {
	private static final Logger log=Logger.getInstance();
	public static void main(String[] args) throws Exception 
	{
		int flag=1;
		Scanner s=new Scanner(System.in);
		do
		{
			log.getInput("/t Menu");
			log.getInput("1.Insert");
			log.getInput("2.Delete");
			log.getInput("3.Update");
			log.getInput("4.Display");
			log.getInput("Enter u r choice");
		int a=s.nextInt();
		switch(a)
		{
		case 1:
		{

			ProductStockImple psi=new ProductStockImple();
			ProductStock ps = new ProductStock();
			log.getInput("Enter the stock id");
			ps.setStockid(s.nextInt());
			log.getInput("Enter the quantity of product");
			ps.setQuantity(s.nextInt());
			log.getInput("Enter the product arrival Date");
			String arrivalDate = s.next(); ///2020-01-02
			ps.setProductarrival(LocalDate.parse(arrivalDate));
			log.getInput("Enter the product Expiry Date");
			String experyDate = s.next(); ///2020-01-02
			ps.setExperydate(LocalDate.parse(experyDate));
			psi.addProductStock(ps);
			log.getInput("Insert Succesfully");
			
		}
		break;
		case 2:
		{
			ProductStockImple psi=new ProductStockImple();
			ProductStock ps = new ProductStock();
			log.getInput("Enter the product number");
			ps.setProductno(s.nextInt());
			psi.deleteProductStock(ps);
			log.getInput("Delete Succesfully");
		}
		break;
		case 3:
		{
			ProductStockImple psi=new ProductStockImple();
			ProductStock ps = new ProductStock();
			log.getInput("Enter the product number");
			ps.setProductno(s.nextInt());
			log.getInput("Enter the product Quantity");
			ps.setQuantity(s.nextInt());
			psi.updateProductStock(ps);
			
		}break;
		case 4:
		{
			ProductStockImple psi=new ProductStockImple();
			ProductStock ps = new ProductStock();
			psi.displayProductStock(ps);
		}	
		}
		log.getInput("Do u want to continue(y/n):press(1/0)");
		int f=s.nextInt();
		
		if(f==1)
			flag=1;
		else
			flag=0;
	}while(flag==1);
		s.close();
	}
}
	