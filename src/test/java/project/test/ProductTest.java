package project.test;


import java.util.List;
import java.util.Scanner;
import project.dao.impl.ProductImple;
import project.model.Product;
import supermarket.Logger;

public class ProductTest {	
	private static final Logger log=Logger.getInstance();
	public static void main(String[] args) throws Exception 
	{
		Scanner s=new Scanner (System.in);

	    int flag=1;
		do
		{
		
	    log.getInput("Menu");
	    log.getInput("1.Insert product");
	    log.getInput("2.Delete product");
	    log.getInput("3.Display product");
	    log.getInput("4.Update product");
	    log.getInput("Enter your choice");
		int a=s.nextInt();
		
			
		switch (a)
		{
		   
		case 1:
		{
			ProductImple pi=new ProductImple();
			Product p=new Product();
			log.getInput("Enter the product Name");
			p.setProductname(s.next());
			log.getInput("Enter the price");
			p.setPrice(s.nextInt());
			pi.addproductDetails(p);
			log.getInput("Inserted Succesfully");
			break;
			
			
		}
		case 2:
		{
			ProductImple pi=new ProductImple();
			Product p=new Product();
			log.getInput("Enter the product ID to Delete");
			p.setPid(s.nextInt());
			pi.deleteproductDetails(p);
			log.getInput("deleted succesfully");
		    break;
		}
		case 3:
		{
			ProductImple pi=new ProductImple();
			log.getInput("display");
			List<Product> l=pi.displayproduct();
			for (Product p : l) {
				log.getInput(p.toString());
			}
			break;
			
		}
		case 4:
		{
			ProductImple pi=new ProductImple();
			Product p=new Product();
			log.getInput("Enter the product name");
			p.setProductname(s.next());
			log.getInput("Enter the price");
			p.setPrice(s.nextInt());
			pi.updateproduct(p);
			log.getInput("update succesfully");
			break;
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


		
	
	
	