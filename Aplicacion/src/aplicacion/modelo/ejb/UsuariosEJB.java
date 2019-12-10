package aplicacion.modelo.ejb;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import aplicacion.modelo.dao.UsuariosDAO;
import aplicacion.modelo.pojo.Usuario;;

/**
 * Clase que permite trabajar con usuarios
 * @author daw
 *
 */
@Stateless
@LocalBean
public class UsuariosEJB {

	/**
	 * Obtiene todos los usuarios que existen
	 * @return Una lista con todos los usuarios que existen
	 */
    public ArrayList<Usuario> getUsuarios() {
    	UsuariosDAO usuariosDAO = new UsuariosDAO();
    	
    	return usuariosDAO.getUsuarios();
    }

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
}