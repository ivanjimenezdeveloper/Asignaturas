package aplicacion.modelo.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import aplicacion.modelo.dao.mappers.UsuariosMapper;
import aplicacion.modelo.pojo.Usuario;

public class UsuariosDAO {

	/**
	 * Obtiene un usuario existente o null en caso contrario.
	 * @param user Nombre de usuario a buscar.
	 * @param pass Password del usuario a buscar.
	 * @return Un usuario si existe en base de datos o null en caso contrario.
	 */
	public Usuario existeUsuario(String user, String pass) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			UsuariosMapper usuariosMapper = sqlSession.getMapper(UsuariosMapper.class);
			return usuariosMapper.existeUsuario(user, pass);
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * Obtiene una lista de todos los usuarios.
	 * @return Una lista de usuarios existentes.
	 */
	public ArrayList<Usuario> getUsuarios() {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			UsuariosMapper usuariosMapper = sqlSession.getMapper(UsuariosMapper.class);
			return usuariosMapper.getUsuarios();
		} finally {
			sqlSession.close();
		}
	}
	
	/**
	 * Inserta un usuario en base de datos.
	 * @param usuario El usuario a insertar.
	 */
	public void insertUsuario(Usuario usuario) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			UsuariosMapper usuariosMapper = sqlSession.getMapper(UsuariosMapper.class);
			usuariosMapper.insertUsuario(usuario);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}	
	
	/**
	 * Actualiza los datos de un usuario.
	 * @param usuario Los datos del ususario a actualizar.
	 */
	public void updateUsuario(Usuario usuario) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			UsuariosMapper usuariosMapper = sqlSession.getMapper(UsuariosMapper.class);
			usuariosMapper.updateUsuario(usuario);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}	
	
	/**
	 * Elimina un usuario en base de datos.
	 * @param id El identificador del usuario.
	 */
	public void deleteUsuario(Integer id) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
		try {
			UsuariosMapper usuariosMapper = sqlSession.getMapper(UsuariosMapper.class);
			usuariosMapper.deleteUsuario(id);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * Obtiene un usuario de bade de datos
	 * @param identificador El identificador del usuario a obtener
	 * @return El usuario.
	 */
	public Usuario getUsuario(Integer identificador) {
			SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession();
			try {
				UsuariosMapper usuariosMapper = sqlSession.getMapper(UsuariosMapper.class);
				return usuariosMapper.getUsuario(identificador);
			} finally {
				sqlSession.close();
			}	
	}
}