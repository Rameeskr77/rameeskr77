package InventorySystem_read;

import java.util.Scanner;

import InventorySystem_domain.Item;

public class Consolereaditem {
private Scanner consoleread;
public Item bilditem() {
	consoleread= new Scanner(System.in);
	Item item= new Item();
	askitemid(item);
	askitemname(item);
	askunitprice(item);
	return item;
}
public void askitemid(Item item) {
	try {
		System.out.println("Enter the Item Id");
	item.setItemid(consoleread.nextInt());
	if(item.getItemid()==0) {
		askitemid(item);
		System.out.println("you have enter invalide ");
	}
	} catch (Exception e) {
		System.out.println("Incorrect data");
		item.setItemid(0);
	}
	System.out.println("==================================================================================");
}
public void askitemname(Item item) {
	try {
		System.out.println("Enter the Item name:");
		item.setItemName(consoleread.next());
		if(item.getItemName()==null) {
			askitemname(item);
			System.out.println("you have enterd invalid");
		}
	} catch (Exception e) {
		System.out.println("incorrect data");
		item.setItemName(null);
	}
	System.out.println("==================================================================================");
}
public void askunitprice(Item item) {
	try {
		System.out.println("Enter the unit Price");
		item.setUnitPrice(consoleread.nextInt());
		if(item.getUnitPrice()==0) {
			askunitprice(item);
			System.out.println("you have enterd invalide");
		}
	} catch (Exception e) {
		System.out.println("incorroct data");
		item.setItemid(0);
	}
	System.out.println("==================================================================================");
}
}
