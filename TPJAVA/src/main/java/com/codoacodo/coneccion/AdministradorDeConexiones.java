package com.codoacodo.coneccion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AdministradorDeConexiones {

	public static Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/integrador_cac";
		String username = "admin";
		String password = "1234";
		
		String driverName = "com.mysql.cj.jdbc.Driver";
		/*
		String url = System.getenv("DATASOURCE_URL");
		String user = System.getenv("DATASOURCE_USERNAME");
		String password = System.getenv("DATASOURCE_PASSWORD");
		String driverName = System.getenv("DATASOURCE_DRIVER");
		*/
		//control errores
		Connection con = null;
		try {
			Class.forName(driverName);//carga en memoria el Driver
			con = DriverManager.getConnection(url,username,password);
		}catch(ClassNotFoundException | SQLException e) {
                    //muestra la excepción y el error
                    
		}
		return con;
	}
	
	public static void main(String[] args) {
		Connection con = AdministradorDeConexiones.getConnection();//f5
		if(con != null) {
			System.out.println("Conexion ok");
		}else {
			System.err.println("Conexion fail");
		}
	}
}
