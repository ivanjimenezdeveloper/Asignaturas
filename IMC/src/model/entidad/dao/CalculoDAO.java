package model.entidad.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.Conexion;
import model.entidad.Usuario;

public class CalculoDAO {

	private static Connection cn;
	private static PreparedStatement ps;
	private static Conexion pool;
	
	public void guardarCalculo(Double peso, Integer estatura, Usuario user) {
		
		pool = Conexion.getInstance();
		String date;
		
		String pattern = "YYYY-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		Date fecha = new Date();
		 date = simpleDateFormat.format(fecha);
		
		
		try {
			
			cn = pool.getConnection();
			
			String query = "INSERT INTO CALCULO_IMC(IDUSUARIO, PESO, ESTATURA, FECHA) \n" + 
					"VALUES(?, ?, ?, ?)";
			ps = cn.prepareStatement(query);
			
			ps.setInt(1, user.getKey().getKey());
			ps.setDouble(2, peso);
			ps.setInt(3, estatura);
			ps.setString(4, date);
			
			ps.executeUpdate();
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				cn.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
				// Logger
				}
		}
		
	}
}
