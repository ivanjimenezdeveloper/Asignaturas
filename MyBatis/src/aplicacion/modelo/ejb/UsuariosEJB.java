package aplicacion.modelo.ejb;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import aplicacion.modelo.dao.UsuariosDAO;
import aplicacion.modelo.pojo.Usuario;

/**
 * Clase que permite trabajar con usuarios
 * @author daw
 *
 */
@Stateless
@LocalBean
public class UsuariosEJB {

    /**
     * Comprueba si existe un usuario
     * @param user El nombre de usuario a buscar
     * @param pass El password del usuario a buscar
     * @return Un usuario si existe el usuario o null en caso contrario
     */
	public Usuario existeUsuario(String user, String pass) {
    	UsuariosDAO usuariosDAO = new UsuariosDAO();

		return usuariosDAO.existeUsuario(user, pass);
	}
	
	/**
	 * Obtiene todos los usuarios que existen
	 * @return Una lista con todos los usuarios que existen
	 */
    public ArrayList<Usuario> getUsuarios() {
    	UsuariosDAO usuariosDAO = new UsuariosDAO();
    	
    	return usuariosDAO.getUsuarios();
    }

	/**
	 * Inserta un usuario en base de datos.
	 * @param usuario El usuario a insertar.
	 */
    public void insertUsuario(Usuario usuario)  {
    	UsuariosDAO usuariosDAO = new UsuariosDAO();

		usuariosDAO.insertUsuario(usuario);
	}
	
	/**
	 * Actualiza los datos de un usuario.
	 * @param usuario Los datos del ususario a actualizar.
	 */
    public void updateUsuario(Usuario usuario) {
    	UsuariosDAO usuariosDAO = new UsuariosDAO();

		usuariosDAO.updateUsuario(usuario);
	}
	
	/**
	 * Elimina un usuario en base de datos.
	 * @param id El identificador del usuario.
	 */
    public void deleteUsuario(Integer id) {
    	UsuariosDAO usuariosDAO = new UsuariosDAO();

		usuariosDAO.deleteUsuario(id);
	}

    /**
     * Obtiene un usuario a partir de un identificador
     * @param identificador
     * @return Un Usuario.
     */
	public Usuario getUsuario(Integer identificador) {
    	UsuariosDAO usuariosDAO = new UsuariosDAO();

		return usuariosDAO.getUsuario(identificador);
	}
}