package model.ejb;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import model.entidad.Usuario;
import model.entidad.dao.UsuarioDAO;

@Stateless
@LocalBean
public class UsuarioEJB {

	public ArrayList<Usuario> getUsuarios() {

		UsuarioDAO userDAO = new UsuarioDAO();

		return userDAO.busquedaGeneral();
	}

	public Usuario existeUsuario(String user, String pass) {

		UsuarioDAO userDAO = new UsuarioDAO();

		return userDAO.existeUsuario(user, pass);
	}

	public boolean existeUsuario(String user) {

		UsuarioDAO userDAO = new UsuarioDAO();

		return userDAO.existeUsuario(user);
	}

}
