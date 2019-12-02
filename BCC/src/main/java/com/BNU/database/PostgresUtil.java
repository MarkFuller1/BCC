package com.BNU.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresUtil {
	final static String connectionSpecification = "jdbc:postgresql://localhost:5432/";
	final static String driverClassName = "org.postgresql.Driver";
	private Connection dbConnection;
	
	public Connection getDbConnection() {
		return dbConnection;
	}

	public void setDbConnection(Connection dbConnection) {
		this.dbConnection = dbConnection;
	}

	protected void openConnection() throws SQLException, ClassNotFoundException {
		Class.forName(driverClassName);
		
		this.setDbConnection(DriverManager.getConnection(connectionSpecification, System.getenv("SQL_DB_USRNAME"),
				System.getenv("SQL_DB_PASSWORD")));
	}
	
	protected void closeConnection() throws SQLException {
		if(this.dbConnection == null) {
			return;
		}
		this.dbConnection.close();
	}
}
