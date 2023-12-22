package com.codoacodo.coneccion;
//CONFIGURACION DE LA CONEXION CON LA BBDD
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdministradorDeConexiones {
/*"jdbc:mysql://localhost:3306/integrador_cac";*/
    private static final String JDBC_URL ="jdbc:mysql://localhost:3306/integrador_cac";
    private static final String JDBC_USR = "root";
    private static final String JDBC_PASS = "12345678";
    

     String driverName="com.mysql.cj.jdbc.Driver";
    public static Connection getConexion() throws SQLException {
           
        return DriverManager.getConnection(JDBC_URL, JDBC_USR, JDBC_PASS);
    }
    
    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }
    
    public static void close(Statement st) throws SQLException {
        st.close();
    }
    
    public static void close(Connection cn) throws SQLException {
        cn.close();
    }

    
}

	//public static Connection getConnection() {
	//	String url = "jdbc:mysql://localhost:3306/integrador_cac";
	//	String username = "root";
	//	String password = "12345678";
		
	//	String driverName = "com.mysql.cj.jdbc.Driver";
		/*
		String url = System.getenv("DATASOURCE_URL");
		String user = System.getenv("DATASOURCE_USERNAME");
		String password = System.getenv("DATASOURCE_PASSWORD");
		String driverName = System.getenv("DATASOURCE_DRIVER");
		*/
		//control errores
		//Connection con = null;
		//try {
		//	Class.forName(driverName);//carga en memoria el Driver
		//	con = DriverManager.getConnection(url,username,password);
		//}catch(ClassNotFoundException | SQLException e) {
                    //muestra la excepción y el error
                    
		//}
		//return con;
	//}
	
	//public static void main(String[] args) {
	//	Connection con = AdministradorDeConexiones.getConnection();//f5
	//	if(con != null) {
	//		System.out.println("Conexion ok");
	//	}else {
	//		System.err.println("Conexion fail");
	//	}
	//}
//}
