import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

public class Queries {
	private static PreparedStatement stm;
	private static java.sql.Connection con;

	public static boolean hipotecaContains(String usuario, String password) throws SQLException {
		Connection poolConn = Connection.getInstance();
		con = poolConn.getConnection();
		String query = "SELECT * FROM USUARIO WHERE USUARIO = ? AND PASS = ?";
		stm = con.prepareStatement(query);
		boolean encontrado = false;

		stm.setString(1, usuario);
		stm.setString(2, password);

		ResultSet rs = stm.executeQuery();

		while (rs.next()) {
			String nombre = rs.getString("NOMBRE");

			if (nombre != null) {

				encontrado = true;
			}
		}

		stm.close();
		con.close();
		rs.close();

		return encontrado;
	}

	public static boolean UsuarioExiste(String usuario) throws SQLException {
		Connection poolConn = Connection.getInstance();
		con = poolConn.getConnection();
		String query = "SELECT * FROM USUARIO WHERE USUARIO = ?";
		stm = con.prepareStatement(query);
		boolean encontrado = false;

		stm.setString(1, usuario);

		ResultSet rs = stm.executeQuery();

		while (rs.next()) {
			String nombre = rs.getString("NOMBRE");

			if (nombre != null) {

				encontrado = true;
			}
		}

		stm.close();
		con.close();
		rs.close();

		return encontrado;
	}

	
}
