package spring.test;

import java.util.List;
import java.util.Scanner;
import spring.dao.impl.ProductImple2;
import supermarket.logger;
import project.model.Product;

public class ProductTest2 {
	private static final logger log=logger.getInstance();
	public static void main(String[] args) throws Exception {
		
	Scanner s=new Scanner (System.in);	
	 int flag=1;
		do
		{
	log.getInput("/t MENU");
	log.getInput("1.ADDING Product");
	log.getInput("2.UPDATE product");
	log.getInput("3.DISPLAY product");
	log.getInput("4.DELETE product");
	log.getInput("Enter  u r choice");
	int choice=s.nextInt();
	switch(choice)
	{
	case 1:
	{
		log.getInput("INSERTING PRODUCTS");
		ProductImple2 pi=new ProductImple2();
		Product p=new Product();
		log.getInput("Enter the product name");
		p.setProductname(s.next());
		log.getInput("Enter the price");
		p.setPrice(s.nextInt());
		pi.addproductDetails(p);
	}break;
	case 2:
	{
		log.getInput("UPDATING PRODUCTS");
		ProductImple2 pi=new ProductImple2();
		Product p=new Product();
		log.getInput("Enter the product name");
		p.setProductname(s.next());
		log.getInput("Enter the price");
		p.setPrice(s.nextInt());
		pi.updateproduct(p);
	}break;
	case 3:
	{
		log.getInput("DISPLAY PRODUCTS");
		ProductImple2 pi=new ProductImple2();
		List<Product> l=pi.displayproduct();
		for (Product p : l) {
			log.getInput(p.toString());
		}
		break;
	}
	case 4:
	{

		log.getInput("DELETE PRODUCTS");
		ProductImple2 pi=new ProductImple2();
		Product p=new Product();
		log.getInput("Enter the product id");
		p.setPid(s.nextInt());
		pi.deleteproductDetails(p);
	
	}
	}
	log.getInput("Do u want to continue 1/0 ");
	int f=s.nextInt();
	if(f==1)
		flag=1;
	else
		flag=0;
	}while(flag==1);
	
	s.close();
	}
}