package com.ipartek.formacion.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.modelo.ConnectionManager;
import com.ipartek.formacion.modelo.pojo.Usuario;
import com.ipartek.formacion.modelo.pojo.Video;

public class VideoDAO {

	private static VideoDAO INSTANCE = null;

	// constructor privado, solo acceso por getInstance()
	private VideoDAO() {
		super();
	}

	public synchronized static VideoDAO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new VideoDAO();
		}
		return INSTANCE;
	}

	public Video getById(long id) {

		Video videos = null;
		String sql = "SELECT id, nombre, codigo FROM video WHERE id = ?;";

		try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);) {
			pst.setLong(1, id);
			
			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) { // hemos encontrado usuario
					videos = new Video();
					videos.setId(rs.getLong("id"));
					videos.setNombre(rs.getString("nombre"));
					videos.setCodigo(rs.getString("codigo"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return videos;
	}

	public ArrayList<Video> getAll() {

		ArrayList<Video> videos = new ArrayList<Video>();
		String sql = "SELECT id, nombre, codigo FROM video ORDER BY id DESC LIMIT 500";

		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				try {
					Video video = new Video();
					video.setId(rs.getLong("id"));
					video.setNombre(rs.getString("nombre"));
					video.setCodigo(rs.getString("codigo"));
					// a�adir en array
					videos.add(video);
				} catch (Exception e) {
					System.out.println("video no valido");
					e.printStackTrace();
				}
			} // while

		} catch (Exception e) {
			e.printStackTrace();
		}
		return videos;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public boolean insert(Video u) throws SQLException {

		boolean resul = false;
		String sql = "INSERT INTO `video` (`nombre`, `codigo`) VALUES (?,?);";
		try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);) {

			pst.setString(1, u.getNombre());
			pst.setString(2, u.getCodigo());
			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				resul = true;
			}

		}
		return resul;

	}
	
	
	public boolean delete( long id ) throws SQLException {

		boolean resul = false;
		String sql = "DELETE FROM `video` WHERE id = ?;";
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
	
	public boolean update (Video u) throws SQLException {

		boolean resul = false;
		String sql = "UPDATE `video` SET `nombre`='muestra', `codigo`='222' WHERE `id`=1;";
		try (Connection conn = ConnectionManager.getConnection(); PreparedStatement pst = conn.prepareStatement(sql);) {

			pst.setString(1, u.getNombre());  // parametro 1 me lo da u.getEmail
			pst.setString(2, u.getCodigo());
			pst.setLong(3, u.getId());
			
			
			
			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				resul = true;
			}

		}
		return resul;

	}

}