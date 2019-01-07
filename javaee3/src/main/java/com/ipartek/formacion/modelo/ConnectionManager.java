package com.ipartek.formacion.modelo;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.apache.log4j.Logger;


public class ConnectionManager {  // CLASE 
	
// VARIABLES
	//constante para mensajes de errores
	private final static Logger LOG = Logger.getLogger(ConnectionManager.class);
	
	// variable para METODO getConnection
	private static Connection conn;
	
// METODO DE 
	public static Connection getConnection() {  // metodo de la clase DRIVERMANAGER DE LA API

		conn = null;
		try {
			//cargar properties
			Properties prop = new Properties();  //guardo las propiedades de database.properties en un objeto de tipo Properties
			
			InputStream input = ConnectionManager.class.getClassLoader().getResourceAsStream("database.properties");	
			prop.load(input); // cargo el fichero en las properties
			LOG.debug("cargado fichero properties");  // mensaje
			
			//comprobar que exista .jar para mysql
			Class.forName(prop.getProperty("ddbb.driver")).newInstance();
			LOG.debug("Existe driver mysql");
			
			//crear conexion
			conn = DriverManager.getConnection(
								prop.getProperty("ddbb.url"), 
								prop.getProperty("ddbb.user"),
								prop.getProperty("ddbb.pass"));
			
			LOG.info("conexion establecida");

		}catch (Exception e) {
			
			LOG.fatal("Error estableciendo conexion base datos" , e);
			
		}	
		return conn;

	}
}
