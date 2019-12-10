package aplicacion.vista;

import java.io.PrintWriter;

/**
 * Clase que genera la página de login
 * @author daw
 *
 */
public class PaginaLogin {

	/**
	 * Muestra la página de login
	 * @param out El writer dónde mostrar la página
	 * @param error El error si se produjo con anterioridad
	 */
	public void muestra(PrintWriter out, String error) {
		// Pintamos la página principal
		
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE> Login en la aplicación </TITLE>");
		out.println("<META charset=\"UTF8\">");
		out.println("</HEAD>");
		out.println("<BODY>");

		out.println("<H1> Login </H1>");	
		out.println("<BR />");
		out.println("<FORM action=\"Login\" method=\"post\">");		
		out.println(" Usuario:");
		out.println("<INPUT type=\"text\" name=\"usuario\" />");
		out.println("<BR />");
		out.println("Password:");
		out.println("<INPUT type=\"password\" name=\"password\" />");
		out.println("<BR />");
		out.println("<INPUT type=\"submit\" value=\"Login\" />");
		out.println("</FORM>");
		
		// Si tenemos error lo mostramos
		if(error!=null) {
			out.println("Hay errores en el usuario o password.");
		}
		
		out.println("</BODY>");
		out.println("</HTML>");
		}	
}
