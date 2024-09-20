package com.pawan.learning_app;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;;

public class DatabaseConnection {
	private String URL = "jdbc:mysql://localhost:3306/ainocorp";
	private String USER = "root";
	private String PASSWORD = "mintmint";
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(this.URL, this.USER, this.PASSWORD);
			System.out.println("[DATABASE] Connected to MySQL Sucessfully!");
		} catch(SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		return conn;
	}
}