package InventorySystem_read;

import java.util.Scanner;

import InventorySystem_domain.Customer;

public class ConsolereadCustomer {
 private Scanner consoleread;
 
 public Customer bildcustomer() {
	 consoleread=new Scanner(System.in);
	 Customer customer=new Customer();
	 askCustomerid(customer);
	 askCustomername(customer);
	 askbildingaddress(customer);
	 askemailaddress(customer);
	return customer;
 }
 public void askCustomerid(Customer customer) {
	 System.out.println("Enter the Customer id");
	customer.setCustomerid(consoleread.nextInt());
 }
 public void askCustomername(Customer customer) {
	 System.out.println("Enter the Customer Name");
	 customer.setCustomerName(consoleread.next());
 }
 public void askbildingaddress (Customer customer) {
	 System.out.println("Enter the bilding Address");
	 customer.setBildingAddress(consoleread.next());
 }
 public void askemailaddress(Customer customer) {
	 System.out.println("Entre the Email Address");
	 customer.setEmailAddress(consoleread.next());
 }
}
