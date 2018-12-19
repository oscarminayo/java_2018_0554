package com.ipartek.formacion.modelo.daos;

import java.sql.Connection;

import com.ipartek.formacion.modelo.pojos.Perro;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PerroDAO {
	
	/**
	 * comprobar si existe el Perro en la bbdd
	 * @param email String 
	 * @param pass String contraseña
	 * @return Perro con datos si existe, null si no existe
	 */
	

	public ArrayList<Perro> getAll() {
		
		ArrayList<Perro> Perros = new ArrayList<Perro>();
		String sql = "SELECT id, nombre, password FROM Perro ORDER BY id DESC LIMIT 500";		
		
		try ( Connection conn = ConnectionManager.getConnection();
			  PreparedStatement pst = conn.prepareStatement(sql);
			  ResultSet rs = pst.executeQuery() 
			){
			
			while(rs.next()) { 			
				try {
					Perro Perro = new Perro();
					Perro.setId( rs.getLong("id"));
					Perro.setNombre( rs.getString("nombre"));
					Perro.setRaza(rs.getString("raza"));
					Perro.setChip(rs.getLong("chip"));
					// añadir en array
					Perros.add(Perro);
				}catch (Exception e) {
					System.out.println("Perro no valido");
					e.printStackTrace();
				}		
			} // while	
			
		}catch (Exception e) {
			e.printStackTrace();
		}		
		return Perros;
	}

}