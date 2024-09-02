package com.controller.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {

	public static void main(String[] args) {
		
		String dbUrl = "jdbc:mysql://localhost:3306/advjava";
		String dbuserName = "root";
		String dbPassword = "root";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		Connection connection =  DriverManager.getConnection(dbUrl,dbuserName,dbPassword);
		
		System.out.println("connection = "+connection);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}
	}
}
