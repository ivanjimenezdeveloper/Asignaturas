package model.ejb;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import model.entidad.Equipo;
import model.entidad.dao.EquipoDAO;

@Stateless
@LocalBean
public class EquipoEJB {

	public ArrayList<Equipo> buscarJugador(int id)  {
		EquipoDAO j = new EquipoDAO();
		
		return j.buscarJugador(id);
		
	}
}
