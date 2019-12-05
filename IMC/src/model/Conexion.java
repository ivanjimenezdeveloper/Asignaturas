package model;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


/**
 * Hace la conexion a la base de datos
 * @author horabaixa
 *
 */
public class Conexion {
	private static Conexion instancia = null;
	private static Context initContext;
	private static Context envContext;
	private static DataSource DS;

	private Conexion() {

		try {
			
			 //Inicio el los contextos para usar la base de datos
			 
			initContext = new InitialContext();
			envContext = (Context) initContext.lookup("java:/comp/env");
			DS = (DataSource) envContext.lookup("jdbc/IMC");

		} catch (NamingException e) {
// Logger
		}
	}
	
	/**
	 * Inicia la instancia de la conexion si no esta iniciada
	 * @return Objeto de conexion instanciado
	 */
	public static Conexion getInstance() {
		if (instancia == null) {
			synchronized (Conexion.class) {

				if (instancia == null) {
					instancia = new Conexion();
				}

			}

		}
		return instancia;
	}
	
	/**
	 * Devuelve la conexion del DataSource
	 * @return Devuelve la conexion del DataSource
	 * @throws SQLException
	 */

	public Connection getConnection() throws SQLException {
		return DS.getConnection();
	}
}
