package com.project04.model.repository;

import java.sql.Connection;


public class DatabaseConnection {
	   private static final String url = "jdbc:mysql://localhost:3306/p04_gym";
	   private static final String user = "root";
	   private static final String password = "PracticaRoot";

	   public static Connection getConnection() throws SQLException {
	       return DriverManager.getConnection(url, user, password);
	   }
}