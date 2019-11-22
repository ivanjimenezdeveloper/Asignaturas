package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.ConnectionPool;

public class Dao {
	private static Connection cn;
	private static PreparedStatement ps;
	private static ResultSet rs;
	private static ConnectionPool pool;

	public static ArrayList<Categoria> getCategorias() {

		ArrayList<Categoria> catArr = new ArrayList<Categoria>();
		Categoria cat = new Categoria();

		/**
		 * Se crea la conexion con la base de datos
		 */
		pool = ConnectionPool.getInstance();

		try {
			cn = pool.getConnection();
			/**
			 * Query que busca segun el mensaje
			 */
			String query = "SELECT * FROM CATEGORIA";
			ps = cn.prepareStatement(query);

			/**
			 * Variables que guardaran los valores antes de guardarlo en el objeto game
			 */
			int id;
			String nombre;

			rs = ps.executeQuery();

			while (rs.next()) {

				/**
				 * Guarda los parametros en las variables
				 */

				id = rs.getInt("ID");
				nombre = rs.getString("NOM");

				/**
				 * Guarda las variables en el objeto game
				 */

				cat.setKey(new CategoriaKey(id));
				cat.setNom(nombre);

				/**
				 * Guarda el objeto game en la array
				 */

				catArr.add(cat);
				/**
				 * Reinicia el objeto game
				 */

				cat = new Categoria();
				rs.close();
				ps.close();
				cn.close();
			}

		} catch (SQLException e) {

		}

		return catArr;

	}

}
