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

import model.ejb.AccidenteEJB;
import model.entidad.Accidente;
import model.entidad.Distritos;
import model.entidad.Tipos;

@Path("Accidente")
public class Rest {

	@Context
	HttpServletRequest request;
	@EJB
	AccidenteEJB accidenteEJB;
	
	
	@GET
	@Path("/getAccidente/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Accidente getJugador(@PathParam("id") int id) {
		Accidente a = new Accidente();

		a = accidenteEJB.getAccidente(id);

		return a;

	}
	
	@GET
	@Path("/getAccidentes/")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Accidente> busquedaGeneralAccidentes() {
		ArrayList<Accidente> a = new ArrayList<Accidente>();

		a = accidenteEJB.busquedaGeneral();

		return a;

	}
	
	@GET
	@Path("/getDistritos/")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Distritos> busquedaGeneralDistritos() {
		ArrayList<Distritos> a = new ArrayList<Distritos>();

		a = accidenteEJB.busquedaGeneralDistritos();

		return a;

	}
	
	@GET
	@Path("/getTipos/")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Tipos> busquedaGeneralTipos() {
		ArrayList<Tipos> a = new ArrayList<Tipos>();

		a = accidenteEJB.busquedaGeneralTipos();

		return a;

	}
	
}
