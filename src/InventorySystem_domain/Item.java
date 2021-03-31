package InventorySystem_domain;

public class Item {
private int Itemid;
private String ItemName;
private int UnitPrice;
public Item() {
	super();
	this.Itemid=0;
	this.ItemName=null;
	this.UnitPrice=0;
}
public Item(int itemid, String itemName, int unitPrice) {
	super();
	Itemid = itemid;
	ItemName = itemName;
	UnitPrice = unitPrice;
}
public int getItemid() {
	return Itemid;
}
public void setItemid(int itemid) {
	Itemid = itemid;
}
public String getItemName() {
	return ItemName;
}
public void setItemName(String itemName) {
	ItemName = itemName;
}
public int getUnitPrice() {
	return UnitPrice;
}
public void setUnitPrice(int unitPrice) {
	UnitPrice = unitPrice;
}
@Override
public String toString() {
	return "Item [Itemid=" + Itemid + ", ItemName=" + ItemName + ", UnitPrice=" + UnitPrice + "]";
}

}
