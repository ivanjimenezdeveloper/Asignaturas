package model.entidad.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
import model.Conexion;
import model.entidad.Usuario;
import model.entidad.Verificacion;

public class VerificacionDAO {

	private static Connection cn;
	private static PreparedStatement ps;
	private static ResultSet rs;
	private static Conexion pool;
	private static final Logger logger = (Logger) LoggerFactory.getLogger(VerificacionDAO.class);

	private static Integer generarCodigo() {
		
		Integer codigo = (int) ((Math.random() * ((999999999 - 1) + 1)) + 1);
		
	if(!existeCodigo(codigo)) {
		return codigo;
	}else {
		return generarCodigo();
	}
		
	}

	public Integer crearVerificacion(Usuario user) {

		Verificacion ver = new Verificacion();

		ver.setUsKey(user.getKey());
		ver.setCodigo(generarCodigo());
		ver.setVerificado(false);
		
		int verificadoBoolean =  (ver.getVerificado()==true)? 1:0;
		
		pool = Conexion.getInstance();

		try {

			cn = pool.getConnection();

			String query = "INSERT INTO VERIFICACION(IDUSUARIO, CODIGO, VERIFICADO) VALUES(?, ?, ?)";
			ps = pool.getConnection().prepareStatement(query);

			ps.setInt(1, ver.getUsKey().getKey());
			ps.setInt(2, ver.getCodigo());
			ps.setInt(3, verificadoBoolean);


			ps.executeUpdate();
			
			return ver.getCodigo();

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
		
		return ver.getCodigo();

	}

	private static boolean existeCodigo(Integer codigo) {
		boolean existe = false;

		pool = Conexion.getInstance();

		try {
			cn = pool.getConnection();

			
			String query = "SELECT * FROM VERIFICACION WHERE CODIGO = ?";
			ps = pool.getConnection().prepareStatement(query);
			ps.setInt(1, codigo);
			rs = ps.executeQuery();

			while (rs.next()) {
				existe = true;
			}

		} catch (Exception e) {
			logger.error(e.getMessage());

		} finally {

			try {
				rs.close();
				ps.close();
				cn.close();
			} catch (SQLException e) {
				logger.error(e.getMessage());

			}

		}

		return existe;

	}
}
