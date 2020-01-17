package model.entidad.dao;

import java.util.ArrayList;

import javax.servlet.http.Part;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
import model.MyBatisUtil;
import model.entidad.Usuario;
import model.entidad.dao.mapper.UsuarioMapper;

/**
 * Hace los las operaciones de la logica para interactuar con los usuarios
 * 
 * @author HIBAN
 *
 */
public class UsuarioDAO {

	private static final Logger logger = (Logger) LoggerFactory.getLogger(UsuarioDAO.class);

	/**
	 * Busca todos los usuarios
	 * 
	 * @return Arraylist de usuarios
	 */
	public ArrayList<Usuario> busquedaGeneral() {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			UsuarioMapper usuarioMapper = sqlSession.getMapper(UsuarioMapper.class);
			return usuarioMapper.busquedaGeneral();
		} catch (Exception e) {
			logger.error(e.getMessage());
			ArrayList<Usuario> uArr = new ArrayList<Usuario>();
			return uArr;
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * Comprueba la exitencia del usuario en combinacion con su password
	 * 
	 * @param user Correo a comprobar
	 * @param pass Password a comprobar
	 * @return Usuario completo encontrado
	 */
	public Usuario existeUsuario(String correo, String pass) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			UsuarioMapper usuarioMapper = sqlSession.getMapper(UsuarioMapper.class);
			return usuarioMapper.existeUsuario(correo, pass);
		} catch (Exception e) {
			logger.error(e.getMessage());
			Usuario u = new Usuario();
			return u;
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * Comprueba si existe el correo marcado en la base de datos
	 * 
	 * @param user Correo a comprobar
	 * @return boolean que determina la existencia del correo en la base de datos
	 */
	public boolean existeUsuario(String correo) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			UsuarioMapper usuarioMapper = sqlSession.getMapper(UsuarioMapper.class);
			return usuarioMapper.existeUsuario2(correo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return false;
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * Borra el usuario
	 * 
	 * @param user usuario a borrar
	 */
	public void borrarUsuario(Usuario user) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			UsuarioMapper usuarioMapper = sqlSession.getMapper(UsuarioMapper.class);
			usuarioMapper.borrarUsuario(user.getKey().getKey());

			sqlSession.commit();
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * Registra un usuario
	 * 
	 * @param user usuario a registrar
	 */
	public void registrarUsuario(Usuario user) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			UsuarioMapper usuarioMapper = sqlSession.getMapper(UsuarioMapper.class);
			usuarioMapper.registrarUsuario(user);

			sqlSession.commit();
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * Recoge el nombre del archivo
	 * 
	 * @param part
	 * @return devuelve el nombre
	 */
	public String getFileName(Part part) {
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename"))
				return content.substring(content.indexOf("=") + 2, content.length() - 1);
		}
		return "desconocido.png";
	}

}
