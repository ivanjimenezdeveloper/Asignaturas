package aplicacion.modelo.dao.mappers;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import aplicacion.modelo.pojo.Usuario;

public interface UsuariosMapper {
 
	/**
	 * Obtiene un usuario existente o null en caso contrario.
	 * @param user Nombre de usuario a buscar.
	 * @param pass Password del usuario a buscar.
	 * @return Un usuario si existe en base de datos o null en caso contrario.
	 */
	public Usuario existeUsuario(@Param("user") String user, @Param("pass") String pass);
 
	/**
	 * Obtiene una lista de todos los usuarios.
	 * @return Una lista de usuarios existentes.
	 */
	public ArrayList<Usuario> getUsuarios();
	
	/**
	 * Inserta un usuario en base de datos.
	 * @param usuario El usuario a insertar.
	 */
	public void insertUsuario(Usuario usuario);
	
	/**
	 * Actualiza los datos de un usuario
	 * @param usuario Los datos del ususario a actualizar
	 */
	public void updateUsuario(Usuario usuario);
	
	/**
	 * Elimina un usuario en base de datos
	 * @param id El identificador del usuario
	 */
	public void deleteUsuario(@Param("id") Integer id);

	/**
	 * Obtiene un usuario de base de datos
	 * @param identificador El identificador del usuario
	 * @return El usuario
	 */
	public Usuario getUsuario(@Param("id") Integer id);
}