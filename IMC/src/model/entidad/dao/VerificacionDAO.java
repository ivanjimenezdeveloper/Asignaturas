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

/**
 * DAO de verificacion
 * 
 * @author HIBAN
 *
 */
public class VerificacionDAO {

	private static Connection cn;
	private static PreparedStatement ps;
	private static ResultSet rs;
	private static Conexion pool;
	private static final Logger logger = (Logger) LoggerFactory.getLogger(VerificacionDAO.class);

	/**
	 * Genera el codigo
	 * 
	 * @return codigo generado
	 */
	private static Integer generarCodigo() {

		Integer codigo = (int) ((Math.random() * ((999999999 - 1) + 1)) + 1);

		// Si no existe el codigo lo devuelve, si existe lo vuelve a generar
		if (!existeCodigo(codigo)) {
			return codigo;
		} else {
			return generarCodigo();
		}

	}

	/**
	 * Crea la verificacion
	 * @param user usuario al que crear la verificacion
	 * @return codigo de verificacion
	 */
	public Integer crearVerificacion(Usuario user) {

		Verificacion ver = new Verificacion();

		ver.setUsKey(user.getKey());
		ver.setCodigo(generarCodigo());
		ver.setVerificado(false);

		int verificadoBoolean = (ver.getVerificado() == true) ? 1 : 0;

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
				ps.close();

				cn.close();
			} catch (SQLException e) {
				logger.error(e.getMessage());

			}
		}

		return ver.getCodigo();

	}
/**
 * Comprueba si ya existe ese codigo
 * @param codigo codigo a devolver
 * @return boolean del exito
 */
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

	/**
	 * borra las verificaciones
	 * @param user usuario al que borrar las verificaciones
	 */
	public void borrarVerificacionesExistentes(Usuario user) {

		pool = Conexion.getInstance();

		try {
			cn = pool.getConnection();

			String query = "DELETE FROM VERIFICACION WHERE IDUSUARIO = ?";
			ps = pool.getConnection().prepareStatement(query);
			ps.setInt(1, user.getKey().getKey());
			ps.executeUpdate();

		} catch (Exception e) {
			logger.error(e.getMessage());

		} finally {

			try {
				ps.close();
				cn.close();
			} catch (SQLException e) {
				logger.error(e.getMessage());

			}

		}

	}

	/**
	 * Comprueba si esta verificado
	 * @param user usuario que comprobar
	 * @return boolean del exito
	 */
	public boolean usuarioVerificado(Usuario user) {

		boolean verificado = false;
		int ver;

		pool = Conexion.getInstance();

		try {
			cn = pool.getConnection();

			String query = "SELECT * FROM VERIFICACION WHERE IDUSUARIO = ?";
			ps = pool.getConnection().prepareStatement(query);
			ps.setInt(1, user.getKey().getKey());
			rs = ps.executeQuery();

			while (rs.next()) {

				ver = rs.getInt("VERIFICADO");

				if (ver == 1) {
					verificado = true;
				}
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

		return verificado;
	}

	/**
	 * Cambia una verificacion a verificado
	 * @param codigo codigo a verificar
	 * @return boolean del exito
	 */
	public boolean verificar(int codigo) {
		boolean verificado = false;

		pool = Conexion.getInstance();

		try {
			cn = pool.getConnection();

			String query = "UPDATE VERIFICACION SET VERIFICADO = 1 WHERE CODIGO = ?";
			ps = cn.prepareStatement(query);
			ps.setInt(1, codigo);
			int resultado = ps.executeUpdate();

			//si devuelve algo mayor a 0 es que ha hecho el update
			if (resultado > 0) {

				verificado = true;
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

		return verificado;

	}
}
