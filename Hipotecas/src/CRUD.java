import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class CRUD {
	private static Statement stm;
	private static java.sql.Connection con;
	
	//CREAR UN SELECT SEGUN CONTRASEÑA Y USUARIO
	public static ArrayList<Usuario> SelectAll() throws SQLException {
		Connection poolConn = Connection.getInstance();
		con = poolConn.getConnection();
		stm = con.createStatement();
		ResultSet rs = stm.executeQuery("SELECT * FROM USUARIO");
		
		ArrayList<Usuario> toReturn = new ArrayList<Usuario>();
		
		while(rs.next()) {
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
		
		
		
		return toReturn;
		
	}
	
	
	
}
