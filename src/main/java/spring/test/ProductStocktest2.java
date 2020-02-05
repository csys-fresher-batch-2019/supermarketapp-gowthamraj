package spring.test;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import spring.dao.impl.ProductStockImple2;
import supermarket.logger;
import project.model.ProductStock;

public class ProductStocktest2 {
	private static final logger log=logger.getInstance();
	public static void main(String[] args) throws Exception {
		Scanner s =new Scanner(System.in);
		 int flag=1;
			do
			{
		log.getInput("\t MENU");
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
			log.getInput("\t INSERTING PRODUCTS");
			ProductStockImple2 pst=new ProductStockImple2();
			ProductStock ps=new ProductStock();
			log.getInput("Enter the Stock_id");
			ps.setStockid(s.nextInt());
			log.getInput("Enter the Quantity");
			ps.setQuantity(s.nextInt());
			log.getInput("Enter the product Arrival date");
			String arrival=s.next();
			ps.setProductarrival(LocalDate.parse(arrival));
			log.getInput("Enter the expiry date");
			String expery=s.next();
			ps.setExperydate(LocalDate.parse(expery));
			pst.addproductDetails(ps);
		}break;
		case 2:
		{
			log.getInput("\t UPDATE PRODUCTS");
			ProductStockImple2 pst=new ProductStockImple2();
			ProductStock product=new ProductStock();
			log.getInput("Enter the Product Number");
			product.setProductno(s.nextInt());
			log.getInput("Enter the Quantity");
			product.setQuantity(s.nextInt());
			pst.updateproduct(product);
		}break;
		case 3:
		{
			log.getInput("\t DISPLAY PRODUCTS");
			ProductStockImple2 pst=new ProductStockImple2();
			List<ProductStock>list=pst.displayproduct();
			for ( ProductStock  p: list) {
				log.getInput(p.toString());
			}
			
		}break;
		case 4:
		{
			log.getInput("\t DELETE PRODUCT");
			ProductStockImple2 psi=new ProductStockImple2();
			ProductStock product=new ProductStock();
			log.getInput("Enter the Product Number");
			product.setProductno(s.nextInt());
			psi.deleteproductDetails(product);
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
		