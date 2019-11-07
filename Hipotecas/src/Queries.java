import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Queries {
	private static PreparedStatement stm;
	private static java.sql.Connection con;

	//Comprueba que exista un usuario y que coincida con su contraseña
	//devuelve true o false segun si lo encontro o no
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

	//Busca si existe el usuario y devuelve un true o false segun su resultado
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
	
	//Busca si existe el usuario y devuelve un true o false segun su resultado
	public static int UsuarioID(String usuario) throws SQLException {
		Connection poolConn = Connection.getInstance();
		con = poolConn.getConnection();
		String query = "SELECT ID FROM USUARIO WHERE USUARIO = ?";
		int id=-1;
		stm = con.prepareStatement(query);

		stm.setString(1, usuario);

		ResultSet rs = stm.executeQuery();

		while (rs.next()) {
			id = rs.getInt("ID");

		}

		stm.close();
		con.close();
		rs.close();
		
		return id;

	}
	

	
}
