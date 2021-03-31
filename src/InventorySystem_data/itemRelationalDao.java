package InventorySystem_data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import InventorySystem_domain.Item;

public class itemRelationalDao extends RelationalDataAccessObject {
	private Connection connection;
	private PreparedStatement statment;
	private ResultSet result=null;
	
	@Override
	protected void insertobject(Object object) {
	Item item=(Item) object;
     connection=relationdatabaseinfo.getconnection();
	try {
		statment=connection.prepareStatement("INSERT INTO item (itemid, itemname, unitprice) values(?, ?, ?)");
		statment.setInt(1, item.getItemid());
		statment.setString(2, item.getItemName());
		statment.setInt(3, item.getUnitPrice());
		System.out.println("Inserting " + item + " into customers");
		statment.executeUpdate();
		System.out.println( " saved successfully.");
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
		List<Object> listobj= new ArrayList<Object>();
		connection=relationdatabaseinfo.getconnection();
		try {
			statment=connection.prepareStatement("SELECT * FROM Item");
			result=statment.executeQuery();
			while(result.next()) {
				int id =result.getInt("itemid");
				String name=result.getString("itemname");
				int unitprice = result.getInt("unitprice");
				Item item =new Item(id,name,unitprice);
				listobj.add(item);
				
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
		return listobj;
	}

	@Override
	protected void updation(Object object) {
		Item item=(Item)object;
		connection=relationdatabaseinfo.getconnection();
		try {
			statment=connection.prepareStatement("UPDATE Item SET itemname= ?, unitprice = ? WHERE itemid = ?");
			statment.setString(1, item.getItemName());
			statment.setInt(2, item.getUnitPrice());
			statment.setInt(3, item.getItemid());
			statment.executeUpdate();
			System.out.println("update succssesfully....");
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
		Item item1 =new Item();
		connection= relationdatabaseinfo.getconnection();
		try {
			statment=connection.prepareStatement("SELECT * FROM Item where itemid=?");
			statment.setInt(1, id);
		ResultSet result1=statment.executeQuery();
			while(result1.next()) {
				int id1=result1.getInt("itemid");
				String name1=result1.getString("itemname");
				int unitprice1 = result1.getInt("unitprice");
				item1.setItemid(id1);
				item1.setItemName(name1);
				item1.setUnitPrice(unitprice1);
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
		return item1 ;
		
	}

	@Override
	protected void deleteitemin(int id) {
		connection=relationdatabaseinfo.getconnection();
		try {
			statment=connection.prepareStatement("DELETE FROM Item WHERE itemid=?");
			statment.setInt(1, id);
		int v=statment.executeUpdate();
		System.out.println("Itemid"+id+": is delete"+v+"row effected");
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
