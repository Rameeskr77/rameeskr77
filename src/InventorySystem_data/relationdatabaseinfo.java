package InventorySystem_data;

import java.sql.Connection;
import java.sql.DriverManager;

public class relationdatabaseinfo implements DatabaseInfo {
public static Connection connection=null;
public static final String DRIVER_NAME="com.mysql.cj.jdbc.Driver";
private static String password = "root";
private static String username="root";
private static String url = "jdbc:mysql://localhost:3306/Inventory_system?user=root&password=root";
	@Override
	public String getDrivername() {
		return DRIVER_NAME;
	}

	@Override
	public String getPassword() {
		
		return password;
	}

	@Override
	public String getUrl() {
		
		return url;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}
public static Connection getconnection() {
	try {
		Class.forName(DRIVER_NAME);
		System.out.println("Connector loaded successfully");
	} catch (Exception e) {
		System.err.print("ClassNotFoundException: ");
		System.err.println(e.getMessage());
	}
	
	try {
		connection=DriverManager.getConnection(url);
		System.out.println("Connected with host:port/database.");
	} catch (Exception e) {
		System.err.println("SQLException: " + e.getMessage());
	}
	return connection;
	
}
}
