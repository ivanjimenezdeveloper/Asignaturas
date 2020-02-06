package model.entidad.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
import model.MyBatisUtil;
import model.entidad.Jugador;
import model.entidad.dao.mapper.JugadorMapper;

public class JugadorDAO {
	
	private static final Logger logger = (Logger) LoggerFactory.getLogger(JugadorDAO.class);

	public ArrayList<Jugador> busquedaGeneral() {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			JugadorMapper jugadorMapper = sqlSession.getMapper(JugadorMapper.class);
			return jugadorMapper.busquedaGeneral();
		} catch (Exception e) {
			logger.error(e.getMessage());
			ArrayList<Jugador> uArr = new ArrayList<Jugador>();
			return uArr;
		} finally {
			sqlSession.close();
		}
	}
	
	public Jugador buscarJugador(int id) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			JugadorMapper jugadorMapper = sqlSession.getMapper(JugadorMapper.class);
			return jugadorMapper.buscarJugador(id);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Jugador j = new Jugador();
			return j;
		} finally {
			sqlSession.close();
		}
	}
	
	public void borrarJugador(@Param("id") int id) {
		
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			JugadorMapper usuarioMapper = sqlSession.getMapper(JugadorMapper.class);
			usuarioMapper.borrarJugador(id);

			sqlSession.commit();
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			sqlSession.close();
		}
		
	}

}
