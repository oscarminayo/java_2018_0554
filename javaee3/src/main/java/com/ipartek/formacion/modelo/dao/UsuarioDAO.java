package com.ipartek.formacion.modelo.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.modelo.ConnectionManager;
import com.ipartek.formacion.modelo.pojo.Usuario;
import com.ipartek.formacion.modelo.pojo.Video;

public class UsuarioDAO {

	private static UsuarioDAO INSTANCE = null;

// constructor privado, solo acceso por getInstance() 
	private UsuarioDAO() {
		super();
	}

// para get instance SINGLETON
	public synchronized static UsuarioDAO getInstance() {  // singleton
		if (INSTANCE == null) {
			INSTANCE = new UsuarioDAO();
		}
		return INSTANCE;
	}

// PARA COMPROBAR SI EXISTE USUARIO EN EL LOGIN	
		public Usuario login(String email, String password) {  
			
			// OBJETO USUARIO
			Usuario u= null; // creo objeto 
			
			// SENTENCIA SQL QUERY
			String sql = "SELECT id, email, password FROM usuario WHERE email = ? AND password = ?;"; // sentencia para mysql QUERY
	
			//PASOS CONEXION
			try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);) { // CREO OBJETO CONNECTION
				
			// RECOJO PARAMETROS Del formulario y los guard en objeto STATEMENT. TANTOS PARAMETROS  COMO INTERROGANTES HAYA EN LA QUERY
				
				pst.setString(1, email); 					// parametro 1 
				pst.setString(2, password);   				// parametro 2
				
				try (ResultSet rs = pst.executeQuery()) {	// EJECUTAR SQL
					while (rs.next()) { 					// RECORRER BASE DE DATOS MEDIANtE METODO RS.NEXT.
						u=(rowMapper(rs));  				//  GUARDO EN OBJETO LOS PARAMETROS QUE COINCIDEN CON LA BASE DE DATOS
					//  hemos encontrado usuario 
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return u;
		}


// PARA OBTENER USUARIO POR ID
		public Usuario getById(long id) {  
	
			Usuario u= null;  														// Objeto para guardar datos
			String sql = "SELECT id, email, password FROM usuario WHERE id = ?;"; 	// sentencia sql 
	
			try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);) { // CREO OBJETO CONNECTION
				
				pst.setLong(1, id); 						// RECOJO PARAMETROS en este caso solo la id
				
				try (ResultSet rs = pst.executeQuery()) { 	// EJECUTAR SQL
					while (rs.next()) { 					// RECORRER BASE DE DATOS MEDIANtE METODO RS.NEXT.
						u=(rowMapper(rs));					// GUARDO DATOS DE BASE DE DATOS
					}// hemos encontrado usuario
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return u; 										// DEVUELVO USUARIO CON LA ID QUE BUSCABA
		}


// PARA OBTENER DATOS DE TODOS LOS USUARIOS
		public ArrayList<Usuario> getAll() { 
			
			ArrayList<Usuario> usuarios = new ArrayList<Usuario>(); 							//array list para almacenar los usuarios de la base de datos
			String sql = "SELECT id, email, password FROM usuario ORDER BY id DESC LIMIT 500"; 	//SENTENCIA SQL // SELECT PARA capturar datos de los usuarios almacenados en la base de datos
	
			// PASOS PARA CREAR CONEXION		
			try (Connection conn = ConnectionManager.getConnection();  	// 2.1 CREO OBJETO CONNECTION PARA ESTABLECER CONEXION
				PreparedStatement pst = conn.prepareStatement(sql); 	// 2.2 CREAR OBJETO STATEMENT //con la sentencia sql
				ResultSet rs = pst.executeQuery()) {  					// 2.3 EJECUTAR SQL con la sentencia del statement // Execute query es el metodo para ejecutar la sentencia sql
				while (rs.next()) {  									// 2.4 RECORRER BASE DE DATOS MEDIANtE METODO RS.NEXT. HAY MAS COMO FIRST ETC.. //scNext : mientras haya un registro mas en la bbdd
					try {		
						usuarios.add(rowMapper(rs));   					// AÑADE ELEMENTOS CON LOS DATOS DE LA BASE DE DATOS
					} catch (Exception e) {
						System.out.println("usuario no valido");		// SI HAY ALGUN USUARIO MAL en la bbdd?
						e.printStackTrace();
					}
				} // while
			} catch (Exception e) { 									 // exception para conexion
				e.printStackTrace();
			}
			return usuarios;  											// DEVUELVE ARRAY CON LOS DATOS DE TODOS LOS USUARIOS
		}

	
// PARA CREAR/ INSERTAR NUEVO USUARIO
		public boolean insert(Usuario u) throws SQLException {
		
			boolean resul = false;
			String sql = "INSERT INTO `usuario` (`email`, `password`) VALUES (?,?);";  //SENTENCIA SQL
			try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);) { // 2.1 CREO OBJETO CONNECTION PARA ESTABLECER CONEXION
		
				pst.setString(1, u.getEmail()); 			// RECOJO PARAMETROS
				pst.setString(2, u.getPassword());
					
				int affectedRows = pst.executeUpdate();    	// ACTUALIZO BASE DE DATOS CON LOS PARAMETROS RECOGIDOS
				if (affectedRows == 1) {
					resul = true;  							// PARA SABER SI EXISTE USUARIO
				}	
			}
			return resul;									// DEVUELVO SI HAY USUARIO O NO
		}
		

// PARA BORRAR USUARIO		
		public boolean delete( long id ) throws SQLException {
	
			boolean resul = false;
			String sql = "DELETE FROM `usuario` WHERE id = ?;";
			try (Connection conn = ConnectionManager.getConnection(); 
				 PreparedStatement pst = conn.prepareStatement(sql);) {
	
				pst.setLong(1, id);
				
				int affectedRows = pst.executeUpdate();
				if (affectedRows == 1) {
					resul = true;
				}
			}
			return resul;
		}
	
		
// PARA ACTUALIZAR USUARIO		
		public boolean update (Usuario u) throws SQLException {
	
			boolean resul = false;
			String sql = "UPDATE `usuario` SET `email`='auraga@ipartek.com', `password`='222' WHERE `id`=1;";
			try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);) {
	
				pst.setString(1, u.getEmail());  // parametro 1 me lo da u.getEmail 1 por cada interrogante 
				pst.setString(2, u.getPassword());
				pst.setLong(3, u.getId());
			
				int affectedRows = pst.executeUpdate();
				if (affectedRows == 1) {
					resul = true;
				}
			}
			return resul;
		}

		
// METODO PARA recoger datos de la base de datos	Y GUARDARLOS EN OBJETO	
		private Usuario rowMapper(ResultSet rs) throws SQLException {  // para devolver usuario comparado con la base de datos
			Usuario u = new Usuario();
			u.setId(rs.getLong("id")); // modifico la id del usuario obteniendo id de resulset
			u.setEmail(rs.getString("email"));
			u.setPassword(rs.getString("password"));
			return u;
		}

}