package query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexion.ConnectionPool;

public class Nombre {
	private static Connection cn;
	private static PreparedStatement ps;
	private static ResultSet rs;
	private static ConnectionPool pool;
	
	/**
	 * Segun la id devuelve el nombre del genero
	 * @param id del genero
	 * @return Nombre del genero
	 */
	public static String nombreGenero(int id) {
		/**
		 * Crea la conexion
		 */
		pool = ConnectionPool.getInstance();
		String nombre="No encontrado";
		
		try {
			cn = pool.getConnection();
			
			/**
			 * Busca el nombre del genero segun la id
			 */
			String query = "SELECT * FROM GENERO WHERE ID = ?";
			ps = cn.prepareStatement(query);
			ps.setInt(1, id);

			rs = ps.executeQuery();
			
			while(rs.next()) {
				 nombre = rs.getString("NOMBRE");
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				cn.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		
		
		return nombre;
		
	}
	/**
	 * Segun la id devuelve el nombre del plataforma
	 * @param id del plataforma
	 * @return Nombre del plataforma
	 */
	public static String nombrePlataforma(int id) {
		/**
		 * Crea la conexion
		 */
		pool = ConnectionPool.getInstance();
		String nombre="No encontrado";
		
		try {
			cn = pool.getConnection();
			
			/**
			 * Busca el nombre de la plataforma segun la id
			 */
			String query = "SELECT * FROM PLATAFORMA WHERE ID = ?";
			ps = cn.prepareStatement(query);
			ps.setInt(1, id);

			rs = ps.executeQuery();
			
			while(rs.next()) {
				 nombre = rs.getString("NOMBRE");
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				cn.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		
		
		return nombre;
		
	}
}
