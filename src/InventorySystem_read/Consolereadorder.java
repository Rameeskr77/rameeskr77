package InventorySystem_read;

import java.util.Scanner;

import InventorySystem_domain.Customer;
import InventorySystem_domain.Item;
import InventorySystem_domain.Order;
import InventorySystem_service.Customerservice;
import InventorySystem_service.itemservice;

public class Consolereadorder {
private Scanner cosoleread;

public Order bildorder( Customerservice cs,itemservice is) {
	cosoleread=new Scanner(System.in);
	Order order=new Order();
	askorderid(order);
	askcustomerid(order,cs);
	askitemid(order,is);
	return order;
}
public void askorderid(Order order) {
	System.out.println("Enter the orderid:");
	order.setOrderid(cosoleread.nextInt());
}
public void askcustomerid(Order order, Customerservice cs) {
	Customer cust=new Customer();
//	Customerservice cs=new Customerservice(null);
	System.out.println("listing customer.....");
	cs.findallcust();
	System.out.println("Enter the Customerid");
	cust.setCustomerid(cosoleread.nextInt());
	order.setCustomerid(cust);
}
public void askitemid(Order order, itemservice is) {
	Item item = new Item();
	System.out.println("listing item.......");
	is.findall();
	System.out.println("Enter the item id");
	item.setItemid(cosoleread.nextInt());
	order.setItemid(item);
}
}
