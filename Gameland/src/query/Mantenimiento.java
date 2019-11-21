package query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexion.ConnectionPool;

public class Mantenimiento {

	private static Connection cn;
	private static PreparedStatement ps;
	private static ResultSet rs;
	private static ConnectionPool pool;

	/**
	 * Busca segun el nombre de usuario si existe ya un usuario con ese mismo nick
	 * 
	 * @param user Nick de usuario
	 * @return boolean que determina la existencia del usuario
	 */
	public static boolean UsuarioExiste(String user) {
		boolean encontrado = false;

		// Crea la conexion

		pool = ConnectionPool.getInstance();
		try {
			cn = pool.getConnection();

			// Busca un usuario con el nick de usuario dado

			String query = "SELECT * FROM USUARIO WHERE USUARIO = ?";
			ps = cn.prepareStatement(query);
			ps.setString(1, user);

			rs = ps.executeQuery();

			while (rs.next()) {
				String usuario = rs.getString("USUARIO");

				// Si encuentra al usuario cambiara el boolean a true

				if (usuario != null) {
					encontrado = true;
				}

			}

		} catch (SQLException e) {
			// Logger
		} finally {
			try {
				ps.close();
				cn.close();
				rs.close();
			} catch (SQLException e) {
				// Logger
			}

		}

		return encontrado;
	}

	/**
	 * Comprueba si existe un usuario con ese nick y esa contraseña
	 * 
	 * @param user Nick de usuario
	 * @param pass Contraseña de usuario
	 * @return boolean que determina si existe o no esa combinacion de usuario y
	 *         contraseña
	 */
	public static boolean UsuarioLogin(String user, String pass) {
		boolean encontrado = false;

		// Crea la conexion

		pool = ConnectionPool.getInstance();
		try {
			cn = pool.getConnection();

			/*
			 * Crea la query donde busca un usuario con esa combinacion de usuario y
			 * contraseña
			 */
			String query = "SELECT * FROM USUARIO WHERE USUARIO = ? AND PASS = ?";
			ps = cn.prepareStatement(query);
			ps.setString(1, user);
			ps.setString(2, pass);

			rs = ps.executeQuery();

			while (rs.next()) {
				String usuario = rs.getString("USUARIO");

				/**
				 * Si encuentra al usuario cambiara el boolean a true
				 */
				if (usuario != null) {
					encontrado = true;
				}

			}

		} catch (SQLException e) {
			// Logger
		} finally {
			try {
				ps.close();
				cn.close();
				rs.close();
			} catch (SQLException e) {
				// Logger
			}

		}

		return encontrado;
	}

	/**
	 * Devuelve la id del usuario segun el nick
	 * 
	 * @param user nick de usuario
	 * @return id de usuario
	 */
	public static int idUsuario(String user) {

		// Crea la conexion

		pool = ConnectionPool.getInstance();
		try {
			cn = pool.getConnection();

			// Crea la query donde busca un usuario con el nick dado

			String query = "SELECT * FROM USUARIO WHERE USUARIO = ?";
			ps = cn.prepareStatement(query);
			ps.setString(1, user);

			rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("ID");

				// Si encuentra una usuario con una id superior a 0 devuelve la id

				if (id > 0) {
					return id;
				}

			}

		} catch (SQLException e) {
			// Logger
		} finally {
			try {
				ps.close();
				cn.close();
				rs.close();
			} catch (SQLException e) {
				// Logger
			}

		}

		// Si no encuentra la id devuelve -1

