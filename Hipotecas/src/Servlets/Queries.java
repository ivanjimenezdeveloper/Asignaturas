package Servlets;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Queries {
	private static PreparedStatement stm;
	private static java.sql.Connection con;
	private static PreparedStatement ps;
	private static final LoggerPool LOG = LoggerPool.getInstance();


	// Comprueba que exista un usuario y que coincida con su contrase�a
	// devuelve true o false segun si lo encontro o no

	/**
	 * Comprueba que exista un usuario y que coincida con su contraseña
	 * 
	 * @param usuario  Nick de usuario
	 * @param password Contraseña del usuario
	 * @return Devuelve true si encuentra al usuario o false si no lo encuentra
	 * @throws SQLException
	 */
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

			// Cuando encuentra el usuario cambia el boolean a true
			if (nombre != null) {

				encontrado = true;
			}
		}

		stm.close();
		con.close();
		rs.close();

		return encontrado;
	}

	// Busca si existe el nombre de usuario y devuelve un true o false segun su
	// resultado

	/**
	 * Comprueba a partir del Nick de usuario si existe
	 * 
	 * @param usuario Nick de usuario
	 * @return Devuelve true si encuentra al usuario o false si no lo encuentra
	 * @throws SQLException
	 */
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
			// Cuando encuentra el usuario cambia el boolean a true

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
	/**
	 * Busca la id de un Nick de usuario en caso negativo devuelve -1
	 * 
	 * @param usuario Nick de usuario
	 * @return id de usuario
	 * @throws SQLException
	 */
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

	// Busca segun la id del usuario las simulaciones del mismo y
	// devuelve una array con los resultados

	/**
	 * Busca las simulaciones creadas por el usuario
	 * 
	 * @param usuarioID id del usuario
	 * @return ArrayList de hipotecas con las simulaciones creadas por el usuario
	 */
	public static ArrayList<Hipoteca> querySimulaciones(int usuarioID) {

		ArrayList<Hipoteca> hipotecas = new ArrayList<Hipoteca>();
		Connection poolConn = Connection.getInstance();
		Hipoteca hp = new Hipoteca();
		String query = "SELECT * FROM SIMULACION where ID_USUARIO = ?";
		double capital;
		int interes, mes, cuadroAmortizado;

		try {
			con = poolConn.getConnection();

			ps = con.prepareStatement(query);

			ps.setInt(1, usuarioID);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				capital = rs.getDouble("CAPITAL");
				interes = rs.getInt("INTERES");
				mes = rs.getInt("MES");
				cuadroAmortizado = rs.getInt("CUADRO_AMORTIZACION");

				// Guarda los parametros en el objeto hipoteca
				hp.setCapital(capital);
				hp.setIntereses(interes);
				hp.setMeses(mes);
				hp.setCuadroAmortizado(cuadroAmortizado);

				// Guarda la hipoteca en la array
				hipotecas.add(hp);

				// Reinicio el objeto hipoteca
				hp = new Hipoteca();

			}

			// Devuelve la array
			return hipotecas;

		} catch (SQLException e) {
			LOG.setError(e.getMessage());
			LOG.setDebug(e.getMessage());
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
