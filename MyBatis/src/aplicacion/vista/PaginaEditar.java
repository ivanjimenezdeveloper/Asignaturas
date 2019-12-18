package aplicacion.vista;

import java.io.PrintWriter;

import aplicacion.modelo.pojo.Usuario;

public class PaginaEditar {

	public void muestra(PrintWriter out, Usuario usuario) {
		// Mostramos la página principal
		out.println("<!DOCTYPE html>");
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
						
			out.println("<h2> Editar un usuario </h2>");
			out.println("<br/>");
			out.println("<br/>");

			out.println("<form action=\"Editar\" method=\"post\">");
			out.println("<input type=\"hidden\" name=\"id\" value=\"" + usuario.getId() + "\" /> ");
			out.println("<label for=\"nombre\">Nombre:</label>");
			out.println("<input type=\"text\" name=\"nombre\" value=\"" + usuario.getNombre() + "\" /> ");
			out.println("<br/>");
			out.println("<label for=\"usuario\">Usuario:</label>");
			out.println("<input type=\"text\" name=\"usuario\" value=\"" + usuario.getUsuario() + "\" /> ");
			out.println("<br/>");
			out.println("<label for=\"password\">Password:</label>");
			out.println("<input type=\"password\" name=\"password\" value=\"" + usuario.getPassword() + "\" /> ");
			out.println("<br/>");
			out.println("<input type=\"submit\" value=\"Editar\" /> ");
			out.println("</form>");

		}
		out.println("</BODY>");
		out.println("</HTML>");
	}

}