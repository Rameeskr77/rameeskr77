package InventorySystem_main;

import java.util.ArrayList;
import java.util.List;

import InventorySystem_data.CustomerRelation;
import InventorySystem_data.DataAsccessObject;
import InventorySystem_data.Orderrelation;
import InventorySystem_data.itemRelationalDao;
import InventorySystem_domain.Customer;
import InventorySystem_domain.Item;
import InventorySystem_domain.Order;
import InventorySystem_read.ConsolereadCustomer;
import InventorySystem_read.Consolereaditem;
import InventorySystem_read.Consolereadorder;
import InventorySystem_service.Customerservice;
import InventorySystem_service.Orderservice;
import InventorySystem_service.itemservice;

public class inventorymain {

	public static void main(String[] args) {
//		List<Item> itemlist =new ArrayList<Item>();
//		Consolereaditem csri=new Consolereaditem();
//		Item item=csri.bilditem();
		DataAsccessObject dao=new itemRelationalDao();
		itemservice its=new itemservice(dao);
//		its.additem(item);
//		itemlist=its.findall();
//		its.updateitem();
////	its.findid(itemlist);
//		its.deletitem(itemlist);
		
//		ConsolereadCustomer csc=new ConsolereadCustomer();
//    	Customer cust=csc.bildcustomer();
    	DataAsccessObject dao1 =new CustomerRelation();
    	Customerservice cs =new Customerservice(dao1);
////    	cs.addCustomer(cust);
//    	List<Customer>custlist=	cs.findallcust();
//    	cs.updateCustomer(custlist);
//    	cs.findkeyid(custlist);
//    	cs.deleteitem(custlist);
		
    	DataAsccessObject dao2 =new Orderrelation();
    	List<Customer> cstlist= cs.findallcustnotprint();
    	List<Item> itemlist= its.findallnotprin();
		Consolereadorder co =new Consolereadorder();
    	Order od=co.bildorder(cs,its);
    	Orderservice os=new Orderservice(dao2);
    	os.addorder(od, cstlist,itemlist);
	}

}
