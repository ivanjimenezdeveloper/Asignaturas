package conexion;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionPool {
	private static ConnectionPool instancia = null;
	private static Context initContext;
	private static Context envContext;
	private static DataSource DS;

	private ConnectionPool() {

		try {
			/**
			 * Inicio el los contextos para usar la base de datos
			 */
			initContext = new InitialContext();
			envContext = (Context) initContext.lookup("java:/comp/env");
			DS = (DataSource) envContext.lookup("jdbc/DAO");

		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Inicia la instancia de la conexion si no esta iniciada
	 * @return Objeto de conexion instanciado
	 */
	public static ConnectionPool getInstance() {
		if (instancia == null) {
			synchronized (ConnectionPool.class) {

				if (instancia == null) {
					instancia = new ConnectionPool();
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
