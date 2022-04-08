package com.domain.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	
	
	private static Connection conection;
	
	//public ConnectionManager() {}
	
	public static void conectar() throws ClassNotFoundException, SQLException {
		//Levanto el driver manager
		Class.forName("com.mysql.cj.jdbc.Driver");
		//Obtengo la conexion
		conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/asapconsulting", "root", "38661061");
			
	}
	
	public static void desconectar() throws SQLException {
		conection.close();
		
	}

	public static Connection getConection() {
		return conection;
	}
}
