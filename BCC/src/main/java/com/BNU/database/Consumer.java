package com.BNU.database;

public interface Consumer {
	public void processRequestPut(Object a);
	
	public void processRequestGet(Object a);
	
	public void processRequestUpdate(Object a);
	 
	public void processRequestDelete(Object a);
}
