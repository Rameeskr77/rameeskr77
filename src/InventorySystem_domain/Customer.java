package InventorySystem_domain;

public class Customer {
private int Customerid;
private String CustomerName;
private String bildingAddress;
private String EmailAddress;

public Customer() {
	super();
	this.Customerid=0;
	this.bildingAddress=null;
	this.CustomerName=null;
	this.EmailAddress=null;
}

public Customer(int customerid, String customerName, String bildingAddress, String emailAddress) {
	super();
	this.Customerid=customerid;
	CustomerName = customerName;
	this.bildingAddress = bildingAddress;
	EmailAddress = emailAddress;
}

public int getCustomerid() {
	return Customerid;
}

public void setCustomerid(int customerid) {
	Customerid = customerid;
}

public String getCustomerName() {
	return CustomerName;
}

public void setCustomerName(String customerName) {
	CustomerName = customerName;
}

public String getBildingAddress() {
	return bildingAddress;
}

public void setBildingAddress(String bildingAddress) {
	this.bildingAddress = bildingAddress;
}

public String getEmailAddress() {
	return EmailAddress;
}

public void setEmailAddress(String emailAddress) {
	EmailAddress = emailAddress;
}

@Override
public String toString() {
	return "Customer [Customerid=" + Customerid + ", CustomerName=" + CustomerName + ", bildingAddress="
			+ bildingAddress + ", EmailAddress=" + EmailAddress + "]";
}

}
