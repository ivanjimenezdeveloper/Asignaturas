package model.ejb;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import model.entidad.Accidente;
import model.entidad.Distritos;
import model.entidad.Estadisticas;
import model.entidad.Tipos;
import model.entidad.dao.AccidenteDAO;

@Stateless
@LocalBean
/**
 * EJB que lleva la logica de negocio sobre los accidentes
 * @author HIBAN
 *
 */
public class AccidenteEJB {

	/**
	 * Busqueda de todos los accidentes
	 * @return ArrayList con los accidentes
	 */
	public ArrayList<Accidente> busquedaGeneral() {
		AccidenteDAO a = new AccidenteDAO();

		return a.busquedaGeneral();

	}

	/**
	 * Busca los accidentes segun el tipo y fecha
	 * @param tipo tipo de accidente
	 * @param fecha fecha inicial
	 * @return ArrayList de accidentes
	 */
	public ArrayList<Accidente> busquedaAccidente(String tipo, String fecha) {
		AccidenteDAO a = new AccidenteDAO();

		return a.busquedaAccidente(tipo, fecha);

	}
	
	/**
	 * Busqueda de accidentes despues de la fecha dada
	 * @param tipo tipo de accidente
	 * @param fecha fecha inicial
	 * @return Arraylist de accidentes
	 */
	public ArrayList<Accidente> busquedaAccidenteDespues(String tipo, String fecha) {
		AccidenteDAO a = new AccidenteDAO();

		return a.busquedaAccidenteDespues(tipo, fecha);

	}

	/**
	 * Busqueda de tipo por id
	 * @param id id del tipo de accidente
	 * @return Objeto de tipos
	 */
	public Tipos TipoPorId(int id) {
		AccidenteDAO a = new AccidenteDAO();

		return a.TipoPorId(id);

	}

	/**
	 * Conseguir un accidente por id
	 * @param id id del accidente
	 * @return objeto accidente
	 */
	public Accidente getAccidente(int id) {
		AccidenteDAO a = new AccidenteDAO();

		return a.getAccidente(id);

	}

	/**
	 * Consigue un distrito por id
	 * @param id id del distrito
	 * @return objeto distrito
	 */
	public Distritos distritoPorId(int id) {
		AccidenteDAO a = new AccidenteDAO();

		return a.distritoPorId(id);

	}

	/**
	 * Devuelve todas las estadisticas
	 * @return Arraylist con todas las estadisticas
	 */
	public ArrayList<Estadisticas> getEstadisticas() {
		AccidenteDAO a = new AccidenteDAO();

		return a.getEstadisticas();

	}



	/**
	 * Devuelve todos los distritos
	 * @return ArrayList de Distritos
	 */
	public ArrayList<Distritos> busquedaGeneralDistritos() {
		AccidenteDAO a = new AccidenteDAO();

		return a.busquedaGeneralDistritos();
	}

	/**
	 * Devuelve todos los tipos de accidentes
	 * @return ArrayList de tipos de accidentes
	 */

	public ArrayList<Tipos> busquedaGeneralTipos() {
		AccidenteDAO a = new AccidenteDAO();

		return a.busquedaGeneralTipos();
	}
}
