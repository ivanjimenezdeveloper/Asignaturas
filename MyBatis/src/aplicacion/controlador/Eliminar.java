package aplicacion.controlador;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;

import aplicacion.modelo.ejb.SesionesEJB;
import aplicacion.modelo.ejb.UsuariosEJB;
import aplicacion.modelo.pojo.Usuario;
import ch.qos.logback.classic.Logger;

/**
 * Servlet implementation class Eliminar
 */
@WebServlet("/Eliminar")
public class Eliminar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Logger
	 */
	private static final Logger logger = (Logger) LoggerFactory.getLogger(Eliminar.class);
	
	/**
	 *  EJB para trabajar con usuarios
	 */
	@EJB
	UsuariosEJB usuariosEJB;
	
	/**
	 *  EJB para trabajar con sesiones
	 */
	@EJB
	SesionesEJB sesionesEJB;
	
	/**
	 * Método que trata las peticiones GET que llegan al servlet.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		HttpSession session = request.getSession(false);
		
		// Intentamos obtener el usuario de la sesión
		Usuario usuarioLogeado = sesionesEJB.usuarioLogeado(session);
		
		if(usuarioLogeado == null) {
			// Si no está logeado lo enviamos a Login
			response.sendRedirect("Login");
		}
		else {
			if(id != null) {
				try {
					Integer identificador = Integer.valueOf(id);
					usuariosEJB.deleteUsuario(identificador);
				}
				catch(Exception e) {
					logger.error(e.getMessage());
				}				
			}
			
			// Finalmente enviamos a la página principal
			response.sendRedirect("Principal");			
		}
	}

}
