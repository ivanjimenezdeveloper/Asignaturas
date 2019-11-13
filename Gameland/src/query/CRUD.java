package query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexion.ConnectionPool;

public class CRUD {

	private static Connection cn;
	private static PreparedStatement ps;

	public static boolean registroUsuario(String nombre, String user, String pass, String img) {

		boolean existe = false, registroCorrecto = false;

		ConnectionPool pool = ConnectionPool.getInstance();

		try {
			cn = pool.getConnection();

			// Guardar si existe el usuario cogido o no en el boolean

			existe = Mantenimiento.UsuarioExiste(user);

			if (existe = true) {
				registroCorrecto = false;
			} else {

				String query = "INSERT INTO USUARIO(NOMBRE, USUARIO, PASS, FOTO, ADMINISTRADOR) VALUES(?,?,?,?,0)";
				ps.setString(1, nombre);
				ps.setString(2, user);
				ps.setString(2, pass);
				ps.setString(3, "prueba");
				
				ps.executeUpdate();
				
				registroCorrecto = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				cn.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return registroCorrecto;
	}

}
