package InventorySystem_domain;

public class Order {
private int orderid;
private Customer customerid;
private Item itemid;
private int total;
public Order() {
	super();
	this.orderid=0;
	this.customerid=null;
	this.itemid=null;
	this.total=0;
}
public Order(int orderid, Customer customerid, Item itemid, int total) {
	super();
	this.orderid = orderid;
	this.customerid = customerid;
	this.itemid = itemid;
	this.total = total;
}
public int getOrderid() {
	return orderid;
}
public void setOrderid(int orderid) {
	this.orderid = orderid;
}
public Customer getCustomerid() {
	return customerid;
}
public void setCustomerid(Customer customerid) {
	this.customerid = customerid;
}
public Item getItemid() {
	return itemid;
}
public void setItemid(Item itemid) {
	this.itemid = itemid;
}
public int getTotal() {
	return total;
}
public void setTotal(int total) {
	this.total = total;
}
@Override
public String toString() {
	return "Order [orderid=" + orderid + ", customerid=" + customerid + ", itemid=" + itemid + ", total=" + total + "]";
}

}
