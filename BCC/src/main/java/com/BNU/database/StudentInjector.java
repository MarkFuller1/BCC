package com.BNU.database;

public class StudentInjector implements RequestServiceInjector {

	@Override
	public Consumer getConsumer() {
		return new DIConsumer(new StudentService());
	}

}
