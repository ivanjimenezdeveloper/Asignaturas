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

			initContext = new InitialContext();
			envContext = (Context) initContext.lookup("java:/comp/env");
			DS = (DataSource) envContext.lookup("jdbc/GAMELAND");

		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public static ConnectionPool getInstance() {
		if(instancia == null) {
			synchronized (ConnectionPool.class) {
				
				if(instancia == null) {
					instancia = new ConnectionPool();
				}
				
			}
			
		}
	return instancia;
	}
	
	public Connection getConnection() throws SQLException {
		return DS.getConnection();
	}

}
