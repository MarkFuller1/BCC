package com.BNU.database;

import java.sql.SQLException;

public interface DatabaseService {

	public void put(Object a);

	public Object get(Object a);

	public void update(Object a);

	public void delete(Object a);
}
