package com.pildora01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Main {
	
	private static String url ="jdbc:mysql://localhost:3306/Pruebas1";
	private static String user = "root";
    private static String password = "PracticaRoot";
	
	public static void main(String[] args) {
	System.out.println("hola");
	
	
	
	try {
		
		TerminalUtils.output("Introduce la marca de un coche");
		String marcaFilter = TerminalUtils.inputText();
		
		//Pedir marca por teclado
		
		Class.forName("com.mysql.cj.jdbc.Driver"); //Cargar el driver de MySQL
		
		Connection connection = DriverManager.getConnection(url, user, password);
		
		//Añadir marca como filtro
		String query = "SELECT * FROM coches WHERE marca LIKE ?";
		PreparedStatement ps = connection.prepareStatement(query);
		
		ps.setString(1,  marcaFilter  + "%");
		
		//Para select
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			int id = rs.getInt(1);
			String marca = rs.getString(2);
			String modelo = rs.getString(3);
			String consumo = rs.getString(4);
			String emisiones = rs.getString(5);
			String imagen = rs.getString(6);
			System.out.println(marca + " - " + modelo + " - " + consumo + 
					" - " + emisiones + " - " + imagen);
		}
		
		
		//Para insert, update, delete
		//ps.executeUpdate();
		
		connection.close();
		
		System.out.println("Adios!");
		
	} catch (ClassNotFoundException e) {
		System.out.println("ClassNotFoundException!");
		e.printStackTrace();
	} 
	catch (SQLException e) {
		System.out.println("SQLException!");
		e.printStackTrace();
	}
	catch (Exception e) {
		System.out.println("Exception!");
		e.printStackTrace();
}
}
}
