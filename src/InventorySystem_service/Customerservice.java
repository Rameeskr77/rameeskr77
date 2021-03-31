package InventorySystem_service;

import java.util.ArrayList;
import java.util.List;

import InventorySystem_data.DataAsccessObject;
import InventorySystem_domain.Customer;
import InventorySystem_read.ConsolereadCustomer;

public class Customerservice {
private static DataAsccessObject dao;
ConsolereadCustomer cc=new ConsolereadCustomer();

public Customerservice(DataAsccessObject dao) {
	super();
	this.dao = dao;
}
public void addCustomer(Customer customer) {
	dao.insert(customer);
}
public List<Customer> findallcust(){
	List<Customer> custlist = new ArrayList<Customer>();
List<Object> objlist=dao.listall();
	for(Object o : objlist) {
		custlist.add((Customer) o);
	}
	for(Customer c : custlist) {
		System.out.println(c);
	}
	return custlist;
}
public List<Customer> findallcustnotprint(){
	List<Customer> custlist = new ArrayList<Customer>();
List<Object> objlist=dao.listall();
	for(Object o : objlist) {
		custlist.add((Customer) o);
	}
//	for(Customer c : custlist) {
//		System.out.println(c);
//	}
	return custlist;
}
public void updateCustomer(List<Customer> customerlist) {
	Customer cust=cc.bildcustomer();
	for(Customer c : customerlist) {
		if(c.getCustomerid()==cust.getCustomerid()) {
			dao.update(cust);
			break;
		}else {
			System.out.println("this item not in the store");
		}
	}
}
public void findkeyid(List<Customer> costomerList) {
	boolean valeu=false;
	Customer cust1=new Customer();
	Customer cust = new Customer();
	 cust =cc.bildcustomer();
	for(Customer c : costomerList) {
		if(c.getCustomerid()==cust.getCustomerid()) {
		cust1=(Customer) dao.findprimarykey(c.getCustomerid());
		
		
			break;
		}else {
			if(valeu==false) {
				System.out.println("this item not in the store");
			}
			
		}
	}
	System.out.println(cust1);
}
public void deleteitem(List<Customer> customerlist) {
	Customer cust=new Customer();
	cust=cc.bildcustomer();
	for(Customer c : customerlist) {
		if(c.getCustomerid()==cust.getCustomerid()) {
			dao.delete(c.getCustomerid());
		}
	}
}
}
