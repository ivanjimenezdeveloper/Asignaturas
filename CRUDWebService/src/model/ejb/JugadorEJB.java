package model.ejb;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import model.entidad.Jugador;
import model.entidad.dao.JugadorDAO;

@Stateless
@LocalBean
public class JugadorEJB {
	public ArrayList<Jugador> busquedaGeneral() {
		JugadorDAO j = new JugadorDAO();
		
		return j.busquedaGeneral();
		
	}
	public Jugador buscarJugador(int id)  {
		JugadorDAO j = new JugadorDAO();
		
		return j.buscarJugador(id);
		
	}
	public void borrarJugador(int id)  {
		JugadorDAO j = new JugadorDAO();
		
		 j.borrarJugador(id);
		
	}
}
