package model.entidad.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
import model.MyBatisUtil;
import model.entidad.Equipo;
import model.entidad.dao.mapper.EquipoMapper;

public class EquipoDAO {
	private static final Logger logger = (Logger) LoggerFactory.getLogger(EquipoDAO.class);

	public ArrayList<Equipo> buscarJugador(int id) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			EquipoMapper eMapper = sqlSession.getMapper(EquipoMapper.class);
			return eMapper.busquedaPorJugador(id);
		} catch (Exception e) {
			logger.error(e.getMessage());
			ArrayList<Equipo> eq = new ArrayList<Equipo>();
			return eq;
		} finally {
			sqlSession.close();
		}
	}
}
