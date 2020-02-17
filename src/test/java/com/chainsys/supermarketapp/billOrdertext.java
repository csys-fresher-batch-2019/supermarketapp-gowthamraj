package com.chainsys.supermarketapp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import com.chainsys.supermarketapp.dao.impl.BillOrderImple;
import com.chainsys.supermarketapp.dao.impl.ProductImple;
import com.chainsys.supermarketapp.model.Order;
import com.chainsys.supermarketapp.model.OrderItem;
import com.chainsys.supermarketapp.util.Logger;

public class billOrdertext {
	private static final Logger log = Logger.getInstance();

	public static void main(String[] args) throws Exception {
		int flag = 1;
		Scanner s = new Scanner(System.in);
		do {
			log.getInput("\t Menu");
			log.getInput("1.Insert");
			log.getInput("2.cancel");
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
//					log.getInput("Enter the Status");
//					item.setStatus(s.next());
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
				log.getInput("cancel bills");
				BillOrderImple boi = new BillOrderImple();
				Order bo = new Order();
				
				log.getInput("Enter the customer number");
				bo.setOrderId(s.nextInt());
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
				
				List<Order> l=boi.displayBillOrder();
				for (Order p : l) {
					log.getInput(p.toString());
				}
				

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



