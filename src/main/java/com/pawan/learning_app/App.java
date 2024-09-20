package com.pawan.learning_app;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App {
  public static void main(String[] args) throws Exception {
    System.out.println("Hello World!");
    
    int a = 10;
    int b = 3;
    
    Calculator cal = new Calculator();
    System.out.println(cal.divide(a, b));
    
    Statement stmt = null;
    ResultSet rs = null;
    
    try {
    	DatabaseConnection db = new DatabaseConnection();
        Connection conn = db.getConnection();
        if (conn == null) {
        	throw new Exception("shit");
        }
        
        stmt = conn.createStatement();
        
        int result = stmt.executeUpdate("INSERT INTO users (id, name) VALUES (2, 'Debasish');");
        System.out.println("Rows Affected: " + result);
        
        rs = stmt.executeQuery("SELECT * FROM users;");
        while (rs.next()) {
        	int id = rs.getInt("id");
        	String name = rs.getString("name");
        	
        	System.out.println("Id: " + id + ", Name: " + name);
        }
    }
    catch(SQLException ex) {
    	System.out.println("SQLException: " + ex.getMessage());
        System.out.println("SQLState: " + ex.getSQLState());
        System.out.println("VendorError: " + ex.getErrorCode());
    }
    finally {
    	if (rs != null) {
            try {
                rs.close();
            } catch (SQLException sqlEx) { } // ignore
            rs = null;
        }

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException sqlEx) { } // ignore
            stmt = null;
        }
    }
  }
}
