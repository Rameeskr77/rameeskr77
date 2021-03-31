package InventorySystem_service;


import java.util.ArrayList;
import java.util.List;



import InventorySystem_data.DataAsccessObject;
import InventorySystem_domain.Item;
import InventorySystem_read.Consolereaditem;

public class itemservice {
private DataAsccessObject dao;
Consolereaditem cosole=new Consolereaditem();
Item item =new Item();
public itemservice(DataAsccessObject dao) {
	super();
	this.dao = dao;
}
public void additem(Item item) {
	dao.insert(item);
}
public List<Item> findall(){
List<Object> list=dao.listall();

List<Item> listitem= new ArrayList<Item>();
for(Object o:list) {
	listitem.add((Item)o);
}
for(Item i : listitem) {
	System.out.println(i);
}
	return listitem;
	
}
public List<Item> findallnotprin(){
List<Object> list=dao.listall();

List<Item> listitem= new ArrayList<Item>();
for(Object o:list) {
	listitem.add((Item)o);
}
//for(Item i : listitem) {
//	System.out.println(i);
//}
	return listitem;
	
}
public  void updateitem() {
	List<Item> items = new ArrayList<Item>();
	items=findall();
	Consolereaditem cosole=new Consolereaditem();
	Item item =new Item();
	 item= cosole.bilditem();	
	 for(Item li : items ) {
		if(li.getItemid()==item.getItemid()) {
			dao.update(item);
			break;
		}else {
			System.out.println("this item not in store");
		}
	}
}
public void findid(List<Item> itemlist) {
	Item items=new Item();
	Item itemnew = new Item();
	items=cosole.bilditem();
	for( Item li : itemlist) {
		if(li.getItemid()==items.getItemid()) {
		itemnew=(Item) dao.findprimarykey(li.getItemid());
			break;
		}else {
			System.out.println("not in the store");
		}
	}
	System.out.println(itemnew);
}
public void deletitem(List<Item> itemlist) {
	Item item=cosole.bilditem();
	for(Item i : itemlist) {
		if(i.getItemid()==item.getItemid()) {
			dao.delete(i.getItemid());
		}else {
			System.out.println("this item not in the store....");
		}
	}
}
}
