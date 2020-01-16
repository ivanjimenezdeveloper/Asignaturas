package model.ejb;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.servlet.http.Part;

import model.entidad.Usuario;
import model.entidad.dao.UsuarioDAO;

@Stateless
@LocalBean
/**
 * Logica que gestiona las operaciones con los ususarios
 * 
 * @author HIBAN
 *
 */
public class UsuarioEJB {

	/**
	 * Recupera todos los usuarios
	 * 
	 * @return Arraylist de usuarios
	 */
	public ArrayList<Usuario> getUsuarios() {

		UsuarioDAO userDAO = new UsuarioDAO();

		return userDAO.busquedaGeneral();
	}

	/**
	 * Comprueba si existe el usuario segun el nombre y la password
	 * 
	 * @param user Nick de usuario
	 * @param pass password de usuario
	 * @return Usuario con los datos
	 */
	public Usuario existeUsuario(String correo, String pass) {

		UsuarioDAO userDAO = new UsuarioDAO();

		return userDAO.existeUsuario(correo, pass);
	}

	/**
	 * Comprueba si existe un nick de usuario
	 * 
	 * @param user Nombre de usuario
	 * @return boolean de su existencia
	 */
	public boolean existeUsuario(String user) {

		UsuarioDAO userDAO = new UsuarioDAO();

		return userDAO.existeUsuario(user);
	}
	/**
	 * Registra al usuario
	 * @param user usuario a registrar
	 */
	public void registrarUsuario(Usuario user) {
	
		UsuarioDAO userDAO = new UsuarioDAO();

		 userDAO.registrarUsuario(user);
	
	}
	
	/**
	 * Guarda el nombre de archivo
	 * @param part
	 * @return nombre de archivo
	 */
	public String getFileName(Part part) {
		UsuarioDAO userDAO = new UsuarioDAO();

		return userDAO.getFileName(part);
	}
	
	/**
	 * Borra usuario
	 * @param user usuario a borrar
	 */
	public void borrarUsuario(Usuario user) {
		UsuarioDAO userDAO = new UsuarioDAO();
		userDAO.borrarUsuario(user);
	}
}
