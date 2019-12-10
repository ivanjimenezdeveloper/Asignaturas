package aplicacion.vista;

import java.io.PrintWriter;
import java.util.ArrayList;

import aplicacion.modelo.pojo.Usuario;

/**
 * Clase que genera la página principal de la aplicación
 * @author daw 
 *
 */
public class PaginaPrincipal {

	/**
	 * Muestra la página principal
	 * @param out El writer dónde mostrar la página
	 * @param listaUsuarios La lista de usuarios a mostrar
	 * @param usuario El usuario que está logeado
	 */
	public void muestra(PrintWriter out, ArrayList<Usuario> listaUsuarios, Usuario usuario) {
		// Mostramos la página principal
		
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE> Lista de usuarios </TITLE>");
		out.println("<META charset=\"UTF8\">");
		out.println("</HEAD>");
		out.println("<BODY>");

		// Tenemos usuario?
		if(usuario == null) {
			// No está logeado
			out.println("<h1> No estás logeado.</h1>");
			out.println("<br/>");
			out.println("<br/>");
			out.println("<a href=\"Login\"> Login</a>");
		}
		else {	
			// Está logeaado
			out.println("<h1> Estás logeado cómo " + usuario.getUsuario() + "</h1>");
			out.println("<br/>");
			out.println("<br/>");
			out.println("<a href=\"Logout\"> Logout</a>");			
			out.println("<br/>");
			out.println("<br/>");
			
			out.println("<TABLE>");
			out.println("<TR>");
			out.println("<TH> Id </TH>");
			out.println("<TH> Nombre </TH>");
			out.println("<TH> Usuario </TH>");
			out.println("<TH> Password </TH>");
			out.println("</TR>");		
			for(Usuario u: listaUsuarios) {
				out.println("<TR>");
				out.println("<TD>" + u.getId() + "</TD>");
				out.println("<TD>" + u.getNombre() + "</TD>");
				out.println("<TD>" + u.getUsuario() + "</TD>");
				out.println("<TD>" + u.getPassword() + "</TD>");
				out.println("</TR>");
			}
			out.println("</TABLE>");
		}
		
		out.println("</BODY>");
		out.println("</HTML>");
	}
}
