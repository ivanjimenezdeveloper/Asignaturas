package query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexion.ConnectionPool;

public class CRUD {

	private static Connection cn;
	private static PreparedStatement ps;

	/**
	 * Registra un nuevo usuario
	 * 
	 * @param nombre Nombre del usuario
	 * @param user   Nick del usuario
	 * @param pass   Contraseña del usuario
	 * @param img    Nombre de la imagen del usuario
	 * @return
	 */
	public static boolean registroUsuario(String nombre, String user, String pass, String img) {

		boolean existe = false, registroCorrecto = true;

		// Crea la conexion

		ConnectionPool pool = ConnectionPool.getInstance();

		try {
			cn = pool.getConnection();

			// Comprueba si existe un usuario con ese nombre de usuario

			existe = Mantenimiento.UsuarioExiste(user);

			
			 // Si el usuario existe no hara la query y devolvera false
			 

			if (existe == false) {

				String query = "INSERT INTO USUARIO(NOMBRE, USUARIO, PASS, FOTO, ADMINISTRADOR) VALUES(?,?,?,?,0)";
				ps = cn.prepareStatement(query);

				ps.setString(1, nombre);
				ps.setString(2, user);
				ps.setString(3, pass);
				ps.setString(4, "prueba");

				ps.executeUpdate();

				registroCorrecto = true;
			}

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

		return registroCorrecto;
	}

}
