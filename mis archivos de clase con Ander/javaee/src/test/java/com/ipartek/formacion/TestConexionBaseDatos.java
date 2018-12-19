package com.ipartek.formacion;
import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import com.ipartek.formacion.ejemplocapas.pojos.Usuario;
import com.mysql.jdbc.Statement;

public class TestConexionBaseDatos {
	
	
	@Test
	public void testConexion() {
		
		// try catch
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();  // comprbar que existe el driver
			
		} catch (Exception e) {
			fail("No exite el driver, meter dependencia en el pom.xml");
		}
		
		try {  // conectar a la base de datos
			Connection conn =  DriverManager.getConnection("jdbc:mysql://192.168.0.44/youtube?useSSL=false","viernes", "juernes");
			assertNotNull(conn);
			
			/*
			// Preparamos la consulta 
			Statement s = (Statement) conn.createStatement(); // 
			ResultSet rs = s.executeQuery ("select * from usuario");  //select* from usuario
			
			while (rs.next()) 
			{ 
			    System.out.println (rs.getInt(1) + " " + rs.getString(2)+ " " + rs.getString(3)); 
			}
			
			*/
			
			
			// Recorremos el resultado, mientras haya registros para leer, y escribimos el resultado en pantalla. 
			
			// consulta ander
			String sql="SELECT id, nombre, password forom usuario order by id desc limit 500;";
			PreparedStatement pst = conn.prepareStatement (sql);  // para ejecutar sentencias 
			ResultSet rs = pst.executeQuery ("select * from usuario");  //select* from usuario

			while (rs.next()) 
			{ 
			  int id=  rs.getInt("id");
			  String nombre=  rs.getString("nombre");
			  String password = rs.getString("password"); 
			
			System.out.println(id + "" + nombre + "" + password);
			}
			
		} catch (Exception e) {
			fail("no se pudo establecer conexion" + e.getMessage());

		}
		
	}
	
	

	@Test
	public void testTonto() {
		assertTrue(true);
		assertFalse(false);
		assertEquals("manolo", "manolo");
		
		String email = "ander@ipartek.com";
		String pass = "Pa$$w0rd";
		
		Usuario u = new Usuario((long)-1, email, pass);
		
		assertNotNull(u);
		assertEquals(email, u.getEmail());
		assertEquals(pass, u.getPassword());
		
		try {
			u = new Usuario((long)-1, "noEmail", pass);
			fail("deberia haber lanzado Excepcion");
			
		} catch (Exception e) {
			assertEquals(e.getMessage(), "El formato del email no es correcto");
		}
	}

}
