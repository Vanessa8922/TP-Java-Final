package com.codoacodo.dao;

import java.sql.Connection;
import com.codoacodo.coneccion.AdministradorDeConexiones;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.codoacodo.dto.Orador;
import java.sql.Timestamp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class OradorDAO {

       /* static Logger logger = LoggerFactory.getLogger(OradorDAO.class);*/
        
        
        private static final String SQL_DELETE = "DELETE FROM oradores WHERE id_orador = ?";
    
        
        
        /* private static final String SQL_INSERT="INSERT INTO FROM oradores(nombre,apellido,mail,tema)VALUES(?,?,?,?)";*/
        /*metodos del crud INSERT*/
       

/*public int insertarOrador(Orador ora) throws SQLException , NullPointerException , ClassNotFoundException ,
                InstantiationException , IllegalAccessException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        try {
            conn = AdministradorDeConexiones.getConexion();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, ora.getnombre());
            stmt.setString(2, ora.getapellido());
            stmt.setString(3, ora.getmail());
            stmt.setString(4, ora.gettema());
           
            registros = stmt.executeUpdate();
        } catch(SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                logger.info("Entro al finally-try");
                AdministradorDeConexiones.close(stmt);
                logger.info("despues de close stmt");
               AdministradorDeConexiones.close(conn);
                logger.info("despues de close conn");
            }
            catch(SQLException ex) {
                ex.getMessage();
            }
        }
        return registros;
    }
        */
     public void crearProducto(String nombre,String apellido, String mail, String tema ) throws SQLException {
		//aca es el error//
		Connection con = AdministradorDeConexiones.getConexion();
		
		if(con != null) { 
			// insert en la db > SQL: INSERT INTO....
			String sql ="INSERT INTO oradores(nombre, apellido,mail,tema)";
                              sql+="VALUES('"+nombre+"','"+apellido+"','"+mail+"','"+tema+"')";
			
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
public void actualizarOrador(String codigo,String apellido, String nombre, String mail, String tema) throws SQLException {
		Connection con = AdministradorDeConexiones.getConexion();
		if(con != null) { 
			String sql = "UPDATE oradores "
					+ " set nombre='"+nombre+"',"
					+ " apellido='"+apellido+"',"
					+ " mail='"+ mail +"'"
                                        + " tema='"+ tema +"'"  
					+ " WHERE id_orador = '"+codigo+"'";		
		
			try {
				Statement st = con.createStatement();			
				st.executeUpdate(sql);
				con.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
        
       
	
  
        
        
        
	/*metodos del crud*/
	public Orador obtenerPorId(int id) throws SQLException {
		String sql = "SELECT * FROM oradores WHERE id_orador="+id;
		
		//Connection
		Connection con =AdministradorDeConexiones.getConexion();
	
		Orador OradorFromDb = null;
		
		//Statement
		try {
			Statement st = con.createStatement();
			
			//resultset
			ResultSet rs = st.executeQuery(sql);
			
			//VIENE UN SOLO REGISTRO!!!
			
			if(rs.next()) {//si existe, hay uno solo
				// rs > sacando los datos
				int id_orador = rs.getInt(1);//tomar la primer columna
				String nombre = rs.getString(2);
				String apellido = rs.getString(3);
				String mail = rs.getString(4);
				String tema = rs.getString(5);
                                Timestamp fecha_alta = rs.getTimestamp(6);
                               
				OradorFromDb = new Orador(id_orador,nombre,apellido,mail,tema,fecha_alta);
			}			
		} catch (SQLException e) {
			// ERRORES
			e.printStackTrace();
		}
		return OradorFromDb;
	}
	

	/*metodos del crud*/
	public List<Orador> listarOrador() throws SQLException {
		
            
             
            String sql = "select * from oradores ";
		
		//Connector
		Connection con =AdministradorDeConexiones.getConexion();
	
		List<Orador> list = new ArrayList<>();
		
		//Statement
		try {
			Statement st = con.createStatement();
			
			//resultset
			ResultSet rs = st.executeQuery(sql);
			
			// UN SOLO REGISTRO!!!
			
			while(rs.next()) {//
				// rs > sacando los datos
				int id_orador = rs.getInt(1);//tomar la primer columna
				String nombre = rs.getString(2);
				String apellido = rs.getString(3);
				String mail = rs.getString(4);
				String tema = rs.getString(5);
				Timestamp fecha_alta = rs.getTimestamp(6);
				//campos crear un objeto????
				Orador OradorFromDb = new Orador(id_orador,nombre,apellido,mail,tema,fecha_alta);
				
				//agrego a la lista 
				list.add(OradorFromDb);
			}			
			
			//cierro la conexion
			con.close();
		} catch (SQLException e) {
			// ERRORES
			e.printStackTrace();
		}
		return list;
	}


	
	/*metodos del crud*/
	public List<Orador> buscar(String clave) throws SQLException {
		String sql = "select * from oradores were nombre LIKE '%"+clave+"%' ";
		
		//Connection
		Connection con = AdministradorDeConexiones.getConexion();
	
		List<Orador> listado = new ArrayList<Orador>();
		
		//Statement
		try {
			Statement st = con.createStatement();
			
			//resultset
			ResultSet rs = st.executeQuery(sql);
			
			//VIENE UN SOLO REGISTRO!!!
			
			while(rs.next()) {//si existe, hay uno solo
				// rs > sacando los datos
				int id_orador = rs.getInt(1);//tomar la primer columna
				String nombre = rs.getString(2);
				String apellido = rs.getString(3);
				String mail = rs.getString(4);
				String tema = rs.getString(5);
                                Timestamp fecha_alta = rs.getTimestamp(6);
				
				//campos crear un objeto????
				Orador OradorFromDb = new Orador(id_orador,nombre,apellido,mail,tema,fecha_alta);
				
				listado.add(OradorFromDb);
			}	
		} catch (SQLException e) {
			// ERRORES
			e.printStackTrace();
		}
		
		return listado;
	}
        
        public int eliminarOrador(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        
        try{
            conn = AdministradorDeConexiones.getConexion();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, id);
            registros = stmt.executeUpdate();
        } catch(SQLException | NullPointerException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch(SQLException | NullPointerException ex) {
                ex.printStackTrace(System.out);
            }
        }
        
        return registros;
    }

   
}
