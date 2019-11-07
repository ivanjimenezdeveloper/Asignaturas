import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Queries {
	private static PreparedStatement stm;
	private static java.sql.Connection con;
	private static PreparedStatement ps;

	// Comprueba que exista un usuario y que coincida con su contrase�a
	// devuelve true o false segun si lo encontro o no
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

			//Cuando encuentra el usuario cambia el boolean a true
			if (nombre != null) {

				encontrado = true;
			}
		}

		stm.close();
		con.close();
		rs.close();

		return encontrado;
	}

	// Busca si existe el nombre de usuario y devuelve un true o false segun su resultado
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
			//Cuando encuentra el usuario cambia el boolean a true

			if (nombre != null) {

				encontrado = true;
			}
		}

		stm.close();
		con.close();
		rs.close();

		return encontrado;
	}

	// Busca si existe el usuario y devuelve un true o false segun su resultado
	public static int UsuarioID(String usuario) throws SQLException {
		Connection poolConn = Connection.getInstance();
		con = poolConn.getConnection();
		String query = "SELECT ID FROM USUARIO WHERE USUARIO = ?";
		int id = -1;
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

	//Busca segun la id del usuario las simulaciones del mismo y
	// devuelve una array con los resultados
	public static ArrayList<Hipoteca> querySimulaciones(int usuarioID) {

		ArrayList<Hipoteca> hipotecas = new ArrayList<Hipoteca>();
		Connection poolConn = Connection.getInstance();
		Hipoteca hp = new Hipoteca();
		String query = "SELECT * FROM SIMULACION where ID_USUARIO = ?";
		double capital;
		int interes, mes;
		try {
			con = poolConn.getConnection();

			ps = con.prepareStatement(query);

			ps.setInt(1, usuarioID);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				capital = rs.getDouble("CAPITAL");
				interes = rs.getInt("INTERES");
				mes = rs.getInt("MES");
				
				//guarda los parametros en el objeto hipoteca 
				hp.setCapital(capital);
				hp.setIntereses(interes);
				hp.setMeses(mes);

				//Guarda la hipoteca en la array
				hipotecas.add(hp);

				//Reinicio el objeto hipoteca
				hp = new Hipoteca();

			}
			//Devuelve la array
			return hipotecas;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
				stm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return hipotecas;

	}

}
