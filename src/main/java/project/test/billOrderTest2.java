package project.test;

import java.util.List;
import java.util.Scanner;
import project.dao.impl.BillOrderImple2;
import project.model.Billorder;

public class billOrderTest2 {
	public static void main(String[] args) throws Exception {
		int flag=1;
		Scanner s=new Scanner(System.in);
		do
		{
		System.out.println("\t Menu");
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
			BillOrderImple2 boi=new BillOrderImple2();
			Billorder bo=new Billorder();
			System.out.println("Insert bill orders");
			System.out.println("Enter the product id");
			bo.productid=s.nextInt();
			System.out.println("Enter the customer number");
			bo.customerno=s.nextInt();
			System.out.println("Enter the price");
			bo.price=s.nextFloat();
			System.out.println("Enter the quantity");
			bo.quantity=s.nextInt();
			boi.addBillOrder(bo);
			
		}
		break;
		case 2:
		{
			System.out.println("Delete bills");
		
			BillOrderImple2 boi=new BillOrderImple2();
			Billorder bo=new Billorder();
			System.out.println("Delete bill orders");
			System.out.println("Enter the p id");
			bo.proid=s.nextInt();
			boi.deleteBillOrder(bo);
		}
		break;
		case 3:
		{

			BillOrderImple2 boi=new BillOrderImple2();
			Billorder bo=new Billorder();
			System.out.println("Update bill orders");
			System.out.println("Enter the p id");
			bo.proid=s.nextInt();
			System.out.println("Enter the price");
			bo.price=s.nextFloat();
			boi.updateBillOrder(bo);
		}
		break;
		case 4:
		{

			BillOrderImple2 boi=new BillOrderImple2();

			System.out.println("Display bill orders");
			List<Billorder>list=boi.Displaybills();
			for (Billorder bior : list) {
				System.out.println(bior);
			}
			
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
	