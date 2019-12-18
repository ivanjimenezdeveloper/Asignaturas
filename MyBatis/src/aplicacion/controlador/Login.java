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
import aplicacion.modelo.ejb.UsuariosEJB;
import aplicacion.modelo.pojo.Usuario;
import aplicacion.vista.PaginaLogin;

/**
 * Clase que permite realizar login a los usuarios
 * 
 * @author daw
 *
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * EJB para trabajar con usuarios
	 */
	@EJB
	UsuariosEJB usuariosEJB;

	/**
	 * EJB para trabajar con sesiones
	 */
	@EJB
	SesionesEJB sesionesEJB;

	/**
	 * Método que trata las peticiones GET que llegan al servlet
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String error = request.getParameter("error");

		// Intentamos obtener el usuario de la sesión
		Usuario usuario = sesionesEJB.usuarioLogeado(session);

		if (usuario != null) {
			// Ya está logeado, lo redirigimos a la principal
			response.sendRedirect("Principal");
		} else {
			// No está logeado, mostramos página de login
			response.setContentType("text/html; charset=UTF-8");
			PaginaLogin paginaLogin = new PaginaLogin();

			// Mostramos la página y le pasamos null porque no hay errores
			paginaLogin.muestra(response.getWriter(), error);
		}
	}

	/**
	 * Método que trata las peticiones POST que llegan al servlet
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		String user = request.getParameter("usuario");
		String pass = request.getParameter("password");

		if (session != null) {
			// Si tenemos sesión, miramos si tenemos usuario en la sesión
			Usuario usuario = usuariosEJB.existeUsuario(user, pass);
			
			// Si no tenemos usuario, es una sesión no válida y la invalidamos
			if (usuario == null) {
				sesionesEJB.logoutUsuario(session);
			}
			
			// Redirigimos a la página principal
			response.sendRedirect("Principal");
		} else {

			Usuario usuario = usuariosEJB.existeUsuario(user, pass);

			if (usuario == null) {
				// No hemos encontrado al usuario, informamos del error
				response.sendRedirect("Login?error=hay");
			} else {
				// Añadimos el usuario a la sesión
				session = request.getSession(true);
				sesionesEJB.loginUsuario(session, usuario);

				// Lo redirigimos a la página principal
				response.sendRedirect("Principal");
			}
		}
	}
}
