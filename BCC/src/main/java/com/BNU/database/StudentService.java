package com.BNU.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import models.Student;

public class StudentService extends PostgresUtil implements DatabaseService {

	final static String TABLE_NAME = "STUDENT";

	public void initTable() {
		Connection c;
		try {

			super.openConnection();
			
			Statement st;

			String command = "CREATE TABLE " + TABLE_NAME + "(ID INT,"
					+ " NAME TEXT,  USERNAME TEXT, PASSWORD TEXT)";//COURSES TEXT[],
			
			System.out.println(command);

			st = super.getDbConnection().createStatement();
			st.executeUpdate(command);
			st.close();

			super.closeConnection();

		} catch (ClassNotFoundException | SQLException e) {
			//the table already exists
			System.out.println("The table exists");
		}
	}

	@Override
	public void put(Object a) {
		initTable();
		try {
			Student stu = (Student) a;
			System.out.println(stu.toString());
			super.openConnection();
			Statement st = super.getDbConnection().createStatement();

			String command = "INSERT INTO " + TABLE_NAME + "(ID,NAME,USERNAME,PASSWORD) " + "VALUES(" + stu.hashCode()
					+ "," + stu.getName() + "," + stu.getUsername() + "," + stu.getPassword()
					+ ")"; //stu.getClasses() + 
			
			System.out.println(command);

			st.executeUpdate(command);

			st.close();
			super.closeConnection();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	// pass the Id of the user to get their info
	@Override
	public Object get(Object a) {
		initTable();
		try {
			String id = (String) a;
			super.openConnection();
			Statement st = super.getDbConnection().createStatement();

			String command = "SELECT * FROM " + TABLE_NAME + "where ID = " + id;

			st.executeUpdate(command);

			st.close();
			super.closeConnection();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public void update(Object a) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Object a) {
		// TODO Auto-generated method stub

	}

}
