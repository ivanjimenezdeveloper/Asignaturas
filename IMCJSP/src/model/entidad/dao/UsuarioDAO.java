package model.entidad.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.Part;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
import model.Conexion;
import model.MyBatisUtil;
import model.entidad.Usuario;
import model.entidad.UsuarioKey;
import model.entidad.dao.mapper.UsuarioMapper;

/**
 * Hace los las operaciones de la logica para interactuar con los usuarios
 * 
 * @author HIBAN
 *
 */
public class UsuarioDAO {

	private static Connection cn;
	private static PreparedStatement ps;
	private static ResultSet rs;
	private static Conexion pool;
	private static final Logger logger = (Logger) LoggerFactory.getLogger(UsuarioDAO.class);

	/**
	 * Busca todos los usuarios
	 * 
	 * @return Arraylist de usuarios
	 */
//	public ArrayList<Usuario> busquedaGeneral() {
//
//		/*
//		 * Arraylist que devuelve la arraylist de usuarios set
//		 */
//		ArrayList<Usuario> usArr = new ArrayList<Usuario>();
//		Usuario us = new Usuario();
//		UsuarioKey usKey = new UsuarioKey();
//
//		// Se crea la conexion con la base de datos
//
//		pool = Conexion.getInstance();
//
//		try {
//			cn = pool.getConnection();
//
////			  Query que busca a todos los usuarios
//
//			String query = "SELECT * FROM USUARIO";
//			ps = cn.prepareStatement(query);
//
//			rs = ps.executeQuery();
//
//			while (rs.next()) {
//
////				  Guarda los parametros 
//
//				usKey.setKey(rs.getInt("ID"));
//				us.setKey(usKey);
//				us.setNombre(rs.getString("NOMBRE"));
//				us.setCorreo(rs.getString("CORREO"));
//				us.setPass(rs.getString("PASS"));
//
//				// Guarda el objeto game en la array
//
//				usArr.add(us);
//
//				// Reinicia el objeto game
//
//				us = new model.entidad.Usuario();
//
//			}
//
//		} catch (SQLException e) {
//			logger.error(e.getMessage());
//
//		} finally {
//			try {
//				ps.close();
//				cn.close();
//				rs.close();
//			} catch (SQLException e) {
//				logger.error(e.getMessage());
//
//
//			}
//
//		}
//
//		return usArr;
//
//	}

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
	
	public boolean existeUsuario(String correo) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			UsuarioMapper usuarioMapper = sqlSession.getMapper(UsuarioMapper.class);
			return usuarioMapper.existeUsuario2(correo)  ;
		} catch (Exception e) {
			logger.error(e.getMessage());
			return false;
		} finally {
			sqlSession.close();
		}
	}
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
	 * Comprueba la exitencia del usuario en combinacion con su password
	 * 
	 * @param user Correo a comprobar
	 * @param pass Password a comprobar
	 * @return Usuario completo encontrado
	 */
//	public Usuario existeUsuario(String user, String pass) {
//
//		Usuario us = new Usuario();
//		UsuarioKey usKey = new UsuarioKey();
//
//		pool = Conexion.getInstance();
//
//		try {
//			cn = pool.getConnection();
//
////			  Query que busca al usuario con determinado correo y contraseña
//
//			String query = "SELECT * FROM USUARIO WHERE CORREO = ? AND PASS = ?";
//			ps = cn.prepareStatement(query);
//			ps.setString(1, user);
//			ps.setString(2, pass);
//			rs = ps.executeQuery();
//
//			while (rs.next()) {
//				usKey.setKey(rs.getInt("ID"));
//
//				us.setKey(usKey);
//				us.setCorreo(rs.getString("CORREO"));
//				us.setNombre(rs.getString("NOMBRE"));
//				us.setImagen(rs.getString("IMAGEN"));
//				us.setPass(rs.getString("PASS"));
//			}
//
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//
//		} finally {
//
//			try {
//				rs.close();
//				ps.close();
//				cn.close();
//			} catch (SQLException e) {
//				logger.error(e.getMessage());
//
//			}
//
//		}
//		return us;
//
//	}

	/**
	 * Comprueba si existe el correo marcado en la base de datos
	 * 
	 * @param user Correo a comprobar
	 * @return boolean que determina la existencia del correo en la base de datos
	 */
//	public boolean existeUsuario(String user) {
//
//		boolean existe = false;
//		pool = Conexion.getInstance();
//
//		try {
//			cn = pool.getConnection();
//
////			  Query que busca al usuario con determinado correo y contraseña
//
//			String query = "SELECT * FROM USUARIO WHERE CORREO = ? ";
//			ps = cn.prepareStatement(query);
//			ps.setString(1, user);
//			rs = ps.executeQuery();
//
//			while (rs.next()) {
//
//				existe = true;
//			}
//
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//
//		} finally {
//
//			try {
//				rs.close();
//				ps.close();
//				cn.close();
//			} catch (SQLException e) {
//				logger.error(e.getMessage());
//
//			}
//
//		}
//		return existe;
//
//	}

	/**
	 * Registra un usuario
	 * 
	 * @param user usuario a registrar
	 */
//	public void registrarUsuario(Usuario user) {
//		pool = Conexion.getInstance();
//
//		try {
//
//			cn = pool.getConnection();
//
//			String query = "INSERT INTO USUARIO(CORREO, NOMBRE, PASS,IMAGEN)" + "VALUES(?, ?, ?, ?)";
//			ps = cn.prepareStatement(query);
//
//			ps.setString(1, user.getCorreo());
//			ps.setString(2, user.getNombre());
//			ps.setString(3, user.getPass());
//			ps.setString(4, user.getImagen());
//
//			ps.executeUpdate();
//
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//
//		} finally {
//			try {
//				ps.close();
//				cn.close();
//			} catch (SQLException e) {
//				logger.error(e.getMessage());
//
//			}
//		}
//
//	}

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

	/**
	 * Borra el usuario
	 * 
	 * @param user usuario a borrar
	 */
//	public void borrarUsuario(Usuario user) {
//		pool = Conexion.getInstance();
//
//		try {
//			cn = pool.getConnection();
//
//			String query = "DELETE FROM USUARIO WHERE ID = ?";
//			ps = pool.getConnection().prepareStatement(query);
//			ps.setInt(1, user.getKey().getKey());
//			ps.executeUpdate();
//
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//
//		} finally {
//
//			try {
//				ps.close();
//				cn.close();
//			} catch (SQLException e) {
//				logger.error(e.getMessage());
//
//			}
//
//		}
//	}

}
