package aplicacion.rest;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import aplicacion.modelo.pojo.Trabajador;

@Path("/aplicacion")
public class ServicioRest {

	@Context HttpServletRequest request;
	
	@GET
	@Path("/verAlumno")
	@Produces("text/html")
	public String verAlumno(@QueryParam("alu") String alumno) {
		return "alumno: " + alumno;
	}

	@GET
	@Path("/verProfesor/{profe}")
	@Produces("text/html")
	public String verProfe(@PathParam("profe") String profe) {
		return "profe: " + profe;
	}
	
	@GET
	@Path("/verTrabajadorXML")
	@Produces("application/xml")
	public Trabajador verTrabajadorXML() {
		Trabajador t = new Trabajador();
		
		t.setNombre("Pep");
		t.setApellidos("Smith Smith");
		t.addHabilidad("Java");
		t.addHabilidad("SQL");
		t.addHabilidad("Javascript");
		
		return t;
	}
	
	@GET
	@Path("/verTrabajadorJSON")
	@Produces("application/json")
	public Trabajador verTrabajadorJSON() {
		Trabajador t = new Trabajador();
		
		t.setNombre("Pep");
		t.setApellidos("Smith Smith");
		t.addHabilidad("Java");
		t.addHabilidad("SQL");
		t.addHabilidad("Javascript");
		
		return t;
	}	

	@PUT
	@Path("/verAlumnoPUT/{alu}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces("text/html")
	public String verAlumnoPUT(@PathParam("alu") String alumno) {
		return "alumno: " + alumno;
	}

	@PUT
	@Path("/verTrabajadorPUT")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_XML)
	public Trabajador verTrabajadorPUT(Trabajador t) {
		t.setNombre("Tom");
		
		return t;
	}

}
