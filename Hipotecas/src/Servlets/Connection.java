package Servlets;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public final class Connection {

	private static Connection instancia = null;
	private static Context initContext;
	private static Context envContext;
	private static DataSource DatSrc;
/**
 * 
 * Constructor de Connection que crea las conexiones por medio del contexto
 */
	private Connection() {

		try {

			initContext = new InitialContext();
			envContext = (Context) initContext.lookup("java:/comp/env");
			DatSrc = (DataSource) envContext.lookup("jdbc/HIPOTECA");

		} catch (NamingException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Crea una instancia del objeto connection y la devuelve
	 * @return Devuelve el objeto Connection
	 */
	public static Connection getInstance() {

		if (instancia == null) {
			synchronized (Connection.class) {

				if (instancia == null) {
					instancia = new Connection();
				}

			}

		}

		return instancia;
	}
	
	/**
	 * Devuelve el objeto connection
	 * @return devuelve el objeto connection
	 * @throws SQLException
	 */
	public java.sql.Connection getConnection() throws SQLException{
		
		return DatSrc.getConnection();
	}

}
