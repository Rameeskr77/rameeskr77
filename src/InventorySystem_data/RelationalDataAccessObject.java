package InventorySystem_data;

import java.util.ArrayList;
import java.util.List;

import InventorySystem_domain.Item;

public abstract class RelationalDataAccessObject implements DataAsccessObject {

	@Override
	public void insert(Object object) {
		insertobject(object);
	}

	@Override
	public List<Object> listall() {
	List<Object> list=listitem();
	
		return list;
	}

	@Override
	public void update(Object object) {
		updation(object);
	}

	@Override
	public Object findprimarykey(int id) {
	Object obj=findkey(id);
		return obj;
	}

	@Override
	public void delete(int id) {
		deleteitemin(id);
		
	}
protected abstract void insertobject(Object object);
protected abstract List<Object> listitem();
protected abstract void updation(Object object);
protected abstract Object findkey(int id);
protected abstract void deleteitemin(int id);
}
