package InventorySystem_data;

import java.util.List;

public interface DataAsccessObject {
void insert(Object object);

public abstract List<Object> listall();

void update(Object object);

Object findprimarykey(int id);

void delete(int id);
}
