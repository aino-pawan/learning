package com.pawan.learning_app;

//import java.sql.Connection;
//import java.sql.Statement;
//import java.sql.ResultSet;
//import java.sql.SQLException;

import org.hibernate.Session;

public class App {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		System.out.println("Hello World!");

		int a = 10;
		int b = 3;

		Calculator cal = new Calculator();
		System.out.println(cal.divide(a, b));

		System.out.println(a);

//    Statement stmt = null;
//    ResultSet rs = null;
//    
//    try {
//    	DatabaseConnection db = new DatabaseConnection();
//        Connection conn = db.getConnection();
//        if (conn == null) {
//        	throw new Exception("shit");
//        }
//        
//        stmt = conn.createStatement();
//        
//        int result = stmt.executeUpdate("INSERT INTO users (id, name) VALUES (3, 'Gaurav Dalvi');");
//        System.out.println("Rows Affected: " + result);
//        
//        rs = stmt.executeQuery("SELECT * FROM users;");
//        while (rs.next()) {
//        	int id = rs.getInt("id");
//        	String name = rs.getString("name");
//        	
//        	System.out.println("Id: " + id + ", Name: " + name);
//        }
//    }
//    catch(SQLException ex) {
//    	System.out.println("SQLException: " + ex.getMessage());
//        System.out.println("SQLState: " + ex.getSQLState());
//        System.out.println("VendorError: " + ex.getErrorCode());
//    }
//    finally {
//    	if (rs != null) {
//            try {
//                rs.close();
//            } catch (SQLException sqlEx) { } // ignore
//            rs = null;
//        }
//
//        if (stmt != null) {
//            try {
//                stmt.close();
//            } catch (SQLException sqlEx) { } // ignore
//            stmt = null;
//        }
//    }

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Developer developer = new Developer();
		developer.setName("Gaurav Dalvi");

		session.save(developer);
		session.getTransaction().commit();

		// reading entity
		session.beginTransaction();
		Developer readDeveloper = session.get(Developer.class, developer.getId());
		System.out.println("Developer: " + readDeveloper.getName());
		
		session.getTransaction().commit();
		session.close();
		
		// shutdown hibernate
		HibernateUtil.shutdown();
	}
}





































