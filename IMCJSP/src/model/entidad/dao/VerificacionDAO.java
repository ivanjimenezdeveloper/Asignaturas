package model.entidad.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
import model.Conexion;
import model.MyBatisUtil;
import model.entidad.Usuario;
import model.entidad.Verificacion;
import model.entidad.dao.mapper.VerificacionMapper;

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

		Integer codigo = (int) ((Math.random() * ((999999999 - 100) + 1)) + 100);

		// Si no existe el codigo lo devuelve, si existe lo vuelve a generar
		if (!existeCodigo(codigo)) {
			return codigo;
		} else {
			return generarCodigo();
		}

	}

	/**
	 * Crea la verificacion
	 * 
	 * @param user usuario al que crear la verificacion
	 * @return codigo de verificacion
	 */
	public Integer crearVerificacion(Usuario user) {

		Verificacion ver = new Verificacion();

		ver.setUsKey(user.getKey());
		ver.setCodigo(generarCodigo());
		ver.setVerificado(false);

		int verificadoBoolean = (ver.getVerificado() == true) ? 1 : 0;

		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			VerificacionMapper verificacionMapper = sqlSession.getMapper(VerificacionMapper.class);
			verificacionMapper.crearVerificacion(ver.getUsKey().getKey(), ver.getCodigo(), verificadoBoolean);
			;

			sqlSession.commit();
			return ver.getCodigo();

		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			sqlSession.close();
		}
		return ver.getCodigo();

	}

	/**
	 * Comprueba si ya existe ese codigo
	 * 
	 * @param codigo codigo a devolver
	 * @return boolean del exito
	 */
	private static boolean existeCodigo(Integer codigo) {
		boolean existe = false;

		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			VerificacionMapper verificacionMapper = sqlSession.getMapper(VerificacionMapper.class);
			return verificacionMapper.existeCodigo(codigo);

		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			sqlSession.close();
		}
		return existe;

	}

	/**
	 * borra las verificaciones
	 * 
	 * @param user usuario al que borrar las verificaciones
	 */
	public void borrarVerificacionesExistentes(Usuario user) {

		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			VerificacionMapper verificacionMapper = sqlSession.getMapper(VerificacionMapper.class);
			verificacionMapper.borrarVerificacionesExistentes(user.getKey().getKey());
			;

			sqlSession.commit();

		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			sqlSession.close();
		}

	}

	

	/**
	 * Comprueba si esta verificado
	 * 
	 * @param user usuario que comprobar
	 * @return boolean del exito
	 */
	public boolean usuarioVerificado(Usuario user) {

		boolean verificado = false;
		int ver;

		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			VerificacionMapper verificacionMapper = sqlSession.getMapper(VerificacionMapper.class);
			ver = verificacionMapper.usuarioVerificado(user.getKey().getKey());
			
			if(ver == 1) {
				verificado = true;
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			sqlSession.close();
		}
		
		return verificado;
	}

	/**
	 * Cambia una verificacion a verificado
	 * 
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

			// si devuelve algo mayor a 0 es que ha hecho el update
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
