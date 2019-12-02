package com.BNU.database;

public class DIConsumer implements Consumer {

	DatabaseService service;
	
	public DatabaseService getService() {
		return service;
	}

	public void setService(DatabaseService service) {
		this.service = service;
	}

	public DIConsumer(StudentService studentService) {
		this.setService(studentService);
	}
	
	@Override
	public void processRequestPut(Object a) {
		this.service.put(a);
	}

	@Override
	public void processRequestGet(Object a) {
		this.service.get(a);
	}

	@Override
	public void processRequestUpdate(Object a) {
		this.service.update(a);
	}

	@Override
	public void processRequestDelete(Object a) {
		this.service.delete(a);
	}
}
