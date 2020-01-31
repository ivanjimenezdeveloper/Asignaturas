package controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/aplicacion")
public class Main {

	@GET
	@Path("/saludar/{nombre}")
	@Produces(MediaType.TEXT_PLAIN)
	public String hola(@PathParam("nombre") String nombre) {
		return "hola" + nombre;
	}
}
