package model.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import model.entidad.Estadisticas;
import model.entidad.dao.EstadisticasDAO;

@Stateless
@LocalBean
public class EstadisticasEJB {
	
	public Estadisticas estadisticasJugador(Integer id) {
		EstadisticasDAO e = new EstadisticasDAO();
		
		return e.estadisticasJugador(id);
	}
	
	public void cambiarEstadisticas(Integer puntos, Integer partidosJugados, Integer tirosCampo, Integer triples,Integer tirosLibres, Integer id) {
		EstadisticasDAO e = new EstadisticasDAO();
		
		 e.cambiarEstadisticas(puntos, partidosJugados, tirosCampo, triples, tirosLibres, id);
	}

}
