import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CRUD {
	private static Statement stm;
	private static java.sql.Connection con;
	private static PreparedStatement ps;

	// Select all de la tabla usuarios
	public static ArrayList<Usuario> SelectAll() throws SQLException {
		Connection poolConn = Connection.getInstance();
		con = poolConn.getConnection();
		stm = con.createStatement();
		ResultSet rs = stm.executeQuery("SELECT * FROM USUARIO");

		ArrayList<Usuario> toReturn = new ArrayList<Usuario>();

		while (rs.next()) {
			Integer id = rs.getInt("ID");
			String nombre = rs.getString("NOMBRE");
			String usuario = rs.getString("USUARIO");
			String pass = rs.getString("PASS");
			String nombreFoto = rs.getString("NOMBRE_FOTO");
			Usuario usr = new Usuario();

			usr.setId(id);
			usr.setNombre(nombre);
			usr.setUsuario(usuario);
			usr.setPass(pass);
			usr.setNombreFoto(nombreFoto);

			toReturn.add(usr);
		}

		stm.close();
		con.close();
		rs.close();

		return toReturn;

	}

	// Registra al usuario haciendo un insert a la tabla usuario devuelve true o false segun si se ha realizado
	// el insert
	public static boolean registroUsuario(String nombre, String usuario, String pass, String img) throws SQLException {

		// Crea la conexion desde la pool de conexiones

		Connection poolcn = Connection.getInstance();

		con = poolcn.getConnection();

		boolean existe = false;
		
		//Lanza una querie que devuelve un boolean si encuentra un usuario devuelve true
		existe = Queries.UsuarioExiste(usuario);

		
		//Si ha encontrado un usuario no se hace el insert y devuelve false 
		if (existe == true) {

			return false;

		} else {
			
			//Inserta el usuario dado el nombre, usuario, contraseña y la foto
			String query = "INSERT INTO USUARIO(NOMBRE, USUARIO, PASS, NOMBRE_FOTO) VALUES(?,?,?,?)";
			ps = con.prepareStatement(query);

			ps.setString(1, nombre);
			ps.setString(2, usuario);
			ps.setString(3, pass);
			ps.setString(4, "prueba");

			ps.executeUpdate();

		}

		con.close();
		ps.close();

		return true;

	}
	
	public static void insertarSimulacion(String usuario, double capital, int interes, int meses, int cuadroAmortizacion) throws SQLException {
		
		Connection poolcn = Connection.getInstance();

		con = poolcn.getConnection();
		
		//consigo la id del usuario a partir de el nombre
		int idUsuario = Queries.UsuarioID(usuario);
		
		String query = "INSERT INTO SIMULACION(CAPITAL, INTERES, MES, ID_USUARIO, CUADRO_AMORTIZACION) VALUES(?,?,?,?,?)";
		ps = con.prepareStatement(query);
		
		ps.setDouble(1, capital);
		ps.setInt(2, interes);
		ps.setInt(3, meses);
		ps.setInt(4, idUsuario);
		ps.setInt(5, cuadroAmortizacion);
		

		
		
		ps.executeUpdate();
		
		con.close();
		ps.close();
		
	}

}
