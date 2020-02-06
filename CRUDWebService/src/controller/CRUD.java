package controller;

import java.util.ArrayList;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import model.ejb.JugadorEJB;
import model.entidad.Jugador;

@Path("Jugador")
public class CRUD {
	@Context HttpServletRequest request;
	@EJB
	JugadorEJB jugadorEJB;
	@GET
	@Path("/getJugador/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Jugador getJugador(@PathParam("id") int id) {
		Jugador j = new Jugador();
		
		j = jugadorEJB.buscarJugador(id);
		
		return j;
		
	}
	
	@GET
	@Path("/getJugadores")
	@Produces(MediaType.APPLICATION_XML)
	public ArrayList<Jugador> getJugador() {
		ArrayList<Jugador> j = new ArrayList<Jugador>();
		
		j = jugadorEJB.busquedaGeneral();
		
		return j;
		
	}
}
