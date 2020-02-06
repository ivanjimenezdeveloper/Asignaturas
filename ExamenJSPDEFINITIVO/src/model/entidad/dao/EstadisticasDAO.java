package model.entidad.dao;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
import model.MyBatisUtil;
import model.entidad.Estadisticas;
import model.entidad.dao.mapper.EstadisticasMapper;

public class EstadisticasDAO implements EstadisticasMapper {
	private static final Logger logger = (Logger) LoggerFactory.getLogger(JugadorDAO.class);

	public Estadisticas estadisticasJugador( Integer id) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			EstadisticasMapper estadisticasMapper = sqlSession.getMapper(EstadisticasMapper.class);
			return estadisticasMapper.estadisticasJugador(id);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Estadisticas j = new Estadisticas();
			return j;
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public void cambiarEstadisticas(Integer puntos, Integer partidosJugados, Integer tirosCampo, Integer triples,
			Integer tirosLibres, Integer id) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			EstadisticasMapper estadisticasMapper = sqlSession.getMapper(EstadisticasMapper.class);
			estadisticasMapper.cambiarEstadisticas(puntos, partidosJugados, tirosCampo, triples, tirosLibres, id);
			sqlSession.commit();
		} catch (Exception e) {
			logger.error(e.getMessage());

		} finally {
			sqlSession.close();
		}		
	}

}
