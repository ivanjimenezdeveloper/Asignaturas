package model.entidad.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
import model.Conexion;
import model.entidad.Calculo_Imc;
import model.entidad.Calculo_ImcKey;
import model.entidad.Usuario;
import model.entidad.UsuarioKey;
/**
 * Clase que ejecuta los calculos de la logica
 * @author HIBAN
 *
 */
public class CalculoDAO {

	private static Connection cn;
	private static PreparedStatement ps;
	private static ResultSet rs;
	private static Conexion pool;
	private static final Logger logger = (Logger) LoggerFactory.getLogger(CalculoDAO.class);

	/**
	 * Guarda el calculo en la base de datos
	 * @param peso peso a guardar
	 * @param estatura estatura a guardar
	 * @param user Usuario que ha hecho el calculo
	 */
	public void guardarCalculo(Double peso, Integer estatura, Usuario user) {
		pool = Conexion.getInstance();
		String date;

		String pattern = "YYYY-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		Date fecha = new Date();
		date = simpleDateFormat.format(fecha);

		try {

			cn = pool.getConnection();

			String query = "INSERT INTO CALCULO_IMC(IDUSUARIO, PESO, ESTATURA, FECHA) \n" + "VALUES(?, ?, ?, ?)";
			ps = cn.prepareStatement(query);

			ps.setInt(1, user.getKey().getKey());
			ps.setDouble(2, peso);
			ps.setInt(3, estatura);
			ps.setString(4, date);

			ps.executeUpdate();

		} catch (Exception e) {
			logger.error(e.getMessage());

		} finally {
			try {
				cn.close();
				ps.close();
			} catch (SQLException e) {
				logger.error(e.getMessage());

			}
		}

	}

	/**
	 * Devuelve una array de calculos segun el usuario
	 * @param user Usuario por el que filtrar los calculos
	 * @return Arraylist de calculos
	 */
	public ArrayList<Calculo_Imc> getCalculosUsuario(Usuario user) {
		pool = Conexion.getInstance();
		ArrayList<Calculo_Imc> arrCalc = new ArrayList<Calculo_Imc>();
		Calculo_Imc calculo = new Calculo_Imc();

		try {
			cn = pool.getConnection();

			//	Query que busca a todos los Calculos

			String query = "SELECT * FROM CALCULO_IMC WHERE IDUSUARIO = ?";
			ps = cn.prepareStatement(query);

			ps.setInt(1, user.getKey().getKey());

			rs = ps.executeQuery();

			while (rs.next()) {

				// Guarda los parametros

				calculo.setId(new Calculo_ImcKey(rs.getInt("ID")));
				calculo.setIdUsuario(new UsuarioKey(rs.getInt("IDUSUARIO")));
				calculo.setPeso(rs.getDouble("PESO"));
				calculo.setEstatura(rs.getInt("ESTATURA"));
				calculo.setFecha(rs.getDate("FECHA"));

				// Guarda el objeto calculo en la array

				arrCalc.add(calculo);

				// Reinicia el objeto calculo

				calculo = new Calculo_Imc();

			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			try {
				ps.close();
				cn.close();
				rs.close();
			} catch (SQLException e) {
				logger.error(e.getMessage());


			}
		}
		return arrCalc;

	}
}
