package model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import model.dao.MyBatisUtil;
import model.dao.mapper.JugadorMapper;
import model.entidad.Jugador;

public class JugadorDAO {
	public ArrayList<Jugador> getJugadores() {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			JugadorMapper jugadorMapper = sqlSession.getMapper(JugadorMapper.class);
			return jugadorMapper.getJugadores();
		} finally {
			sqlSession.close();
		}
	}
}
