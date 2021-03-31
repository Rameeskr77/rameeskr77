package InventorySystem_service;

import java.util.List;

import InventorySystem_data.DataAsccessObject;
import InventorySystem_domain.Customer;
import InventorySystem_domain.Item;
import InventorySystem_domain.Order;

public class Orderservice {
private DataAsccessObject dao;

public Orderservice(DataAsccessObject dao) {
	super();
	this.dao = dao;
}
public void addorder(Order order, List<Customer> custlist, List<Item> itemlist) {
//	for(Customer c : custlist) {
//		for(Item i : itemlist) {
//			if(c.getCustomerid()==order.getCustomerid().getCustomerid() && i.getItemid()==order.getItemid().getItemid()) {
//				
//			}
//		}
//	}
}
}
