package query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexion.ConnectionPool;

public class Valoracion {
	private static Connection cn;
	private static PreparedStatement ps;
	private static ResultSet rs;
	private static ConnectionPool pool;

	/**
	 * Inserta o hace una update de la valoracion de un juego por determinado usuario
	 * @param userID id de usuario
	 * @param juegoID id de juego
	 * @param valoracion valoracion dada por el usuario
	 */
	public static void valorarJuego(int userID, int juegoID, int valoracion) {
		boolean existe = false;
		
		/**
		 * Comprueba que la valoracion existe
		 */
		existe = valoracionExiste(userID, juegoID);
		/**
		 * Crea la conexion
		 */
		pool = ConnectionPool.getInstance();
		
		/**
		 * Si la valoracion no esta dentro del numero permitido no hara nada
		 */
		if (valoracion >= 1 && valoracion <= 5) {

			/**
			 * Si la valoracion de este juego con el mismo usuario existe hara un update, en caso contrario creara una valoracion nueva
			 */
			if (existe != false) {

				try {
					cn = pool.getConnection();

					/**
					 * Busca un usuario con el nick de usuario dado
					 */

					String query = "UPDATE VALORACION SET VALORACION = ?" + " WHERE IDJUEGO = ? AND IDUSUARIO = ?";
					ps = cn.prepareStatement(query);
					ps.setInt(1, valoracion);

					ps.setInt(2, juegoID);
					ps.setInt(3, userID);

					ps.executeUpdate();

				} catch (SQLException e) {

					e.printStackTrace();
				} finally {
					try {
						ps.close();
						cn.close();
						rs.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}

			} else {
				try {
					cn = pool.getConnection();

					/**
					 * Inserta la valoracion
					 */

					String query = "INSERT INTO VALORACION(IDJUEGO, IDUSUARIO, VALORACION) VALUES(?,?,?)";
					ps = cn.prepareStatement(query);
					ps.setInt(1, juegoID);
					ps.setInt(2, userID);
					ps.setInt(3, valoracion);

					ps.executeUpdate();

				} catch (SQLException e) {

					e.printStackTrace();
				} finally {
					try {
						ps.close();
						cn.close();
						rs.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}

			}
		}

	}
	
	/**
	 * Comprueba si existe una valoracion de un juego hecha por un usuario
	 * @param id id de usuario
	 * @param idJuego id del juego
	 * @return boolean que determina la existencia de la valoracion
	 */
	private static boolean valoracionExiste(int id, int idJuego) {

		/**
		 * Crea la conexion
		 */
		pool = ConnectionPool.getInstance();
		boolean encontrado = false;
		int idTabla = 0;

		try {
			cn = pool.getConnection();
			/**
			 * Busca una valoracion creada por un usuario sobre un juego
			 */
			String query = "SELECT * FROM VALORACION WHERE IDJUEGO = ? AND IDUSUARIO = ?";
			ps = cn.prepareStatement(query);
			ps.setInt(1, idJuego);
			ps.setInt(2, id);

			rs = ps.executeQuery();

			while (rs.next()) {
				idTabla = rs.getInt("ID");

				/**
				 * Si existe la row devolvera un encontrado
				 */
				if (idTabla != 0) {
					encontrado = true;
				}

			}
		} catch (SQLException e) {
		} finally {
			try {
				ps.close();
				cn.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return encontrado;

	}
	
	
	/**
	 * Calcula la media de valoraciones sobre un juego
	 * @param idJuego id del juego
	 * @return media del juego
	 */
	public static double valoracionMedia(int idJuego) {

		/**
		 * Crea la conexion
		 */
		pool = ConnectionPool.getInstance();
		double media = -1;

		try {
			cn = pool.getConnection();
			/**
			 * Crea la media de valoraciones sobre un juego
			 */
			String query = "SELECT AVG(VALORACION) AS MEDIA FROM VALORACION WHERE IDJUEGO = ? GROUP BY IDJUEGO";
			ps = cn.prepareStatement(query);
			ps.setInt(1, idJuego);

			rs = ps.executeQuery();

			while (rs.next()) {
				media = rs.getDouble("MEDIA");

			}
		} catch (SQLException e) {
		} finally {
			try {
				ps.close();
				cn.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return media;

	}

}
