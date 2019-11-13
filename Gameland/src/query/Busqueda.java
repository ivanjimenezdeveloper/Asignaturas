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

	public static ArrayList<Juego> busquedaGeneral(String busqueda) {

		ArrayList<Juego> juegoArr = new ArrayList<Juego>();
		Juego game = new Juego();
		pool = ConnectionPool.getInstance();

		try {
			cn = pool.getConnection();
			String query = "SELECT * FROM JUEGO WHERE TITULO LIKE ?";
			ps = cn.prepareStatement(query);
			ps.setString(1, "%"+busqueda+"%");

			int id, idGenero, idPlataforma, anyo;
			String titulo, img, descripcion;

			rs = ps.executeQuery();

			while (rs.next()) {
				id = rs.getInt("ID");
				idGenero = rs.getInt("IDGENERO");
				idPlataforma = rs.getInt("IDPLATAFORMA");
				anyo = rs.getInt("ANYO");

				titulo = rs.getString("TITULO");
				img = rs.getString("FOTO");
				descripcion = rs.getString("DESCRIPCION");

				game.setId(id);
				game.setIdGenero(idGenero);
				game.setIdPlataforma(idPlataforma);
				game.setAnyo(anyo);

				game.setTitulo(titulo);
				game.setImg(img);
				game.setDescripcion(descripcion);

				juegoArr.add(game);

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
