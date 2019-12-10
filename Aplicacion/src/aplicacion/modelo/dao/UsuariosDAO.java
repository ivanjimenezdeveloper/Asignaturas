package aplicacion.modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.slf4j.LoggerFactory;

import aplicacion.modelo.pojo.Usuario;
import ch.qos.logback.classic.Logger;

/**
 * Clase que accede a datos de usuarios
 * @author daw
 *
 */
public class UsuariosDAO {

	/**
	 * Logger
	 */
	private static final Logger logger = (Logger) LoggerFactory.getLogger(UsuariosDAO.class);	

	
	/**
	 * Obtiene una lista con todos los usuarios existentes
	 * @return Una lista con todos los usuarios existentes
	 */
	public ArrayList<Usuario> getUsuarios() {
		ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();

		Connection conn = null;
		Statement stmt = null;

		try {
			conn = this.getConnection();

			if (conn != null) {
				// Obtenemos los usuarios y rellenamos una lista que vamos a devolver
				stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM Usuarios");

				Usuario usuario;
				// Recorremos la lista de usuarios que hay en base de datos
				while (rs.next()) {
					// Añadimos el usuario a la lista
					usuario = new Usuario(rs.getInt("id"), rs.getString("nombre"), rs.getString("usuario"),
							rs.getString("password"));
					listaUsuarios.add(usuario);
				}

				rs.close();
			}

		} catch (Exception e) {
			logger.error("ERROR DAO: " + e.getMessage());
		} finally {
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
				logger.error("ERROR DAO: " + se.getMessage());
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				logger.error("ERROR DAO: " + se.getMessage());
			}
		}

		return listaUsuarios;
	}

	/**
	 * Comprueba si existe un usuario y devuelve su información
	 * @param user El nombre de usuario a comprobar
	 * @param pass El password de usuario a comprobar
	 * @return Un objeto Usuario con la información del usuario si existe y null si no existe
	 */
	public Usuario existeUsuario(String user, String pass) {
		Usuario usuario = null;

		if ((user != null) && (pass != null)) {
			Connection conn = null;
			Statement stmt = null;

			try {
				conn = this.getConnection();

				if (conn != null) {
					// Obtenemos los usuarios y rellenamos una lista que vamos a devolver
					stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(
							"SELECT * FROM Usuarios WHERE usuario='" + user + "' AND password='" + pass + "'");

					// Comprobamos que ha devuelto algun usuario
					rs.last();
					if (rs.getRow() > 0) {
						// Si ha devuelto un usuario creamos un objeto Usuario que vamos a devolver
						rs.first();
						usuario = new Usuario(rs.getInt("id"), rs.getString("nombre"), rs.getString("usuario"),	rs.getString("password"));
					}

					rs.close();
				}
			} catch (Exception e) {
				logger.error("ERROR DAO: " + e.getMessage());
			} finally {
				try {
					if (stmt != null)
						conn.close();
				} catch (SQLException se) {
					logger.error("ERROR DAO: " + se.getMessage());
				}
				try {
					if (conn != null)
						conn.close();
				} catch (SQLException se) {
					logger.error("ERROR DAO: " + se.getMessage());
				}
			}
		}

		return usuario;
	}

	/**
	 * Obtiene una conexión con base de datos
	 * 
	 * @return Una conexión con base de datos
	 */
	private Connection getConnection() {
		Connection conn = null;

		Context initContext;
		try {
			initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/aplicacion");
			conn = ds.getConnection();
		} catch (Exception e) {
			logger.error("ERROR DAO: " + e.getMessage());
		}

		return conn;
	}
}
