package model.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import model.entidad.Usuario;
import model.entidad.dao.VerificacionDAO;

/**
 * Logica de las verificaciones
 * @author HIBAN
 *
 */
@Stateless
@LocalBean
public class VerificacionEJB {

	/**
	 * Crea una verificacion
	 * @param user usuario al que le crea la verificacion
	 * @return codigo de verificacion
	 */
	public Integer crearVerificacion(Usuario user) {
		VerificacionDAO v = new VerificacionDAO();

		return v.crearVerificacion(user);

	}

	/**
	 * Borra las verificaciones de un usuario
	 * @param user usuario al que borrar las verificaciones
	 */
	public void borrarVerificacionesExistentes(Usuario user) {

		VerificacionDAO v = new VerificacionDAO();

		v.borrarVerificacionesExistentes(user);

	}

	/**
	 * verifica que el usaurio este verificado
	 * @param user usuario a comprobar
	 * @return boolean del exito
	 */
	public boolean usuarioVerificado(Usuario user) {

		VerificacionDAO v = new VerificacionDAO();
		return v.usuarioVerificado(user);
	}
	
	/**
	 * Pasa a verificar a un usuario
	 * @param codigo que verificar
	 * @return boolean del exito
	 */
	public boolean verificar(int codigo) {
		VerificacionDAO v = new VerificacionDAO();

		return v.verificar(codigo);
		
	}
	
	
	
}
