package com.ipartek.formacion.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.modelo.ConnectionManager;
import com.ipartek.formacion.modelo.pojo.Perro;

public class PerroDAO {

	private static PerroDAO INSTANCE = null;

	private static final String SQL_GETBYID = "SELECT id, nombre, raza FROM perro WHERE id = ?;";
	private static final String SQL_GETALL = "SELECT id, nombre, raza FROM perro ORDER BY id DESC LIMIT 1000;";
	private static final String SQL_INSERT = "INSERT INTO perro  (nombre, raza) VALUES( ? , ?);";
	private static final String SQL_UPDATE = "UPDATE perro SET nombre = ? , raza = ? WHERE id = ?;";
	private static final String SQL_DELETE = "DELETE FROM perro WHERE id = ?;";

	// constructor privado, solo acceso por getInstance()
	private PerroDAO() {
		super();
	}

	public synchronized static PerroDAO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new PerroDAO();
		}
		return INSTANCE;
	}

	public Perro getById(long id) {

		Perro per = null;

		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_GETBYID);) {
			pst.setLong(1, id);

			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					per = rowMapper(rs);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return per;
	}

	public ArrayList<Perro> getAll() {

		ArrayList<Perro> perros = new ArrayList<Perro>();

		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_GETALL);
				ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				try {
					perros.add(rowMapper(rs));
				} catch (Exception e) {
					System.out.println("usuario no valido");
					e.printStackTrace();
				}
			} // while

		} catch (Exception e) {
			e.printStackTrace();
		}
		return perros;
	}

	public boolean insert(Perro per) throws SQLException {

		boolean resul = false;

		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_INSERT);) {

			pst.setString(1, per.getNombre());
			pst.setString(2, per.getRaza());
			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				resul = true;
			}

		}
		return resul;

	}

	public boolean update(Perro per) throws SQLException {

		boolean resul = false;
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_UPDATE);) {

			pst.setString(1, per.getNombre());
			pst.setString(2, per.getRaza());
			pst.setLong(3, per.getId());

			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				resul = true;
			}
		}
		return resul;

	}

	public boolean delete(long id) throws SQLException {

		boolean resul = false;
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement pst = conn.prepareStatement(SQL_DELETE);) {

			pst.setLong(1, id);

			int affectedRows = pst.executeUpdate();
			if (affectedRows == 1) {
				resul = true;
			}

		}
		return resul;

	}

	private Perro rowMapper(ResultSet rs) throws SQLException { // para comprobar en base de datos
		Perro per = new Perro();
		per.setId(rs.getLong("id"));
		per.setRaza(rs.getString("raza"));
		per.setNombre(rs.getString("nombre"));
		return per;
	}

}