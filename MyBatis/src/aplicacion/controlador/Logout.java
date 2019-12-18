package aplicacion.controlador;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import aplicacion.modelo.ejb.SesionesEJB;

/**
 * Clase que permite hacer logout a los usuarios
 * @author daw
 *
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * EJB para trabajar con sesiones
	 */
	@EJB
	SesionesEJB sesionesEJB;
	
	/**
	 * Método que trata las peticiones GET que llegan al servlet.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		if(session!=null) {
			// Cerramos la sesión
			sesionesEJB.logoutUsuario(session);
		}
		
		// Redirigimos a la página principal
		response.sendRedirect("Principal");
	}
}
