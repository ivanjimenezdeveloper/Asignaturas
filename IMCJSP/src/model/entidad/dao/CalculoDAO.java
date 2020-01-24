package model.entidad.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
import model.MyBatisUtil;
import model.entidad.Calculo_Imc;
import model.entidad.Usuario;
import model.entidad.dao.mapper.CalculoMapper;
/**
 * Clase que ejecuta los calculos de la logica
 * @author HIBAN
 *
 */
public class CalculoDAO {

	private static final Logger logger = (Logger) LoggerFactory.getLogger(CalculoDAO.class);

	/**
	 * Guarda el calculo en la base de datos
	 * @param peso peso a guardar
	 * @param estatura estatura a guardar
	 * @param user Usuario que ha hecho el calculo
	 */
	public void guardarCalculo(Double peso, Integer estatura, Usuario user) {
		String date;

		String pattern = "YYYY-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		Date fecha = new Date();
		date = simpleDateFormat.format(fecha);
		
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			CalculoMapper calculoMapper = sqlSession.getMapper(CalculoMapper.class);
			calculoMapper.guardarCalculo(user.getKey(), peso, estatura, date);

			sqlSession.commit();
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			sqlSession.close();
		}
		
	}
	
	

	/**
	 * Devuelve una array de calculos segun el usuario
	 * @param user Usuario por el que filtrar los calculos
	 * @return Arraylist de calculos
	 */
	public ArrayList<Calculo_Imc> getCalculosUsuario(Usuario user) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			CalculoMapper calculoMapper = sqlSession.getMapper(CalculoMapper.class);
			return calculoMapper.getCalculosUsuario(user.getKey());

		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			sqlSession.close();
		}
		ArrayList<Calculo_Imc> arrCalc = new ArrayList<>();
		
		return arrCalc;

	}
}
