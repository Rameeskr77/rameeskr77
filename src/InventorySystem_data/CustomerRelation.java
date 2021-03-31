package InventorySystem_data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.PreparableStatement;

import InventorySystem_domain.Customer;

public class CustomerRelation extends RelationalDataAccessObject {
private Connection connection;
private PreparedStatement statement;
	@Override
	protected void insertobject(Object object) {
		Customer cust=(Customer)object;
		connection=relationdatabaseinfo.getconnection();
		try {
			statement=connection.prepareStatement("INSERT INTO Customer ( customername, bildingaddress, emailaddress) values(?, ?, ?)",
			statement.RETURN_GENERATED_KEYS);
			statement.setString(1,cust.getCustomerName());
			statement.setString(2,cust.getBildingAddress());
			statement.setString(3, cust.getEmailAddress());
			statement.executeUpdate();
			System.out.println(" saved successfully.");
			
			ResultSet rs=statement.getGeneratedKeys();
			while(rs.next()) {
				cust.setCustomerid(rs.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	protected List<Object> listitem() {
		List<Object> listobj = new ArrayList<Object>();
		connection=relationdatabaseinfo.getconnection();
		try {
			statement=connection.prepareStatement("SELECT * FROM Customer");
		    ResultSet rs=statement.executeQuery();
		    while(rs.next()) {
		    	Customer cust=new Customer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
		    	listobj.add(cust);
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return listobj;
	}

	@Override
	protected void updation(Object object) {
		Customer cust =(Customer)object;
		connection=relationdatabaseinfo.getconnection();
		try {
			statement=connection.prepareStatement("UPDATE Customer SET customername=?, bildingaddress=?, emailaddress=? where customerid=?");
			statement.setString(1,cust.getCustomerName());
			statement.setString(2, cust.getBildingAddress());
			statement.setString(3, cust.getEmailAddress());
			statement.setInt(4, cust.getCustomerid());
			statement.executeUpdate();
			System.out.println("update succsess");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	protected Object findkey(int id) {
		Customer cust=new Customer();
		connection=relationdatabaseinfo.getconnection();
		try {
			statement=connection.prepareStatement("SELECT * FROM Customer WHERE Customerid=?");
			statement.setInt(1, id);
			ResultSet rs= statement.executeQuery();
			while(rs.next()) {
				cust.setCustomerid(rs.getInt(1));
				cust.setCustomerName(rs.getString(2));
				cust.setBildingAddress(rs.getString(3));
				cust.setEmailAddress(rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return cust;
	}

	@Override
	protected void deleteitemin(int id) {
		connection=relationdatabaseinfo.getconnection();
		try {
			statement=connection.prepareStatement("DELETE FROM Customer WHERE customerid=?");
			statement.setInt(1, id);
			statement.executeUpdate();
			System.out.println("delete succses");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
