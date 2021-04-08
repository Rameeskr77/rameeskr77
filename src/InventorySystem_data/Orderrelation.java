package InventorySystem_data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import InventorySystem_domain.Customer;
import InventorySystem_domain.Item;
import InventorySystem_domain.Order;



public class Orderrelation extends RelationalDataAccessObject {
private Connection connection;
private PreparedStatement statment;
	@Override
	protected void insertobject(Object object) {
		Order order=(Order)object;
		connection=relationdatabaseinfo.getconnection();
		try {
			statment=connection.prepareStatement("INSERT INTO orders ( cid, itid) values(?, ?)",
				statment.RETURN_GENERATED_KEYS);
			statment.setInt(1, order.getCustomerid().getCustomerid());
			statment.setInt(2, order.getItemid().getItemid());
			statment.executeUpdate();
            System.out.println(" saved successfully.");
			
			ResultSet rs=statment.getGeneratedKeys();
			while(rs.next()) {
				order.setOrderid(rs.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				statment.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	protected List<Object> listitem() {
		connection= relationdatabaseinfo.getconnection();
		List<Object> obj = new ArrayList<Object>();
		
		try {
			statment=connection.prepareStatement("SELECT orderid,customerid,customername,bildingaddress,emailaddress,itemid,itemname,unitprice FROM orders JOIN customer ON orders.cid=customer.customerid JOIN item ON orders.itid=item.itemid");
			ResultSet rs =statment.executeQuery();
			while(rs.next()) {
				Order order =new Order();
				Customer customer = new Customer();
				Item item= new Item();
				order.setOrderid(rs.getInt(1));
				customer.setCustomerid(rs.getInt(2));
				customer.setCustomerName(rs.getString(3));
				customer.setBildingAddress(rs.getString(4));
				customer.setEmailAddress(rs.getString(5));
				order.setCustomerid(customer);
				item.setItemid(rs.getInt(6));
				item.setItemName(rs.getString(7));
				item.setUnitPrice(rs.getInt(8));
				order.setItemid(item);
				obj.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				statment.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					statment.close();
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return obj;
		
	}

	@Override
	protected void updation(Object object) {
		Order order =(Order) object;
		connection=relationdatabaseinfo.getconnection();
		try {
			statment=connection.prepareStatement("UPDATE orders SET cid=?, itid=? where orderid=?");
			
			statment.setInt(1, order.getCustomerid().getCustomerid());
			statment.setInt(2, order.getItemid().getItemid());
			statment.setInt(3, order.getOrderid());
			statment.executeUpdate();
			System.out.println("updation susccecs...");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				statment.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	protected Object findkey(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void deleteitemin(int id) {
		connection=relationdatabaseinfo.getconnection();
		try {
			statment=connection.prepareStatement("DELETE FROM ORDERS WHERE orderid=?");
			statment.setInt(1, id);
			statment.executeUpdate();
			System.out.println("deletion succsess...");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				statment.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
