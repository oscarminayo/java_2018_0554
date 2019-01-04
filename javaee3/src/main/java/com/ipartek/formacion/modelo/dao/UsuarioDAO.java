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

	public synchronized static UsuarioDAO getInstance() {  // singleton
		if (INSTANCE == null) {
			INSTANCE = new UsuarioDAO();
		}
		return INSTANCE;
	}

	
	public Usuario login(String email, String password) {
		
		// OBJETO USUARIO
		Usuario u= null; // creo objeto 
		
		// SENTENCIA SQL QUERY
		String sql = "SELECT id, email, password FROM usuario WHERE email = ? AND password = ?;"; // sentencia para mysql QUERY

		try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);) { // intenta conexion
			
			// recogo parametros QUE me da el formulario y los guard en pst.setString  TANTOS PARAMETROS  COMO INTERROGANTES HAYA EN LA QUERY
			pst.setString(1, email); // parametro 1 me lo da u.getEmail
			pst.setString(2, password);   // parametro 2
			
			try (ResultSet rs = pst.executeQuery()) { // guardo parametros en el resulset
				while (rs.next()) { //  hemos encontrado usuario
					u=(rowMapper(rs));  // 
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;
	}


	public Usuario getById(long id) {

		Usuario u= null;
		String sql = "SELECT id, email, password FROM usuario WHERE id = ?;";

		try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);) {
			pst.setLong(1, id);
			
			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) { // hemos encontrado usuario
					u=(rowMapper(rs));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;
	}

	public ArrayList<Usuario> getAll() {

		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		String sql = "SELECT id, email, password FROM usuario ORDER BY id DESC LIMIT 500";

		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				try {
					
					usuarios.add(rowMapper(rs));
				} catch (Exception e) {
					System.out.println("usuario no valido");
					e.printStackTrace();
				}
			} // while

		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuarios;
	}

	public boolean insert(Usuario u) throws SQLException {

		boolean resul = false;
		String sql = "INSERT INTO `usuario` (`email`, `password`) VALUES (?,?);";
		try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);) {

			pst.setString(1, u.getEmail());
			pst.setString(2, u.getPassword());
			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				resul = true;
			}

		}
		return resul;

	}
	
	
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
	
	private Usuario rowMapper(ResultSet rs) throws SQLException {  // para devolver usuario comparado con la base de datos
		Usuario u = new Usuario();
		u.setId(rs.getLong("id")); // modifico la id del usuario obteniendo id de resulset
		u.setEmail(rs.getString("email"));
		u.setPassword(rs.getString("password"));
		return u;
	}

}