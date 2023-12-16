package com.codoacodo.dao;

import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
import com.codoacodo.coneccion.AdministradorDeConexiones;
//import com.codoacodo.dto.Orador;
//import java.sql.PreparedStatement;

public class OradorDAO
{

       
	/*crear un Orador en la db*/
	public void crearOrador(String nombre,String apellido, String email, String tema) {
		
		Connection con = AdministradorDeConexiones.getConnection();
		
		if(con != null) { 
			// insert en la db > SQL: INSERT INTO....
			String sql = "INSERT INTO Orador (nombre, apellido,email,tema) ";
			sql += "VALUES('"+nombre+"',"+apellido+",'"+email+"','"+tema+"')";
			
			//control de errores
			try {
				Statement st = con.createStatement();			
				st.execute(sql);
				
				//cierre de conexion
				con.close();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	
}
