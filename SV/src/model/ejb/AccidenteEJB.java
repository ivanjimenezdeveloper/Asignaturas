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
public class AccidenteEJB {

	public ArrayList<Accidente> busquedaGeneral() {
		AccidenteDAO a = new AccidenteDAO();

		return a.busquedaGeneral();

	}

	public ArrayList<Accidente> busquedaAccidente(String tipo, String fecha) {
		AccidenteDAO a = new AccidenteDAO();

		return a.busquedaAccidente(tipo, fecha);

	}

	public ArrayList<Accidente> busquedaAccidenteDespues(String tipo, String fecha) {
		AccidenteDAO a = new AccidenteDAO();

		return a.busquedaAccidenteDespues(tipo, fecha);

	}

	public Tipos TipoPorId(int id) {
		AccidenteDAO a = new AccidenteDAO();

		return a.TipoPorId(id);

	}

	public Accidente getAccidente(int id) {
		AccidenteDAO a = new AccidenteDAO();

		return a.getAccidente(id);

	}

	public Distritos distritoPorId(int id) {
		AccidenteDAO a = new AccidenteDAO();

		return a.distritoPorId(id);

	}

	public ArrayList<Estadisticas> getEstadisticas() {
		AccidenteDAO a = new AccidenteDAO();

		return a.getEstadisticas();

	}

	public ArrayList<Tipos> getTipos() {
		AccidenteDAO a = new AccidenteDAO();

		return a.getTipos();

	}

	public ArrayList<Distritos> busquedaGeneralDistritos() {
		AccidenteDAO a = new AccidenteDAO();

		return a.busquedaGeneralDistritos();
	}

	public ArrayList<Tipos> busquedaGeneralTipos() {
		AccidenteDAO a = new AccidenteDAO();

		return a.busquedaGeneralTipos();
	}
}
