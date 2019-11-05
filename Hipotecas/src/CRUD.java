import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class CRUD {
	private static Statement stm;
	private static java.sql.Connection con;
	
	//prueba SELECT
	public static ArrayList<String> SelectAll() throws SQLException {
		Connection poolConn = Connection.getInstance();
		con = poolConn.getConnection();
		stm = con.createStatement();
		ResultSet rs = stm.executeQuery("SELECT * FROM USUARIO");
		
		ArrayList<String> toReturn = new ArrayList<String>();
		
		while(rs.next()) {
			Integer id = rs.getInt("ID");
			String nombre = rs.getString("NOMBRE");
			String usuario = rs.getString("USUARIO");
			
			toReturn.add("ID " + id +"\nNOMBRE: " + nombre + "\nUSUARIO: " + usuario);
		}
		
		
		
		return toReturn;
		
	}
	
	
}
