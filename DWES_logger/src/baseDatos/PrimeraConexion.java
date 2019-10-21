package baseDatos;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PrimeraConexion
 */
@WebServlet("/PrimeraConexion")
public class PrimeraConexion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PrimeraConexion() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection cn = conexion(response);
		query(cn, response);
		try {
			update(cn, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		query(cn, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * 
	 * Crea la conexion
	 * 
	 * @param response
	 * @return Devuelve el objeto conexion para interactuar con queries
	 * @throws IOException
	 */
	private Connection conexion(HttpServletResponse response) throws IOException {
		Connection connection;
		PrintWriter out = response.getWriter();
		// URL de la base de datos
		String url = "jdbc:mysql://localhost:3306/USUARIOS?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			out.println("NO FUNSIONA");

		}

		try {
//creo la conexion con la url el usuario  su contraseña
			connection = DriverManager.getConnection(url, "root", "password");

			out.println("************* CONEXION ESTABLECIDA **********************\n");
			return connection;

		} catch (SQLException e) {
			out.println("NO FUNSIONA");
			out.println(e.getMessage());
			out.println(e.getSQLState());
			out.println(e.getErrorCode());

		}

		return null;
	}

	private void query(Connection con, HttpServletResponse response) throws IOException {
		String qr = "SELECT * FROM USUARIO";

		try {
			Statement smt = con.createStatement();
			ResultSet rs = smt.executeQuery(qr);

			while (rs.next()) {
				Integer id = rs.getInt("ID");
				String nombre = rs.getString("USUARIO");
				String passwd = rs.getString("PASSWORD");

				response.getWriter().println("ID: " + id + " USUARIO: " + nombre + " PASSWORD: " + passwd);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void update(Connection con, HttpServletResponse response) throws SQLException {
		String qr = "UPDATE USUARIO\n" + "SET USUARIO='FERNANDOTOMAS'\n" + "WHERE ID = 1";

		Statement smt = con.createStatement();
		smt.executeUpdate(qr);
	}
}
