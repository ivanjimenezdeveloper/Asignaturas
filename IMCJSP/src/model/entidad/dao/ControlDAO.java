package model.entidad.dao;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
import model.MyBatisUtil;
import model.entidad.dao.mapper.ControlMapper;
/**
 * DAO del control
 * @author HIBAN
 *
 */
public class ControlDAO {

	private static final Logger logger = (Logger) LoggerFactory.getLogger(ControlDAO.class);

	
	/**
	 * Inserta registros
	 */
	public void insertarRegistro() {

		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			ControlMapper controlMapper = sqlSession.getMapper(ControlMapper.class);
			controlMapper.insertarRegistro();

			sqlSession.commit();
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			sqlSession.close();
		}
	}

	
	/**
	 * Inserta bajas
	 */
	public void insertarBaja() {

		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			ControlMapper controlMapper = sqlSession.getMapper(ControlMapper.class);
			controlMapper.insertarBaja();

			sqlSession.commit();
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			sqlSession.close();
		}

	}

/**
 * Busca los registros
 * @return cantidad de registros
 */
	public int recibirRegistros() {

		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			ControlMapper controlMapper = sqlSession.getMapper(ControlMapper.class);
			return controlMapper.recibirRegistros();

		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			sqlSession.close();
		}
		return -1;
	}
	
	/**
	 * Busca las bajas
	 * @return cantidad de bajas
	 */
	public int recibirBajas() {

		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			ControlMapper controlMapper = sqlSession.getMapper(ControlMapper.class);
			return controlMapper.recibirBajas();

		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			sqlSession.close();
		}
		return -1;
	}
	
	/**
	 * Borra los registros existentes
	 */
	public void borrarRegistros() {
		
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			ControlMapper controlMapper = sqlSession.getMapper(ControlMapper.class);
			controlMapper.borrarRegistros();

			sqlSession.commit();
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			sqlSession.close();
		}
		
	}
	
	/**
	 * Borra las bajas existentes
	 */
	public void borrarBajas() {
		
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			ControlMapper controlMapper = sqlSession.getMapper(ControlMapper.class);
			controlMapper.borrarBajas();

			sqlSession.commit();
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			sqlSession.close();
		}
		
	}
}
