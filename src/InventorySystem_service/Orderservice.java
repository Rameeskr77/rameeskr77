package InventorySystem_service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



import InventorySystem_data.DataAsccessObject;
import InventorySystem_data.relationdatabaseinfo;
import InventorySystem_domain.Customer;
import InventorySystem_domain.Item;
import InventorySystem_domain.Order;
import InventorySystem_read.Consolereadorder;

public class Orderservice {
private DataAsccessObject dao;
private Connection connection;
private PreparedStatement statement;
public Orderservice(DataAsccessObject dao) {
	super();
	this.dao = dao;
}
public void addorder(Order order, List<Customer> custlist, List<Item> itemlist) {
	for(Customer c : custlist) {
		for(Item i : itemlist) {
			if(c.getCustomerid()==order.getCustomerid().getCustomerid() && i.getItemid()==order.getItemid().getItemid()) {
				dao.insert(order);
			}
		}
	}
}
public List<Order> findallorder() {
	List<Order> order =new ArrayList<Order>();
List<Object> obj=dao.listall();
for(Object o: obj) {
	order.add((Order) o);
}
for(Order or : order) {
	System.out.println(or);
}
System.out.println("TOTAL....");
connection=relationdatabaseinfo.getconnection();
try {
	statement=connection.prepareStatement("select orderid,customername,SUM(unitprice) FROM orders JOIN customer ON orders.cid=customer.customerid JOIN ITEM ON orders.itid=item.itemid GROUP BY customername");
ResultSet rs=statement.executeQuery();
while(rs.next()) {
	System.out.println("orderd id: "+rs.getInt(1)+"  Customer name: "+rs.getString(2)+"  Total= "+rs.getString(3));
}
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
return order;
}
public void updateorder(List<Order> order, Customerservice cs,itemservice ic) {
	System.out.println("updation................");
	Consolereadorder cr =new Consolereadorder();
	Order ord = cr.bildorder(cs, ic);
	for(Order o : order) {
		if(o.getOrderid()==ord.getOrderid()) {
			dao.update(ord);
		}
	}
}
public void deleteorder(List<Order> order, Customerservice cs, itemservice ic) {
	System.out.println("deleting......order");
	Consolereadorder cr = new Consolereadorder();
	Order ord =cr.bildorder(cs, ic);
	for(Order o : order) {
		if(o.getOrderid()==ord.getOrderid()) {
			dao.delete(o.getOrderid());
		}
	}
}
}
