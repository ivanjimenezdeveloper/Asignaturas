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
		pool = ConnectionPool.getInstance();
		try {
			cn = pool.getConnection();
			String query = "SELECT * FROM USUARIO WHERE USUARIO = ?";
			ps = cn.prepareStatement(query);
			ps.setString(1, user);

			rs = ps.executeQuery();

			while (rs.next()) {
				String usuario = rs.getString("USUARIO");

				if (usuario != null) {
					encontrado = true;
				}

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

		return encontrado;
	}
	
	public static boolean UsuarioLogin(String user, String pass) {
		boolean encontrado = false;
		pool = ConnectionPool.getInstance();
		try {
			cn = pool.getConnection();
			String query = "SELECT * FROM USUARIO WHERE USUARIO = ? AND PASS = ?";
			ps = cn.prepareStatement(query);
			ps.setString(1, user);
			ps.setString(2, pass);

			rs = ps.executeQuery();

			while (rs.next()) {
				String usuario = rs.getString("USUARIO");

				if (usuario != null) {
					encontrado = true;
				}

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

		return encontrado;
	}
}
