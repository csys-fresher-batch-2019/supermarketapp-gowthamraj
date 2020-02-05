package project.test;

import java.time.LocalDateTime;
import java.util.Scanner;
import project.dao.impl.BillOrderImple;
import project.dao.impl.ProductImple;
import project.model.Order;
import project.model.OrderItem;
import supermarket.Logger;

public class billOrdertext {
	private static final Logger log = Logger.getInstance();

	public static void main(String[] args) throws Exception {
		int flag = 1;
		Scanner s = new Scanner(System.in);
		do {
			log.getInput("\t Menu");
			log.getInput("1.Insert");
			log.getInput("2.Delete");
			log.getInput("3.Update");
			log.getInput("4.Display");
			log.getInput("Enter u r choice");
			int option = s.nextInt();
			
			switch (option) {
			case 1: {
				BillOrderImple boi = new BillOrderImple();
				Order bo = new Order();
				log.getInput("Insert bill orders");
				log.getInput("Enter the customer number");
				bo.setCustomerno(s.nextInt());				
				ProductImple pi=new ProductImple();
				int totalBillAmount  = 0;
				boolean completed = true;
				while (completed) {
					log.getInput("Enter the product id");
					OrderItem item = new OrderItem();
					item.setProductId(s.nextInt());
					log.getInput("Enter the Quantity");
					item.setQuantity(s.nextInt());
					int itemPrice = pi.getProductPrice(item.getProductId());
					item.setPrice(itemPrice);
					int itemTotalPrice = item.getQuantity() * item.getPrice();
					item.setTotalAmount(itemTotalPrice);
					totalBillAmount = totalBillAmount + itemTotalPrice;
					bo.addItem(item);
					log.getInput("Do you want to add more items? 1. To Add item");
					int choice = s.nextInt();
					if (choice != 1) {
						completed = false;
					}
				}
				bo.setTotalAmount(totalBillAmount);
				log.getInput("Your final bill Amount is Rs." + totalBillAmount);
				bo.setOrderedDate(LocalDateTime.now());
				boi.addBillOrder(bo);
			}
				break;
			case 2: {
				log.getInput("Delete bills");
				BillOrderImple boi = new BillOrderImple();
				Order bo = new Order();
				log.getInput("Update bill orders");
				log.getInput("Enter the customer number");
				bo.setCustomerno(s.nextInt());
				boi.deleteBillOrder(bo);

			}
				break;
			case 3: {

				BillOrderImple boi = new BillOrderImple();
				Order bo = new Order();
				log.getInput("update bill orders");
				log.getInput("Enter the customer number");
				bo.setCustomerno(s.nextInt());
				log.getInput("Enter the total amount");
				bo.setTotalAmount(s.nextInt());
				boi.updateBillOrder(bo);

			}
				break;
			case 4: {

				BillOrderImple boi = new BillOrderImple();
				Order bo = new Order();
				boi.displayBillOrder(bo);

			}

			}
			log.getInput("Do u want to continue(y/n):press(1/0)");
			int f = s.nextInt();

			if (f == 1)
				flag = 1;
			else
				flag = 0;
		} while (flag == 1);
		s.close();
	}
}