		return -1;
	}

	/**
	 * Comprueba si el usuario dado es un administrador
	 * 
	 * @param user nick de usuario
	 * @return boolean que declara si es o no administrador
	 */
	public static boolean esAdministrador(String user) {

		boolean encontrado = false;

		// Crea la conexion

		pool = ConnectionPool.getInstance();
		try {
			cn = pool.getConnection();

			// Crea la query donde busca un usuario con el nick dado

			String query = "SELECT * FROM USUARIO WHERE USUARIO = ?";
			ps = cn.prepareStatement(query);
			ps.setString(1, user);

			rs = ps.executeQuery();

			while (rs.next()) {
				int admin = rs.getInt("ADMINISTRADOR");

				// Si el usuario es admin cambiara encontrado a true

				if (admin == 1) {
					encontrado = true;
				}

			}

		} catch (SQLException e) {
			// Logger
		} finally {
			try {
				ps.close();
				cn.close();
				rs.close();
			} catch (SQLException e) {
				// Logger
			}

		}

		return encontrado;

	}

	/**
	 * Edita un juego de la base de datos
	 * 
	 * @param id         id del juego
	 * @param titulo     titulo del juego
	 * @param year       anyo del juego
	 * @param desc       descripcion del juego
	 * @param plataforma id de la plataforma
	 * @param genero     id del genero
	 * @param foto       nombre de la foto
	 */
	public static void editarJuego(int id, String titulo, int year, String desc, int plataforma, int genero,
			String foto) {

		// Crea la conexion

		ConnectionPool pool = ConnectionPool.getInstance();

		try {
			cn = pool.getConnection();

			// Hace un update de un juego segun la id
			String query = "UPDATE JUEGO SET TITULO = ?, ANYO = ?, FOTO=?, DESCRIPCION = ?, IDGENERO = ?, IDPLATAFORMA = ?  WHERE ID= ?";
			ps = cn.prepareStatement(query);

			ps.setString(1, titulo);
			ps.setInt(2, year);
			ps.setString(3, foto);
			ps.setString(4, desc);
			ps.setInt(5, genero);
			ps.setInt(6, plataforma);
			ps.setInt(7, id);

			ps.executeUpdate();

		} catch (SQLException e) {
			// Logger
			} finally {
			try {
				cn.close();
				ps.close();
			} catch (SQLException e) {
				// Logger
				}
		}

	}

	/**
	 * Borra el juego segun su id
	 * 
	 * @param id id del juego
	 */
	public static void borrarJuego(int id) {

		// Crea la conexion

		borrarValoracion(id);

		ConnectionPool pool = ConnectionPool.getInstance();

		try {
			cn = pool.getConnection();

			// Borra el juego donde coincida con la id
			String query = "DELETE FROM JUEGO WHERE ID = ?";
			ps = cn.prepareStatement(query);

			ps.setInt(1, id);

			ps.executeUpdate();

		} catch (SQLException e) {
			// Logger
			} finally {
			try {
				cn.close();
				ps.close();
			} catch (SQLException e) {
				// Logger
				}
		}

	}

	/**
	 * Borra las valoraciones segun la id del juego
	 * 
	 * @param id id del juego
	 */
	public static void borrarValoracion(int id) {

		// Crea la conexion

		ConnectionPool pool = ConnectionPool.getInstance();

		try {
			cn = pool.getConnection();

			// Borra la valoracion que coincida con la id del juego
			String query = "DELETE FROM VALORACION WHERE valoracion.IDJUEGO =?";
			ps = cn.prepareStatement(query);

			ps.setInt(1, id);

			ps.executeUpdate();

		} catch (SQLException e) {
			// Logger
			} finally {
			try {
				cn.close();
				ps.close();
			} catch (SQLException e) {
				// Logger
				}
		}

	}

	/**
	 * Anyade un juego a la base de datos
	 * 
	 * @param titulo     titulo del juego
	 * @param year       anyo de salida
	 * @param desc       descripcion
	 * @param plataforma id de la plataforma
	 * @param genero     id del genero
	 * @param foto       nombre de la foto
	 */
	public static void addGame(String titulo, int year, String desc, int plataforma, int genero, String foto) {

		// Crea la conexion

		ConnectionPool pool = ConnectionPool.getInstance();

		try {
			cn = pool.getConnection();

			String query = "INSERT INTO JUEGO(TITULO, ANYO, FOTO, DESCRIPCION, IDGENERO, IDPLATAFORMA) VALUES(?, ?, ?, ?, ?,?) ";
			ps = cn.prepareStatement(query);

			ps.setString(1, titulo);
			ps.setInt(2, year);
			ps.setString(3, foto);
			ps.setString(4, desc);
			ps.setInt(5, genero);
			ps.setInt(6, plataforma);

			ps.executeUpdate();

		} catch (SQLException e) {
			// Logger
		} finally {
			try {
				cn.close();
				ps.close();
			} catch (SQLException e) {
				// Logger
			}
		}
	}
}
