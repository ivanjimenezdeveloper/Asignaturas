package model.entidad.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
import model.Conexion;
/**
 * DAO del control
 * @author HIBAN
 *
 */
public class ControlDAO {
	private static Connection cn;
	private static PreparedStatement ps;
	private static ResultSet rs;
	private static Conexion pool;
	private static final Logger logger = (Logger) LoggerFactory.getLogger(ControlDAO.class);

	
	/**
	 * Inserta registros
	 */
	public void insertarRegistro() {

		pool = Conexion.getInstance();

		try {

			cn = pool.getConnection();

			String query = "INSERT INTO CONTROL(CODIGO) VALUES(?)";
			ps = cn.prepareStatement(query);

			ps.setInt(1, 0);

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
	 * Inserta bajas
	 */
	public void insertarBaja() {

		pool = Conexion.getInstance();

		try {

			cn = pool.getConnection();

			String query = "INSERT INTO CONTROL(CODIGO) VALUES(?)";
			ps = pool.getConnection().prepareStatement(query);

			ps.setInt(1, 1);

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
 * Busca los registros
 * @return cantidad de registros
 */
	public int recibirRegistros() {

		int registros = 0;


		pool = Conexion.getInstance();

		try {
			cn = pool.getConnection();


			String query = "SELECT * FROM CONTROL WHERE CODIGO = 0";
			ps = cn.prepareStatement(query);

			rs = ps.executeQuery();

			while (rs.next()) {

				registros++;

			}

		} catch (SQLException e) {
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
		return registros;
	}
	
	/**
	 * Busca las bajas
	 * @return cantidad de bajas
	 */
	public int recibirBajas() {

		int bajas = 0;


		pool = Conexion.getInstance();

		try {
			cn = pool.getConnection();


			String query = "SELECT * FROM CONTROL WHERE CODIGO = 1";
			ps = cn.prepareStatement(query);

			rs = ps.executeQuery();

			while (rs.next()) {

				bajas++;

			}

		} catch (SQLException e) {
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
		return bajas;
	}
	
	/**
	 * Borra los registros existentes
	 */
	public void borrarRegistros() {
		
		pool = Conexion.getInstance();

		try {
			cn = pool.getConnection();

			String query = "DELETE FROM CONTROL WHERE CODIGO = ?";
			ps = pool.getConnection().prepareStatement(query);
			ps.setInt(1, 0);
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
	 * Borra las bajas existentes
	 */
	public void borrarBajas() {
		
		pool = Conexion.getInstance();

		try {
			cn = pool.getConnection();

			String query = "DELETE FROM CONTROL WHERE CODIGO = ?";
			ps = pool.getConnection().prepareStatement(query);
			ps.setInt(1, 1);
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
}
