package query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.ConnectionPool;
import entidad.Juego;

public class Busqueda {
	private static Connection cn;
	private static PreparedStatement ps;
	private static ResultSet rs;
	private static ConnectionPool pool;

	/**
	 * Devuelve una array de juegos con el mensaje que se ha recibido
	 * 
	 * @param busqueda palabra que comparar para encontrar juegos
	 * @return Arraylist de juegos que coinciden con la busqueda
	 */
	public static ArrayList<Juego> busquedaGeneral(String busqueda) {

		/**
		 * Arraylist que devuelve y el juego donde guardara los que contenga el result
		 * set
		 */
		ArrayList<Juego> juegoArr = new ArrayList<Juego>();
		Juego game = new Juego();

		/**
		 * Se crea la conexion con la base de datos
		 */
		pool = ConnectionPool.getInstance();

		try {
			cn = pool.getConnection();

			/**
			 * Query que busca segun el mensaje
			 */
			String query = "SELECT * FROM JUEGO WHERE TITULO LIKE ?";
			ps = cn.prepareStatement(query);
			ps.setString(1, "%" + busqueda + "%");

			/**
			 * Variables que guardaran los valores antes de guardarlo en el objeto game
			 */
			int id, idGenero, idPlataforma, anyo;
			String titulo, img, descripcion;

			rs = ps.executeQuery();

			while (rs.next()) {

				/**
				 * Guarda los parametros en las variables
				 */

				id = rs.getInt("ID");
				idGenero = rs.getInt("IDGENERO");
				idPlataforma = rs.getInt("IDPLATAFORMA");
				anyo = rs.getInt("ANYO");

				titulo = rs.getString("TITULO");
				img = rs.getString("FOTO");
				descripcion = rs.getString("DESCRIPCION");

				/**
				 * Guarda las variables en el objeto game
				 */

				game.setId(id);
				game.setIdGenero(idGenero);
				game.setIdPlataforma(idPlataforma);
				game.setAnyo(anyo);

				game.setTitulo(titulo);
				game.setImg(img);
				game.setDescripcion(descripcion);

				
				/**
				 * Guarda el objeto game en la array
				 */
				
				juegoArr.add(game);

				/**
				 * Reinicia el objeto game
				 */
				
				game = new Juego();

			}

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

		return juegoArr;

	}
}
