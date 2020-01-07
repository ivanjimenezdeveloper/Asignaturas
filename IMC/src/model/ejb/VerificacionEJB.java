package model.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import model.entidad.Usuario;
import model.entidad.dao.VerificacionDAO;

@Stateless
@LocalBean
public class VerificacionEJB {

	public Integer crearVerificacion(Usuario user) {
		VerificacionDAO v = new VerificacionDAO();

		return v.crearVerificacion(user);

	}

	public void borrarVerificacionesExistentes(Usuario user) {

		VerificacionDAO v = new VerificacionDAO();

		v.borrarVerificacionesExistentes(user);

	}

	public boolean usuarioVerificado(Usuario user) {

		VerificacionDAO v = new VerificacionDAO();
		return v.usuarioVerificado(user);
	}
	
	public boolean verificar(int codigo) {
		VerificacionDAO v = new VerificacionDAO();

		return v.verificar(codigo);
		
	}
	
	
}
