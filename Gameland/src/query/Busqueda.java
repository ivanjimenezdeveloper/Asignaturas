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

		/*
		 * Arraylist que devuelve y el juego donde guardara los que contenga el result
		 * set
		 */
		ArrayList<Juego> juegoArr = new ArrayList<Juego>();
		Juego game = new Juego();

		// Se crea la conexion con la base de datos

		pool = ConnectionPool.getInstance();

		try {
			cn = pool.getConnection();

//			  Query que busca segun el mensaje

			String query = "SELECT * FROM JUEGO WHERE TITULO LIKE ?";
			ps = cn.prepareStatement(query);
			ps.setString(1, "%" + busqueda + "%");

//			 Variables que guardaran los valores antes de guardarlo en el objeto game

			int id, idGenero, idPlataforma, anyo;
			String titulo, img, descripcion;

			rs = ps.executeQuery();

			while (rs.next()) {

//				  Guarda los parametros en las variables

				id = rs.getInt("ID");
				idGenero = rs.getInt("IDGENERO");
				idPlataforma = rs.getInt("IDPLATAFORMA");
				anyo = rs.getInt("ANYO");

				titulo = rs.getString("TITULO");
				img = rs.getString("FOTO");
				descripcion = rs.getString("DESCRIPCION");

				// Guarda las variables en el objeto game

				game.setId(id);
				game.setIdGenero(idGenero);
				game.setIdPlataforma(idPlataforma);
				game.setAnyo(anyo);

				game.setTitulo(titulo);
				game.setImg(img);
				game.setDescripcion(descripcion);

				// Guarda el objeto game en la array

				juegoArr.add(game);

				// Reinicia el objeto game

				game = new Juego();

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

		return juegoArr;

	}

	/**
	 * Busca juegos por genero y ordenado por valoracion
	 * 
	 * @param idGeneroBusqueda id del genero
	 * @return Arraylist de juegos
	 */
	public static ArrayList<Juego> buscarPorGenero(int idGeneroBusqueda) {

		/*
		 * Arraylist que devuelve y el juego donde guardara los que contenga el result
		 * set
		 */
		ArrayList<Juego> juegoArr = new ArrayList<Juego>();
		Juego game = new Juego();

		// Se crea la conexion con la base de datos

		pool = ConnectionPool.getInstance();

		try {
			cn = pool.getConnection();

			// Busca juegos por genero y ordenado por valoracion y limita la busqueda a la
			// 10 juegos

			String query = "SELECT JUEGO.*, MEDIA \n" + "FROM JUEGO,\n" + "(\n"
					+ "	SELECT AVG(VALORACION) as MEDIA,  IDJUEGO \n" + "	FROM VALORACION\n" + "	GROUP BY IDJUEGO\n"
					+ ")TVALORACION \n" + "WHERE JUEGO.ID = TVALORACION.IDJUEGO AND IDGENERO = ? \n"
					+ "ORDER BY MEDIA DESC LIMIT 10";
			ps = cn.prepareStatement(query);
			ps.setInt(1, idGeneroBusqueda);

			// Variables que guardaran los valores antes de guardarlo en el objeto game

			int id, idGenero, idPlataforma, anyo;
			String titulo, img, descripcion;

			rs = ps.executeQuery();

			while (rs.next()) {

				// Guarda los parametros en las variables

				id = rs.getInt("ID");
				idGenero = rs.getInt("IDGENERO");
				idPlataforma = rs.getInt("IDPLATAFORMA");
				anyo = rs.getInt("ANYO");

				titulo = rs.getString("TITULO");
				img = rs.getString("FOTO");
				descripcion = rs.getString("DESCRIPCION");

				// Guarda las variables en el objeto game

				game.setId(id);
				game.setIdGenero(idGenero);
				game.setIdPlataforma(idPlataforma);
				game.setAnyo(anyo);

				game.setTitulo(titulo);
				game.setImg(img);
				game.setDescripcion(descripcion);

				// Guarda el objeto game en la array

				juegoArr.add(game);

				// Reinicia el objeto game

				game = new Juego();

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

		return juegoArr;

	}

	/**
	 * Busca juegos por genero y ordenado por valoracion
	 * 
	 * @param idGeneroPlataforma id de la plataforma
	 * @return Arraylist de juegos
	 */

	public static ArrayList<Juego> buscarPorPlataforma(int idPlataformaBusqueda) {

		/*
		 * Arraylist que devuelve y el juego donde guardara los que contenga el result
		 * set
		 */
		ArrayList<Juego> juegoArr = new ArrayList<Juego>();
		Juego game = new Juego();

		// Se crea la conexion con la base de datos

		pool = ConnectionPool.getInstance();

		try {
			cn = pool.getConnection();

			// Busca juegos por plataforma y ordenado por valoracion y limita la busqueda a
			// la
			// 10 juegos

			String query = "SELECT JUEGO.*, MEDIA \n" + "FROM JUEGO,\n" + "(\n"
					+ "	SELECT AVG(VALORACION) as MEDIA,  IDJUEGO \n" + "	FROM VALORACION\n" + "	GROUP BY IDJUEGO\n"
					+ ")TVALORACION \n" + "WHERE JUEGO.ID = TVALORACION.IDJUEGO AND IDPLATAFORMA = ? \n"
					+ "ORDER BY MEDIA DESC LIMIT 10";
			ps = cn.prepareStatement(query);
			ps.setInt(1, idPlataformaBusqueda);

			// Variables que guardaran los valores antes de guardarlo en el objeto game

			int id, idGenero, idPlataforma, anyo;
			String titulo, img, descripcion;

			rs = ps.executeQuery();

			while (rs.next()) {

				// Guarda los parametros en las variables

				id = rs.getInt("ID");
				idGenero = rs.getInt("IDGENERO");
				idPlataforma = rs.getInt("IDPLATAFORMA");
				anyo = rs.getInt("ANYO");

				titulo = rs.getString("TITULO");
				img = rs.getString("FOTO");
				descripcion = rs.getString("DESCRIPCION");

				// Guarda las variables en el objeto game

				game.setId(id);
				game.setIdGenero(idGenero);
				game.setIdPlataforma(idPlataforma);
				game.setAnyo(anyo);

				game.setTitulo(titulo);
				game.setImg(img);
				game.setDescripcion(descripcion);

				// Guarda el objeto game en la array

				juegoArr.add(game);

				// Reinicia el objeto game

				game = new Juego();

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

		return juegoArr;

	}

	/**
	 * Busca un juego segun su id
	 * 
	 * @param id id del juego
	 * @return Objeto juego
	 */
	public static Juego buscarJuegoPorId(int id) {

		Juego game = new Juego();

		// Crea la conexion

		pool = ConnectionPool.getInstance();
		int idJuego, idGenero, idPlataforma, anyo;
		String titulo, img, descripcion;
		try {
			cn = pool.getConnection();

			// Busca el juego segun la id

			String query = "SELECT * FROM JUEGO WHERE ID = ?";
			ps = cn.prepareStatement(query);
			ps.setInt(1, id);

			rs = ps.executeQuery();

			while (rs.next()) {

				// Guarda los parametros en las variables

				idJuego = rs.getInt("ID");
				idGenero = rs.getInt("IDGENERO");
				idPlataforma = rs.getInt("IDPLATAFORMA");
				anyo = rs.getInt("ANYO");

				titulo = rs.getString("TITULO");
				img = rs.getString("FOTO");
				descripcion = rs.getString("DESCRIPCION");

				// Guarda las variables en el objeto game

				game.setId(idJuego);
				game.setIdGenero(idGenero);
				game.setIdPlataforma(idPlataforma);
				game.setAnyo(anyo);

				game.setTitulo(titulo);
				game.setImg(img);
				game.setDescripcion(descripcion);

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

		return game;
	}

	/**
	 * Saca todos los juegos en la base de datos
	 * 
	 * @return ArrayList con todos los juegos
	 */

	public static ArrayList<Juego> todosLosJuego() {

		/*
		 * Arraylist que devuelve y el juego donde guardara los que contenga el result
		 * set
		 */
		ArrayList<Juego> juegoArr = new ArrayList<Juego>();
		Juego game = new Juego();

		// Se crea la conexion con la base de datos

		pool = ConnectionPool.getInstance();

		try {
			cn = pool.getConnection();

			// Query que busca todos los juegos

			String query = "SELECT * FROM JUEGO";
			ps = cn.prepareStatement(query);

			// Variables que guardaran los valores antes de guardarlo en el objeto game

			int id, idGenero, idPlataforma, anyo;
			String titulo, img, descripcion;

			rs = ps.executeQuery();

			while (rs.next()) {

				// Guarda los parametros en las variables

				id = rs.getInt("ID");
				idGenero = rs.getInt("IDGENERO");
				idPlataforma = rs.getInt("IDPLATAFORMA");
				anyo = rs.getInt("ANYO");

				titulo = rs.getString("TITULO");
				img = rs.getString("FOTO");
				descripcion = rs.getString("DESCRIPCION");

				// Guarda las variables en el objeto game

				game.setId(id);
				game.setIdGenero(idGenero);
				game.setIdPlataforma(idPlataforma);
				game.setAnyo(anyo);

				game.setTitulo(titulo);
				game.setImg(img);
				game.setDescripcion(descripcion);

				// Guarda el objeto game en la array

				juegoArr.add(game);

				// Reinicia el objeto game

				game = new Juego();

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

		return juegoArr;

	}
}
